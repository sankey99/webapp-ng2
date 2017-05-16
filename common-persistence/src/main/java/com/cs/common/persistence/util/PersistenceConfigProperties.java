package com.cs.common.persistence.util;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by sankey on 2017-05-14.
 */
@Configuration
@ConfigurationProperties
@EnableConfigurationProperties({PersistenceConfigProperties.class})
public class PersistenceConfigProperties {

    private String domainPackage;
    private HikariConfig dataSource = new HikariConfig();
    private Properties hibernate = new Properties();

    public Properties getHibernate() {
        return hibernate;
    }

    public void setHibernate(Properties hibernate) {
        this.hibernate = hibernate;
    }

    public HikariConfig getDataSource() {
        return dataSource;
    }

    public void setDataSource(HikariConfig dataSourceProperties) {
        this.dataSource = dataSourceProperties;
    }

    public String getDomainPackage() {
        return domainPackage;
    }

    public void setDomainPackage(String domainPackage) {
        this.domainPackage = domainPackage;
    }

}