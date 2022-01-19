package com.board.community.config.datasourceConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    /**
     * DB Connection Config
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "db")
    protected DataSource dataSource() {
        return DataSourceBuilder.create().build();  //LINE:: application.properties내에 설정한 DB정보를 가지고 DataSource 생성
    }


}
