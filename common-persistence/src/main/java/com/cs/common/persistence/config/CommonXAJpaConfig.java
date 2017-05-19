package com.cs.common.persistence.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.cs.common.persistence.util.PersistenceConfigProperties;
import com.cs.common.persistence.util.XADataSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

/**
 * Created by sankey on 2017-05-17.
 */
@Configuration
@EnableTransactionManagement
public class CommonXAJpaConfig extends CommonJpaConfig {

    private PersistenceConfigProperties persistenceConfigProperties;

    @Autowired  private XADataSourceBuilder xaDataSourceBuilder;

    @Bean("xaPersistenceConfigProperties")
    @ConfigurationProperties("xa")
    public PersistenceConfigProperties xaPersistenceConfigProperties(){
        return new PersistenceConfigProperties();
    }

    @Autowired
    public void setPersistenceConfigProperties(@Qualifier("xaPersistenceConfigProperties") PersistenceConfigProperties xaPersistenceConfigProperties){
        this.persistenceConfigProperties=xaPersistenceConfigProperties;
    }

    @Override
    public PersistenceConfigProperties getPersistenceConfigProperties() {
        return this.persistenceConfigProperties;
    }

    @Bean("xaEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean xaEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em= super.entityManagerFactoryBean();
        em.setPersistenceUnitName(getPersistenceConfigProperties().getPeristenceUnit());
        em.setJtaDataSource(xaDataSource());
        return em;
    }

    @Bean("xaTransactionManager")
    public PlatformTransactionManager xaTransactionManager() throws Throwable {
        return new JtaTransactionManager(  userTransaction(), aTransactionManager() );
    }

//    @Override
//    public DataSource dataSource(){
//        throw new IllegalStateException("un supported data source");
//    }



    @Bean(name="xaDataSource", initMethod = "init", destroyMethod = "close")
    public DataSource xaDataSource() {

//        PGXADataSource pgxaDataSource = new PGXADataSource();
//        pgxaDataSource.setUrl(getPersistenceConfigProperties().getDataSource().getDataSourceProperties().getProperty("url"));
//        pgxaDataSource.setPassword(getPersistenceConfigProperties().getDataSource().getDataSourceProperties().getProperty("password"));
//        pgxaDataSource.setUser(getPersistenceConfigProperties().getDataSource().getDataSourceProperties().getProperty("user"));

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(xaDataSourceBuilder.build());
        xaDataSource.setUniqueResourceName("xads1");
        return xaDataSource;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "xa.dataSource.properties")
    public TransactionManager aTransactionManager() throws Throwable {
        return new UserTransactionManager();
//        UserTransactionManager userTransactionManager = new UserTransactionManager();
//        userTransactionManager.setForceShutdown(false);
//        return userTransactionManager;
    }

    @Bean
    @ConfigurationProperties(prefix = "xa.dataSource.properties")
    public UserTransaction userTransaction() throws Throwable {
        return new UserTransactionImp();
//        UserTransactionImp userTransactionImp = new UserTransactionImp();
//        userTransactionImp.setTransactionTimeout(1000);
//        return userTransactionImp;
    }
}
