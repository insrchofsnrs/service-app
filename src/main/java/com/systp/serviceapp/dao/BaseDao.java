package com.systp.serviceapp.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
@Repository()
public class BaseDao<T> implements Dao<T> {
    private static Logger log = Logger.getLogger(BaseDao.class);
    private SessionFactory sessionFactory;

    @Autowired
    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public T add(T t) {
        getSession().save(t);
        log.info("Save:" + t);
        return t;
    }

    public T update(T t) {
        getSession().update(t);
        log.info("Update:" + t);
        return t;
    }

    public T get(Serializable id) {
        log.info("Get:" + id);
        return (T) getSession().load(getPersistentClass(), id);
    }

    public void delete(T t) {
        log.info("Delete:" + t);
        getSession().delete(t);
    }

    public void refresh(T t) {
        log.info("Refresh:" + t);
        getSession().refresh(t);
    }

    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(getPersistentClass());
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
