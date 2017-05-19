package com.cs.common.service.data;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.io.Serializable;

/**
 * Created by sankey on 2017-05-19.
 */
@Service
@Transactional(readOnly = true , transactionManager = "xaTransactionManager")
public class CommonXAJpaDataAccessService extends CommonJpaDataAccessService {

    @PersistenceContext(unitName = "xa-common")
    private EntityManager xaEntityManager;

    @Override
    protected EntityManager getEntityManager(){
        return  this.xaEntityManager;
    }

    @Transactional(transactionManager = "xaTransactionManager")
    public void create(Serializable o) {
        super.create(o);
    }

    @Transactional(transactionManager = "xaTransactionManager")
    public Serializable save(Serializable o) {
        return super.save(o);
    }

    @Transactional(transactionManager = "xaTransactionManager")
    public void delete(Serializable o) {
        super.delete(o);
    }

}
