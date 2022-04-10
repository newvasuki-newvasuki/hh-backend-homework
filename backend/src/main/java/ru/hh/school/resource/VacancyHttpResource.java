package ru.hh.school.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.hh.school.dao.Dao;
import ru.hh.school.entity.Area;
import ru.hh.school.entity.Vacancy;
import ru.hh.school.hhVacanciesDto.HhVacanciesDto;
import ru.hh.school.hhVacanciesDto.HhVacancyItem;
import ru.hh.school.hhVacancyDto.HhVacancyDto;
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
public class VacancyHttpResource {

    private static final Logger logger = LoggerFactory.getLogger(VacancyHttpResource.class);

    // переменная dao объявляется volatile поскольку учавствует в обеспечении потоконезависимости
    @Autowired
    private volatile Dao dao;

    @GET
    @Path("/vacancy/{vacancy_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public HhVacancyDto getVacancyFromHhOverHttp(@PathParam("vacancy_id") Long vacancyId){
        String stringOfRequest = "https://api.hh.ru/vacancies/" + vacancyId.toString();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest requestOfEmployer =  HttpRequest.newBuilder(URI.create(stringOfRequest))
                                                    .header("accept","application/json")
                                                    .build();
        HttpResponse<Supplier<HhVacancyDto>> response = null;
        try{
            response = httpClient.send(requestOfEmployer,
                                       new JsonBodyHandler<>(HhVacancyDto.class));}
        catch (IOException exception){
            logger.info("IOException");
            exception.printStackTrace();
        }
        catch (InterruptedException exception){
            logger.info("InterruptedException");
            exception.printStackTrace();
        }
        return response.statusCode()==200?response.body().get():null;
    }

    @GET
    @Path("/vacancy")
    @Produces(MediaType.APPLICATION_JSON)
    public List<HhVacancyItem> listOfVacancy(@QueryParam("query") String query,
                                             @QueryParam("page") Integer page,
                                             @QueryParam("per_page") Integer perPage){
        String stringOfRequest ="https://api.hh.ru/vacancies?" +
                                "text=" + query + "&" +
                                "per_page=" + perPage + "&" +
                                "page=" + page;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest requestOfListVacancy = HttpRequest.newBuilder(URI.create(stringOfRequest))
                                                      .header("accept","application/json")
                                                      .build();
        HttpResponse<Supplier<HhVacanciesDto>> response = null;
        try{response = httpClient.send(requestOfListVacancy,
                                       new JsonBodyHandler<>(HhVacanciesDto.class));}
        catch (IOException exception){
            logger.info("IOException");
            exception.printStackTrace();
        }
        catch (InterruptedException exception){
            logger.info("InterruptedException");
            exception.printStackTrace();
        }
        return response.statusCode()== 200?response.body().get().getItems():null;
    }

    @POST
    @Path("/favorites/vacancy")
    public void addVacancyToFavorites(@QueryParam("vacancy_id") Long vacancyId,
                                      @DefaultValue("") @QueryParam("comment") String comment){
        if(dao.findById(Vacancy.class,vacancyId) == null) {
            HhVacancyDto hhVacancyDto = getVacancyFromHhOverHttp(vacancyId);
            if(hhVacancyDto != null){
                Vacancy vacancy = new Vacancy();
                vacancy.setId(vacancyId);
                vacancy.setDateCreate(LocalDateTime.now());
                vacancy.setComment(comment);
                vacancy.setViewsCount(0);
                setInfoFieldForVacancy(vacancy,hhVacancyDto);
                synchronized (dao){ //чтобы не закинули в бд area между проверкой на наличие и добавлением
                    if (dao.findById(Area.class,vacancy.getArea().getId()) == null) dao.save(vacancy.getArea());
                }
                dao.save(vacancy);
            }
        }
    }

    private void setInfoFieldForVacancy(Vacancy vacancy, HhVacancyDto hhVacancyDto){
        vacancy.setName(hhVacancyDto.getName());
        vacancy.getArea().setId(hhVacancyDto.getArea().getId());
        vacancy.getArea().setName(hhVacancyDto.getArea().getName());
        vacancy.setGross(hhVacancyDto.getSalary().gross);
        vacancy.setEmployer(hhVacancyDto.getEmployer().getName());
        vacancy.setTo(hhVacancyDto.getSalary().to);
        vacancy.setFrom(hhVacancyDto.getSalary().from);
        vacancy.setCurrency(hhVacancyDto.getSalary().currency);
        vacancy.setCreatedAt(hhVacancyDto.getCreatedAt());
    }

    @DELETE
    @Path("/favorites/vacancy/{vacancy_id}")
    public void deleteVacancyFromFavorites(@PathParam("vacancy_id") Long vacancyId){
        Vacancy vacancy = dao.findById(Vacancy.class, vacancyId);
        if(vacancy != null){
            dao.delete(vacancy);
        }
    }

    @POST
    @Path("/favorites/vacancy/{vacancy_id}/refresh")
    public void refreshInfoAboutvacancy(@PathParam("vacancy_id") Long vacancyId){
        Vacancy vacancy = dao.findById(Vacancy.class, vacancyId);
        if(vacancy != null){
            HhVacancyDto hhVacancyDto = getVacancyFromHhOverHttp(vacancyId);
            if (hhVacancyDto != null) {
                // поскольку пришли обновлённые данные, следует запретить считывание не обновлённых из бд
                synchronized (dao){setInfoFieldForVacancy(vacancy, hhVacancyDto);
                                   dao.update(vacancy);}
            }
        }
        else {
            addVacancyToFavorites(vacancyId,"");
        }
    }

    @GET
    @Path("/favorites/vacancy")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vacancy> getFavoritesVacancies(@QueryParam("page") Integer page,
                                                @QueryParam("per_page") Integer per_page){
        List<Vacancy> listVacancies = dao.getQueryList("FROM Vacancy vacancy",
                                       page * per_page,
                                                       per_page);
        if (listVacancies != null) {
            // поскольку данные о просмотрах изменились, следует запретить их считыание из бд до обновления
            listVacancies.forEach((vacancy) -> {
                synchronized (dao) {
                    vacancy.setViewsCount(vacancy.getViewsCount() + 1);
                    dao.update(vacancy);
                }
            });
        }
        return listVacancies;
    }
}
