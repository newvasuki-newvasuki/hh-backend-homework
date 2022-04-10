package ru.hh.school.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.hh.school.dao.Dao;
import ru.hh.school.entity.Area;
import ru.hh.school.entity.Employer;
import ru.hh.school.hhEmployerDto.HhEmployerDto;
import ru.hh.school.hhEmployersDto.HhEmployerItem;
import ru.hh.school.hhEmployersDto.HhEmployersDto;
import ru.hh.school.utils.JsonBodyHandler;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;

@Singleton
@Path("/")
public class EmployerHttpResource {

  private static final Logger logger = LoggerFactory.getLogger(EmployerHttpResource.class);

  @Autowired
  private volatile Dao dao;

  @GET
  @Path("/employer/{employer_id}")
  @Produces(MediaType.APPLICATION_JSON)
  public HhEmployerDto getEmployerFromHhOverHttp(@PathParam("employer_id") Long employerId){
    String stringOfRequest = "https://api.hh.ru/employers/" + employerId.toString();

    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest requestOfEmployer = HttpRequest.newBuilder(URI.create(stringOfRequest))
                                               .header("accept","application/json")
                                               .build();
    HttpResponse<Supplier<HhEmployerDto>> response = null;
    try {
      response = httpClient.send(requestOfEmployer,
                                 new JsonBodyHandler<>(HhEmployerDto.class));
    }
    catch (IOException exception){
      logger.info("IOException");
      exception.printStackTrace();
    }
    catch (InterruptedException exception){
      logger.info("InterruptedException");
      exception.printStackTrace();
    }
    return response.statusCode() == 200?response.body().get():null;
  }

  @POST
  @Path("/favorites/employer")
  public void addEmployerToFavorites(@QueryParam("employer_id") Long employerId,
                                     @DefaultValue("") @QueryParam("comment") String comment){
    Employer employer = dao.findById(Employer.class,employerId);
    if( employer == null) {
      HhEmployerDto hhEmployerDto = getEmployerFromHhOverHttp(employerId);
      if(hhEmployerDto != null){
        employer = new Employer();
        employer.setId(employerId);
        setInfoFieldForEmployer(employer,hhEmployerDto);// пока area нет в базе, блокируем её, чтобы никто не закинул
                                                        // и не произошло наложение
        synchronized (dao){if (dao.findById(Area.class,employer.getArea().getId()) == null) dao.save(employer.getArea());}
        employer.setDateCreate(LocalDateTime.now());
        employer.setComment(comment);
        employer.setViewsCount(0);
        dao.save(employer);
      }
    }
  }


  @GET
  @Path("/employer")
  @Produces(MediaType.APPLICATION_JSON)
  public List<HhEmployerItem> listOfEmployers(@QueryParam("query") String query,
                                              @QueryParam("page") Integer page,
                                              @QueryParam("per_page") Integer perPage) {
    String stringOfRequest ="https://api.hh.ru/employers?" +
                            "text=" + query + "&" +
                            "per_page=" + perPage + "&" +
                            "page=" + page;

    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest requestOfListEmployers = HttpRequest.newBuilder(URI.create(stringOfRequest))
                                                    .header("accept","application/json")
                                                    .build();
    HttpResponse<Supplier<HhEmployersDto>> response = null;
    try{
      response = httpClient.send(requestOfListEmployers,
                                 new JsonBodyHandler<>(HhEmployersDto.class));}
    catch (IOException exception){
      logger.info("IOException");
      exception.printStackTrace();
    }
    catch (InterruptedException exception){
      logger.info("InterruptedException");
      exception.printStackTrace();
    }
    return response.statusCode() == 200?response.body().get().getItems():null;
  }

  @GET
  @Path("/favorites/employer")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Employer> getFavoritesEmployers(@QueryParam("page") Integer page,
                                              @QueryParam("per_page") Integer per_page){
    List<Employer> listEmployers = dao.getQueryList("FROM Employer employer",
                                    page * per_page,
                                                    per_page);
    if(listEmployers != null) {
      //поскольку данные о просмотрах уже изменились, следует заблокировать чтение бд до обновления данных
      listEmployers.forEach((employer) -> {
        synchronized (dao) {
          employer.setViewsCount(employer.getViewsCount() + 1);
          dao.update(employer);
        }
      });
    }
    return listEmployers;
  }

  @PUT
  @Path("/favorites/employer/{employer_id}")
  public void changeCommentToEmployer(@PathParam("employer_id") Long employerId,
                                      @QueryParam("comment") String comment){
    Employer employer = dao.findById(Employer.class, employerId);
    if(employer != null){
      synchronized (dao){// поскольку данные придётся менять, блокируем бд, чтобы не были прочитаны устаревшие данные
        employer.setComment(comment);
        dao.update(employer);
      }
    }
  }

  @DELETE
  @Path("/favorites/employer/{employer_id}")
  public void deleteEmployerFromFavorites(@PathParam("employer_id") Long employerId){
    Employer employer = dao.findById(Employer.class, employerId);
    if(employer != null){
      dao.delete(employer);
    }
  }

  private void setInfoFieldForEmployer(Employer employer, HhEmployerDto hhEmployerDto){
    employer.setName(hhEmployerDto.getName());
    employer.getArea().setId(hhEmployerDto.getArea().getId());
    employer.getArea().setName(hhEmployerDto.getArea().getName());
    employer.setDescription(hhEmployerDto.getDescription());
  }

  @POST
  @Path("/favorites/employer/{employer_id}/refresh")
  public void refreshInfoAboutEmployer(@PathParam("employer_id") Long employerId){
    Employer employer = dao.findById(Employer.class, employerId);
    if(employer != null){
      HhEmployerDto hhEmployerDto = getEmployerFromHhOverHttp(employerId);
      if (hhEmployerDto != null){
        // поскольку пришли обновлённые данные
        synchronized (dao){setInfoFieldForEmployer(employer,hhEmployerDto);
                           dao.update(employer);}
      }
    }
    else {
      addEmployerToFavorites(employerId,"");
    }
  }

}
