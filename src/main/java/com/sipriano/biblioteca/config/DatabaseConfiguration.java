package com.sipriano.biblioteca.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driver-class-name}")
    String driver;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);

        config.setMaximumPoolSize(5);//Máximo de conexões liberadas
        config.setMinimumIdle(1); //Tamanho inicial
        config.setPoolName("bibliotecaApi-pool");
        config.setMaxLifetime(600000); //10m
        config.setConnectionTimeout(12000);//Tempo pra tentar obter uma conexão 12s
        config.setConnectionTestQuery("SELECT 1"); //Teste pra saber se ta funcionando

        return new HikariDataSource(config);
    }

}
