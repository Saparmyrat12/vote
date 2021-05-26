package com.epam.vote.repository.testInteg;



import liquibase.integration.spring.SpringLiquibase;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.postgresql.Driver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.io.IOException;

import javax.sql.DataSource;

import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;
import ru.yandex.qatools.embed.postgresql.distribution.Version;

/**
 * Configuration for embedded postgres database.
 * <p>
 * Copyright (C) 2018 epam.com
 * <p>
 * Date: Nov 30, 2018
 *
 * @author Anton Azarenka
 */
@Configuration
public class EmbeddedPostgresConfig {

    private static final String HOST = "localhost";
    private static final int PORT = 31666;
    private static final String DB_NAME = "postgres";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private String url;

    @Bean(destroyMethod = "stop")
    public EmbeddedPostgres embeddedPostgres() throws IOException {
        EmbeddedPostgres postgres = new EmbeddedPostgres(Version.V9_6_11);
        url = postgres.start(HOST, PORT, DB_NAME, USER, PASSWORD);
        return postgres;
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:common_test_data.xml");
        liquibase.setDataSource(dataSource());
        return liquibase;
    }

    @DependsOn("embeddedPostgres")
    @Bean
    public DataSource dataSource() {
        return new SimpleDriverDataSource(new Driver(), url);
    }
/**
 * Change this property to your own that all tests will work
 */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
       // sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:com.azarenka.jc.repository.mapper/*.xml"));
       // sqlSessionFactory.setTypeAliasesPackage("com.azarenka.jc.domain");
        sqlSessionFactory.setDataSource(dataSource());
       // sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:mybatis.xml"));
        sqlSessionFactory.afterPropertiesSet();
        return sqlSessionFactory;
    }
}
