/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.goapp.services.crud.Impl;

import com.startup.goapp.model.Person;
import com.startup.goapp.repository.GenericDAO;
import com.startup.goapp.services.crud.PersonCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SleepyCritta
 */
@Service("personCrudService")
@Transactional
public class PersonCrudServiceImpl implements PersonCrudService{
    @Autowired
    private GenericDAO<Person> dao;
    
    public final void setDao(final GenericDAO< Person> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Person.class);
    }

    public PersonCrudServiceImpl() {
      
    }
    @Override
    public Person findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Person> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Person entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Person entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Person entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Person v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Person> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Person getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Person> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }

  
}
