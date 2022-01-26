package com.board.community.config.jpaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.board.community.common.db.jpa.repository")
public class JpaConfig {

    /**
     * EntityManagerFactory 생성
     * @param dataSource
     * @return
     */
    @Bean
    protected LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);                                         //LINE::   DBConfig에서 설정한 datasource매핑
        entityManagerFactoryBean.setPackagesToScan("com.board.community.common.db.jpa.entity");     //LINE::   Entity클래스가 있는 패키지 매핑
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());                           //LINE::   Hibernate구현체 사용 설정
        entityManagerFactoryBean.setJpaProperties(jpaProperties());                                 //LINE::   JPA 관련 속성 파일 매핑
        return entityManagerFactoryBean;
    }

    /**
     * JPA 구현체 설정
     * @return
     */
    private JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        return hibernateJpaVendorAdapter;
    }

    /**
     * JPA 관련 속성 설정
     * @return
     */
    private Properties jpaProperties() {
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.show_sql", "true");                //LINE:: SQL 쿼리문 콘솔에 출력
        jpaProperties.setProperty("hibernate.format_sql", "true");              //LINE:: SQL 쿼리문 줄바꿈 처리
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");          //LINE:: DB에 스키마 자동생성
        jpaProperties.setProperty("hibernate.use_sql_comments", "true");        //LINE:: SQL 실행문 콘솔에 출력
        return jpaProperties;
    }

    /**
     * JPA 트랜잭션매니저 설정
     * @param dataSource
     * @return
     */
    @Bean
    protected PlatformTransactionManager transactionManager(DataSource dataSource) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory(dataSource).getObject());

        return jpaTransactionManager;
    }
}
