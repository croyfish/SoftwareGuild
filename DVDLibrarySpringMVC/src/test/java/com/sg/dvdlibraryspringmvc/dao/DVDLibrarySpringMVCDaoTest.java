/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.DVD;
import java.time.LocalDate;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jeffc
 */
public class DVDLibrarySpringMVCDaoTest {
    
    private DVDLibrarySpringMVCDao dao;
    
    public DVDLibrarySpringMVCDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
      ApplicationContext ctx
        = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        dao = ctx.getBean("DVDLibraryDao", DVDLibrarySpringMVCDao.class);

        // delete all dvds
        List<DVD> dvds = dao.getAllDVDs();
        for (DVD currentDVD : dvds) {
            dao.deleteDVD(Integer.parseInt(currentDVD.getSKU()));
        }    
    }
    
 @Test
    public void addGetDVD() {
        
        DVD dvd = new DVD();
        dvd.setTitle("Aliens");
        dvd.setReleaseDate(LocalDate.parse("2017-01-01"));
        dvd.setMPAARating("PG-7");
        dvd.setDirector("Smith");
        dvd.setStudio("Warner Brothers");
        dvd.setUserNote("It's a pretty good film.");
        
        dao.addDVD(dvd);

        DVD fromDao = dao.getDVDBySKU(Integer.parseInt(dvd.getSKU()));
        assertEquals(fromDao, dvd);
    }

    @Test
    public void deleteDVD() {
        DVD dvd = new DVD();
        dvd.setTitle("Aliens");
        dvd.setReleaseDate(LocalDate.parse("2017-01-01"));
        dvd.setMPAARating("PG-7");
        dvd.setDirector("Smith");
        dvd.setStudio("Warner Brothers");
        dvd.setUserNote("It's a pretty good film.");
        
        dao.addDVD(dvd);

        DVD fromDao = dao.getDVDBySKU(Integer.parseInt(dvd.getSKU()));
        assertEquals(fromDao, dvd);
        dao.deleteDVD(Integer.parseInt(dvd.getSKU()));
        assertNull(dao.getDVDBySKU(Integer.parseInt(dvd.getSKU())));
    }
    
}
