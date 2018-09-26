package com.spring.study.volt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by manikuttan on 25/7/18.
 */
@Configuration
@PropertySource(value = { "classpath:application.properties" })
public class VoltConfiguration {

    @Value("com.voltdb.jdbc.Driver")
    private String driverClassName;

    @Value("jdbc:voltdb://bos_volt_dev191:8484")
    private String url;

    @Value("volt_ui")
    private String dbUsername;

    @Value("volt_ui")
    private String dbPassword;


    @Bean(name = "voltDataSource")
    public DataSource getVoltDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .url(url)
                .username(dbUsername)
                .password(dbPassword)
                .build();

    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return  new JdbcTemplate(dataSource);
    }

}
