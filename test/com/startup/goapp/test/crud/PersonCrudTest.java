/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.goapp.test.crud;

import com.startup.goapp.app.factory.PersonFactory;
import com.startup.goapp.model.Person;
import com.startup.goapp.services.crud.PersonCrudService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author SleepyCritta
 */
public class PersonCrudTest {
    private static ApplicationContext ctx;
    private PersonCrudService personCrudService;
    private Long id;
    
     public PersonCrudTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/startup/goapp/app/conf/applicationContext-*.xml");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
   @Test
    private void createPersonTable() {
        // Create the Service Object
        personCrudService = (PersonCrudService) ctx.getBean("personCrudService");
       // Create the TaxTable using a factory Class
       Person person = PersonFactory.getPerson("test1", "test2", "test3", "test4", "test5", "test6");
        //Save the ROOT tax table into the Database
        personCrudService.persist(person);
        //Collect the ID for use in later TESTS
        id = person.getId();
        //Asssert if we have persisted the Tax Table
        Assert.assertNotNull(person);

    }
    
    @Test(dependsOnMethods = "createPersonTable")
    private void deleteTaxTable() {
         personCrudService = (PersonCrudService) ctx.getBean("personCrudService");
        Person person = personCrudService.findById(id);
        //Delete Record
        personCrudService.remove(person);
        Person deletedPerson = personCrudService.findById(id);
        // Test to See if the Record was Deleted 
         Assert.assertNull(deletedPerson);
    }
    
}
