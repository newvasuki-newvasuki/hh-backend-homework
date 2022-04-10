package ru.hh.school.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.hh.nab.common.properties.FileSettings;
import ru.hh.nab.datasource.DataSourceFactory;
import ru.hh.nab.hibernate.NabHibernateProdConfig;
import ru.hh.nab.starter.NabProdConfig;
import ru.hh.school.App;
import ru.hh.school.dao.Dao;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@Import({NabHibernateProdConfig.class, NabProdConfig.class, CommonConfig.class})
public class ProdConfig {

  @Bean
  public DataSource dataSource(DataSourceFactory dataSourceFactory, FileSettings fileSettings) {
    App.limitPopularity = fileSettings.getInteger("popularity");
    return dataSourceFactory.create("master", false, fileSettings);
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
    LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
    localSessionFactoryBean.setDataSource(dataSource);
    localSessionFactoryBean.setPackagesToScan("ru.hh.school.entity");
    return localSessionFactoryBean;
  }

  @Bean
  public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
    HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
    hibernateTransactionManager.setSessionFactory(sessionFactory);
    return hibernateTransactionManager;
  }

  @Bean
  public Dao dao(SessionFactory sessionFactory){
    return new Dao(sessionFactory);
  }

}
