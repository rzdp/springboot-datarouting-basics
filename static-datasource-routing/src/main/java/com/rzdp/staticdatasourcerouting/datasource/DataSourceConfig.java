package com.rzdp.staticdatasourcerouting.datasource;

import com.rzdp.staticdatasourcerouting.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.rzdp.staticdatasourcerouting.repository",
        transactionManagerRef = "transactionManager",
        entityManagerFactoryRef = "entityManager"
)
@EnableTransactionManagement
public class DataSourceConfig {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DataSourcePropertyConfig dataSourcePropertyConfig;

    @Bean
    @Primary
    public DataSource dataSource() {
        DataSourceRoutingConfig routingConfig = new DataSourceRoutingConfig();
        log.info("Initializing all data sources");
        Map<Object, Object> dataSources = new HashMap<>();
        dataSources.put("bangkok", getDataSource("branch"));
        dataSources.put("hongkong", getDataSource("hongkong"));
        routingConfig.initializeDatasource(dataSources);
        return routingConfig;
    }

    private DataSource getDataSource(String branch) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        DataSourcePropertyConfig.DataSourceProperty property = null;
        if (branch.equals("branch")) {
            property = dataSourcePropertyConfig.getBangkok();
        } else {
            property = dataSourcePropertyConfig.getHongkong();
        }
        dataSource.setUrl(property.getUrl());
        dataSource.setUsername(property.getUsername());
        dataSource.setPassword(property.getPassword());
        return dataSource;
    }

    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource()).packages(Employee.class)
                .build();
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager(@Autowired @Qualifier("entityManager")
            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }

}
