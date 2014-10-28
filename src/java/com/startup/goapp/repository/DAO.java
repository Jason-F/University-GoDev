/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.goapp.repository;

import java.util.List;

/**
 *
 * @author boniface
 * @param <T>
 * @param <ID>
 */
public interface DAO<T, ID> {

    public T findById(final ID id);

    public List<T> findAll();

    public void persist(final T entity);

    public void merge(final T entity);

    public void remove(final T entity);

    public void removeById(final Long entityId);

    public List<T> findInRange(int firstResult, int maxResults);

    public long count();

    public T getByPropertyName(String name, String value);

    public List<T> getEntitiesByProperName(String name, String value);
}
