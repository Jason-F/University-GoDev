/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.goapp.repository.jpa;

import com.startup.goapp.repository.GenericDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;

/**
 *
 * @author boniface
 * @param <T>
 */
@Repository("dao")
public class GenericJPAImpl< T extends Serializable>  implements GenericDAO<T>{
    private Class<T> clazz;
    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    EntityManager em; 
    

    @Override
    public void setClazz(final Class< T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @Override
    public T findById(final Long id) {
        return this.em.find(this.clazz, id);
    }

    @Override
    public List<T> findAll() {
        return this.em.createQuery("FROM " + this.clazz.getName()).getResultList();
    }

    @Override
    public void persist(final T entity) { 
        this.em.persist(entity);
    }

    @Override
    public void merge(final T entity) {
        this.em.merge(entity);
    }

    @Override
    public void remove(final T entity) {
        this.em.remove(entity);
    }

    @Override
    public void removeById(final Long entityId) {
        final T entity = this.findById(entityId);
        this.remove(entity);
    }

    @Override
    public List<T> findInRange(int firstResult, int maxResults) {

        return em.createQuery("SELECT a FROM " + this.clazz.getName() + " e").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(e) FROM " + this.clazz.getName() + " e").getSingleResult();
    }

    @Override
    public T getByPropertyName(String name, String value) {
        List<T> list = em.createQuery("SELECT e FROM " + this.clazz.getName() + " e WHERE e." + name + "=?1").setParameter(1, value).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<T> getEntitiesByProperName(String name, String value) {
        List<T> list = em.createQuery("SELECT e FROM  " + this.clazz.getName() + " e WHERE e." + name + "=?1").setParameter(1, value).getResultList();
        return list;
    }
}