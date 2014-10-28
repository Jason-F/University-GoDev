/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.goapp.app.factory;

import com.startup.goapp.model.Person;

/**
 *
 * @author SleepyCritta
 */
public class PersonFactory {
    public static Person getPerson(String email, String firstName, String idNumber, String lastName,String type, String userName)
    {
        Person person = new Person();
        person.setEmail(email);
        person.setFirstName(firstName);
        person.setIdNumber(idNumber);
        person.setLastName(lastName);
        person.setType(type);
        person.setUserName(userName);
        
        return person;
    }
}
