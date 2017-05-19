package com.cs.common.persistence.config;

import com.cs.common.persistence.util.PersistenceConfigProperties;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by sankey on 2017-05-11.
 */
@Configuration
@EnableTransactionManagement()
public class CommonJpaConfig {

    @Autowired
    private PersistenceConfigProperties persistenceConfigProperties;

    public PersistenceConfigProperties getPersistenceConfigProperties() {
        return persistenceConfigProperties;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan(getPersistenceConfigProperties().getDomainPackage());
        em.setJpaProperties(getPersistenceConfigProperties().getHibernate());
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setDataSource(dataSource());
//        em.setPersistenceUnitName(getPersistenceConfigProperties().getPeristenceUnit());
        em.setPersistenceUnitName("common");
        return em;
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        return new HikariDataSource(getPersistenceConfigProperties().getDataSource());
    }
}
