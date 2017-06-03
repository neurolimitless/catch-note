package com.hido.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.hido.dao")
public class JPAConfiguration {

  @Autowired
  Environment env;

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    em.setDataSource(dataSource(env));
    adapter.setDatabase(Database.H2);
    adapter.setGenerateDdl(true);
    adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
    em.setJpaVendorAdapter(adapter);
    em.setPackagesToScan("com.hido");
    return em;
  }

  @ConfigurationProperties(prefix = "application.properties")
  @Bean
  @Primary
  public DataSource dataSource(Environment environment) {
    DataSource dataSource = new DataSource();
    dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
    dataSource.setUsername(environment.getProperty("jdbc.username"));
    dataSource.setUrl(environment.getProperty("jdbc.url"));
    return dataSource;
  }

  @Bean
  @Autowired
  public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager txManager = new JpaTransactionManager();
    JpaDialect jpaDialect = new HibernateJpaDialect();
    txManager.setEntityManagerFactory(entityManagerFactory);
    txManager.setJpaDialect(jpaDialect);
    return txManager;
  }

}
