package com.nitmali.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author nitmali
 * @date 2019/1/10 16:03
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "firstDataSource")
    @Primary
    @ConfigurationProperties(prefix = "first-datasource")
    public DataSource dbOneDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix = "second-datasource")
    public DataSource dbTwoDataSource() {
        return DataSourceBuilder.create().build();
    }
}
