package com.cs.common.service.data;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created by sankey on 2017-05-14.
 */
@Service
@Transactional(readOnly = true)
public class CommonJpaDataAccessService {

    @PersistenceContext(unitName = "common")
    EntityManager entityManager;

    protected  EntityManager getEntityManager(){
        return  this.entityManager;
    }

    @Transactional()
    public void create(Serializable o) {
        getEntityManager().persist(o);
    }

    @Transactional
    public Serializable save(Serializable o) {
        return getEntityManager().merge(o);
    }

    @Transactional
    public void delete(Serializable o) {
        getEntityManager().remove(o);
    }

    public Serializable find(Class clazz, Serializable o) {
        return (Serializable) getEntityManager().find(clazz, o);

    }
}
