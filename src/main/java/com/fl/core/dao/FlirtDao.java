package com.fl.core.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import lombok.Setter;

@Setter
@Repository
public class FlirtDao {
    
    @Resource
    private SessionFactory sessionFactory;
    
    private Session session() {
        return sessionFactory.getCurrentSession();
    }
    
    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> clazz, String id) {
        return (T) session().get(clazz, id);
    }
    
    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> clazz, Integer id) {
        return (T) session().get(clazz, id);
    }
    
    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> clazz, Long id) {
        return (T) session().get(clazz, id);
    }
    
    public <T> void save(T rm) {
        session().save(rm);
    }
    
    public <T> void update(T rm) {
        session().saveOrUpdate(rm);
    }
    
    public <T> void delete(T rm) {
        session().delete(rm);
    }
    
    public <T> void saveOrUpdate(T data) {
        session().saveOrUpdate(data);
    }
}
