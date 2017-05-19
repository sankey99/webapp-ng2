package com.cs.common.persistence.util;

/**
 * Created by sankey on 2017-05-18.
 */

import org.springframework.beans.BeanUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.XADataSource;
import java.util.HashMap;
import java.util.Map;
@Configuration
@ConfigurationProperties(prefix = "xa.dataSource")
public class XADataSourceBuilder {
    public void setType(Class<? extends XADataSource> type) {
        this.type = type;
    }

    public Map<String, String> getDataSourceProperties() {
        return dataSourceProperties;
    }

    public void setDataSourceProperties(Map<String, String> dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    private Class<? extends XADataSource> type;

    private ClassLoader classLoader;

    private Map<String, String> dataSourceProperties = new HashMap<String, String>();

    public static XADataSourceBuilder create() {
        return new XADataSourceBuilder();
    }

//    public static XADataSourceBuilder create() {
//        return new XADataSourceBuilder(classLoader);
//    }

    public XADataSourceBuilder() {
//        this.classLoader = classLoader;
    }

    public XADataSource build() {
        Class<? extends XADataSource> type = getType();
        XADataSource result = BeanUtils.instantiate(type);
        maybeGetDriverClassName();
        bind(result);
        return result;
    }

    private void maybeGetDriverClassName() {
        if (!this.dataSourceProperties.containsKey("driverClassName")
                && this.dataSourceProperties.containsKey("url")) {
            String url = this.dataSourceProperties.get("url");
            String driverClass = DatabaseDriver.fromJdbcUrl(url).getDriverClassName();
            this.dataSourceProperties.put("driverClassName", driverClass);
        }
    }

    private void bind(XADataSource result) {
        MutablePropertyValues properties = new MutablePropertyValues(this.dataSourceProperties);
        new RelaxedDataBinder(result).withAlias("url", "jdbcUrl")
                .withAlias("username", "user").bind(properties);
    }

    public XADataSourceBuilder type(Class<? extends XADataSource> type) {
        this.type = type;
        return this;
    }

    public XADataSourceBuilder url(String url) {
        this.dataSourceProperties.put("url", url);
        return this;
    }

    public XADataSourceBuilder driverClassName(String driverClassName) {
        this.dataSourceProperties.put("driverClassName", driverClassName);
        return this;
    }

    public XADataSourceBuilder username(String username) {
        this.dataSourceProperties.put("username", username);
        return this;
    }

    public XADataSourceBuilder password(String password) {
        this.dataSourceProperties.put("password", password);
        return this;
    }

    @SuppressWarnings("unchecked")
    public Class<? extends XADataSource> findType() {
        if (this.type != null) {
            return this.type;
        }
        return null;
    }

    private Class<? extends XADataSource> getType() {
        Class<? extends XADataSource> type = findType();
        if (type != null) {
            return type;
        }
        throw new IllegalStateException("No supported DataSource type found");
    }

}