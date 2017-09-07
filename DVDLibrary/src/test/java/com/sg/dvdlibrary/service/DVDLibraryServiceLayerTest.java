/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoStubImpl;
import com.sg.dvdlibrary.dto.DVD;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jeffc
 */
public class DVDLibraryServiceLayerTest {
    
    private DVDLibraryServiceLayer service;
    
    public DVDLibraryServiceLayerTest() {
        DVDLibraryDao dao = new DVDLibraryDaoStubImpl();
        
        service = new DVDLibraryServiceLayerImpl(dao);
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testAddDVD() throws Exception {
        
        String SKU = service.getNewSKU();
        DVD dvd = new DVD(SKU);
        dvd.setTitle("My New Movie");
        dvd.setReleaseDate("My Release Date");
        dvd.setMPAARating("My Rating");
        dvd.setDirector("My Director");
        dvd.setStudio("Studio");
        dvd.setUserNote("My User Note");
        service.addDVD(SKU, dvd);
    }
    
    @Test
    public void testAddDVDInvalidData() throws Exception {
        
        String SKU = service.getNewSKU();
        DVD dvd = new DVD(SKU);
        dvd.setTitle("My New Movie");
        dvd.setReleaseDate("My Release Date");
        dvd.setMPAARating("My Rating");
        dvd.setDirector("My Director");
        dvd.setStudio("");
        dvd.setUserNote("My User Note");
        
        try {
            service.addDVD(SKU, dvd);
            fail("Expected ClassRosterDataValidationException was not thrown");
        } catch (DVDLibraryDataValidationException e) {
            return;
        }
    }

    /**
     * Test of getAllDVDs method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testGetAllDVDs() throws Exception {
        assertEquals(3, service.getAllDVDs().size());
    }

    /**
     * Test of getDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testGetDVD() throws Exception {
        DVD dvd = service.getDVD("DL1");
        assertNotNull(dvd);
        dvd = service.getDVD("9999");
        assertNull(dvd);
    }

    /**
     * Test of removeDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testRemoveDVD() throws Exception {
        DVD dvd = service.removeDVD("DL1");
        assertNotNull(dvd);
        dvd = service.removeDVD("9999");
        assertNull(dvd);
    }

    /**
     * Test of getDVDsByTitle method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testGetDVDsByTitle() throws Exception {
        assertEquals(2, service.getDVDsByTitle("Happy Days").size());
        assertEquals(1, service.getDVDsByTitle("Unhappy Days").size());
        assertEquals(0, service.getDVDsByTitle("Not In There").size());   
    }

    /**
     * Test of verifySKU method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testVerifySKU() throws Exception {
        assertTrue(service.verifySKU("DL2"));
        assertFalse(service.verifySKU("9999"));
        
    }

    /**
     * Test of getNewSKU method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testGetNewSKU() throws Exception {
        assertEquals("DL4", service.getNewSKU());
        assertEquals("DL5", service.getNewSKU());
    }

    /**
     * Test of initializeLibrary method, of class DVDLibraryServiceLayer.
     */

    @Test
    public void testSaveOnExit() throws Exception {
        service.saveOnExit();
    }
}
