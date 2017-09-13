/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jeffc
 */
public class DVDLibraryDaoTest {
    
    DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
    
    public DVDLibraryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<DVD> dvdList = dao.getAllDVDs();
        for (DVD dvd : dvdList) {
            dao.removeDVD(dvd.getSKU());
        }        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testAddGetDVD() throws Exception {
        DVD dvd = new DVD("DL1");
        dvd.setTitle("Title");
        dvd.setReleaseDate(LocalDate.parse("1998-03-05"));
        dvd.setMPAARating("MPAARating");
        dvd.setDirector("Director");       
        dvd.setStudio("Studio");
        dvd.setUserNote("UserNote");
        
        dao.addDVD(dvd.getSKU(), dvd);
        
        DVD fromDao = dao.getDVD(dvd.getSKU());
        
        assertEquals(dvd, fromDao);        
        
    }

    /**
     * Test of getAllDVDs method, of class DVDLibraryDao.
     */
    @Test
    public void testGetAllDVDs() throws Exception {

        DVD dvd1 = new DVD("DL1");
        dvd1.setTitle("Title");
        dvd1.setReleaseDate(LocalDate.parse("1998-03-05"));
        dvd1.setMPAARating("MPAARating");
        dvd1.setDirector("Director");       
        dvd1.setStudio("Studio");
        dvd1.setUserNote("UserNote");
        
        dao.addDVD(dvd1.getSKU(), dvd1);
        
        DVD dvd2 = new DVD("DL2");
        dvd2.setTitle("Title");
        dvd2.setReleaseDate(LocalDate.parse("1998-03-05"));
        dvd2.setMPAARating("MPAARating");
        dvd2.setDirector("Director");       
        dvd2.setStudio("Studio");
        dvd2.setUserNote("UserNote");
        
        dao.addDVD(dvd2.getSKU(), dvd2);        

        
        assertEquals(2, dao.getAllDVDs().size());        
        
    }



    /**
     * Test of removeDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testRemoveDVD() throws Exception {
        
        DVD dvd1 = new DVD("DL1");
        dvd1.setTitle("Title");
        dvd1.setReleaseDate(LocalDate.parse("1998-03-05"));
        dvd1.setMPAARating("MPAARating");
        dvd1.setDirector("Director");       
        dvd1.setStudio("Studio");
        dvd1.setUserNote("UserNote");
        
        dao.addDVD(dvd1.getSKU(), dvd1);
        
        DVD dvd2 = new DVD("DL2");
        dvd2.setTitle("Title");
        dvd2.setReleaseDate(LocalDate.parse("1998-03-05"));
        dvd2.setMPAARating("MPAARating");
        dvd2.setDirector("Director");       
        dvd2.setStudio("Studio");
        dvd2.setUserNote("UserNote");
        
        dao.addDVD(dvd2.getSKU(), dvd2);        

        
        dao.removeDVD(dvd1.getSKU());
        
        assertEquals(1, dao.getAllDVDs().size());
        
        assertNull(dao.getDVD(dvd1.getSKU()));
        
        dao.removeDVD(dvd2.getSKU());
        
        assertEquals(0, dao.getAllDVDs().size());
        
        assertNull(dao.getDVD(dvd2.getSKU()));        
        
    }

    /**
     * Test of getDVDsByTitle method, of class DVDLibraryDao.
     */
    @Test
    public void testGetDVDsByTitle() throws Exception {
    
        DVD dvd1 = new DVD("DL1");
        dvd1.setTitle("Title");
        dvd1.setReleaseDate(LocalDate.parse("1998-03-05"));
        dvd1.setMPAARating("MPAARating");
        dvd1.setDirector("Director");       
        dvd1.setStudio("Studio");
        dvd1.setUserNote("UserNote");
        
        dao.addDVD(dvd1.getSKU(), dvd1);
        
        DVD dvd2 = new DVD("DL2");
        dvd2.setTitle("Title");
        dvd2.setReleaseDate(LocalDate.parse("1998-03-05"));
        dvd2.setMPAARating("MPAARating");
        dvd2.setDirector("Director");       
        dvd2.setStudio("Studio");
        dvd2.setUserNote("UserNote");
        
        dao.addDVD(dvd2.getSKU(), dvd2);
        
        DVD dvd3 = new DVD("DL3");
        dvd3.setTitle("Not Title");
        dvd3.setReleaseDate(LocalDate.parse("1998-03-05"));
        dvd3.setMPAARating("MPAARating");
        dvd3.setDirector("Director");       
        dvd3.setStudio("Studio");
        dvd3.setUserNote("UserNote");
        
        dao.addDVD(dvd3.getSKU(), dvd3);
        
        assertEquals(2, dao.getDVDsByTitle("Title").size());
        
    }

    /**
     * Test of verifySKU method, of class DVDLibraryDao.
     */
    @Test
    public void testVerifySKU() throws Exception {
        
        String SKU = "DL1";
        DVD dvd = new DVD(SKU);
        dvd.setTitle("Title");
        dvd.setReleaseDate(LocalDate.parse("1998-03-05"));
        dvd.setMPAARating("MPAARating");
        dvd.setDirector("Director");       
        dvd.setStudio("Studio");
        dvd.setUserNote("UserNote");
        
        dao.addDVD(dvd.getSKU(), dvd);
        
        DVD fromDAO = dao.getDVD(SKU);
        
        SKU = fromDAO.getSKU();
                       
        assertTrue(dao.verifySKU(SKU));
    }

    /**
     * Test of getNewSKU method, of class DVDLibraryDao.
     */
    @Test
    public void testGetNewSKU() throws Exception {
        
        DVD dvd1 = new DVD("DL1");
        dvd1.setTitle("Title");
        dvd1.setReleaseDate(LocalDate.parse("1998-03-05"));
        dvd1.setMPAARating("MPAARating");
        dvd1.setDirector("Director");       
        dvd1.setStudio("Studio");
        dvd1.setUserNote("UserNote");
        
        dao.addDVD(dvd1.getSKU(), dvd1);
        
        assertEquals("DL1", dao.getNewSKU());
        assertEquals("DL2", dao.getNewSKU());
        
    }
    
    /**
     * Test of getAllMoviesReleasedInLastNYears method, of class DVDLibraryDao.
     */
    @Test
    public void testGetAllMoviesReleasedInLastNYears() throws Exception {
        
        DVD dvd1 = new DVD("DL1");
        dvd1.setTitle("One");
        dvd1.setReleaseDate(LocalDate.now().minusYears(1));
        dvd1.setMPAARating("MPAARating");
        dvd1.setDirector("Director");       
        dvd1.setStudio("Studio");
        dvd1.setUserNote("UserNote");
        
        dao.addDVD(dvd1.getSKU(), dvd1);
        
        DVD dvd2 = new DVD("DL2");
        dvd2.setTitle("Two");
        dvd2.setReleaseDate(LocalDate.now().minusYears(5));
        dvd2.setMPAARating("MPAARating");
        dvd2.setDirector("Director");       
        dvd2.setStudio("Studio");
        dvd2.setUserNote("UserNote");
        
        dao.addDVD(dvd2.getSKU(), dvd2);
        
        DVD dvd3 = new DVD("DL3");
        dvd3.setTitle("Three");
        dvd3.setReleaseDate(LocalDate.now().minusYears(10));
        dvd3.setMPAARating("MPAARating");
        dvd3.setDirector("Director");       
        dvd3.setStudio("Studio");
        dvd3.setUserNote("UserNote");
        
        dao.addDVD(dvd3.getSKU(), dvd3);
        
        List<DVD> searchResults = dao.getAllMoviesReleasedInLastNYears(0);
        assertEquals(searchResults.size(), 0);
        
        searchResults = dao.getAllMoviesReleasedInLastNYears(4);
        assertEquals(searchResults.size(), 1);
        
        searchResults = dao.getAllMoviesReleasedInLastNYears(7);
        assertEquals(searchResults.size(), 2);  

        searchResults = dao.getAllMoviesReleasedInLastNYears(12);
        assertEquals(searchResults.size(), 3);         
        
    }

    /**
     * Test of getAllMoviesWithGivenMPAARating method, of class DVDLibraryDao.
     */
    @Test
    public void testGetAllMoviesWithGivenMPAARating() throws Exception {
        
        DVD dvd1 = new DVD("DL1");
        dvd1.setTitle("One");
        dvd1.setReleaseDate(LocalDate.now().minusYears(1));
        dvd1.setMPAARating("PG-13");
        dvd1.setDirector("Director");       
        dvd1.setStudio("Studio");
        dvd1.setUserNote("UserNote");
        
        dao.addDVD(dvd1.getSKU(), dvd1);
        
        DVD dvd2 = new DVD("DL2");
        dvd2.setTitle("Two");
        dvd2.setReleaseDate(LocalDate.now().minusYears(5));
        dvd2.setMPAARating("PG-13");
        dvd2.setDirector("Director");       
        dvd2.setStudio("Studio");
        dvd2.setUserNote("UserNote");
        
        dao.addDVD(dvd2.getSKU(), dvd2);
        
        DVD dvd3 = new DVD("DL3");
        dvd3.setTitle("Three");
        dvd3.setReleaseDate(LocalDate.now().minusYears(10));
        dvd3.setMPAARating("PG-7");
        dvd3.setDirector("Director");       
        dvd3.setStudio("Studio");
        dvd3.setUserNote("UserNote");
        
        dao.addDVD(dvd3.getSKU(), dvd3);     
        
        List<DVD> searchResults = dao.getAllMoviesWithGivenMPAARating("PG-13");
        assertEquals(searchResults.size(), 2);
        
        searchResults = dao.getAllMoviesWithGivenMPAARating("PG-7");
        assertEquals(searchResults.size(), 1);  

        searchResults = dao.getAllMoviesWithGivenMPAARating("R");
        assertEquals(searchResults.size(), 0);      
        
        
    }

    /**
     * Test of getAllMoviesByGivenDirectorSortedByMPAARating method, of class DVDLibraryDao.
     */
    @Test
    public void testGetAllMoviesByGivenDirectorSortedByMPAARating() throws Exception {
        
        
        
    }

    /**
     * Test of getAllMoviesReleasedByStudio method, of class DVDLibraryDao.
     */
    @Test
    public void testGetAllMoviesReleasedByStudio() throws Exception {
    
        DVD dvd1 = new DVD("DL1");
        dvd1.setTitle("One");
        dvd1.setReleaseDate(LocalDate.now().minusYears(1));
        dvd1.setMPAARating("PG-13");
        dvd1.setDirector("Director");       
        dvd1.setStudio("Studio1");
        dvd1.setUserNote("UserNote");
        
        dao.addDVD(dvd1.getSKU(), dvd1);
        
        DVD dvd2 = new DVD("DL2");
        dvd2.setTitle("Two");
        dvd2.setReleaseDate(LocalDate.now().minusYears(5));
        dvd2.setMPAARating("PG-13");
        dvd2.setDirector("Director");       
        dvd2.setStudio("Studio2");
        dvd2.setUserNote("UserNote");
        
        dao.addDVD(dvd2.getSKU(), dvd2);
        
        DVD dvd3 = new DVD("DL3");
        dvd3.setTitle("Three");
        dvd3.setReleaseDate(LocalDate.now().minusYears(10));
        dvd3.setMPAARating("PG-7");
        dvd3.setDirector("Director");       
        dvd3.setStudio("Studio1");
        dvd3.setUserNote("UserNote");
        
        dao.addDVD(dvd3.getSKU(), dvd3);     
        
        List<DVD> searchResults = dao.getAllMoviesReleasedByStudio("Studio1");
        assertEquals(searchResults.size(), 2);
        
        searchResults = dao.getAllMoviesReleasedByStudio("Stuido2");
        assertEquals(searchResults.size(), 1);  

        searchResults = dao.getAllMoviesReleasedByStudio("Studio");
        assertEquals(searchResults.size(), 0);   
        
        
    }

    /**
     * Test of getAverageAgeOfAllMovies method, of class DVDLibraryDao.
     */
    @Test
    public void testGetAverageAgeOfAllMovies() throws Exception {
        
        DVD dvd1 = new DVD("DL1");
        dvd1.setTitle("One");
        dvd1.setReleaseDate(LocalDate.now().minusYears(1));
        dvd1.setMPAARating("PG-13");
        dvd1.setDirector("Director");       
        dvd1.setStudio("Studio1");
        dvd1.setUserNote("UserNote");
        
        dao.addDVD(dvd1.getSKU(), dvd1);
        
        DVD dvd2 = new DVD("DL2");
        dvd2.setTitle("Two");
        dvd2.setReleaseDate(LocalDate.now().minusYears(5));
        dvd2.setMPAARating("PG-13");
        dvd2.setDirector("Director");       
        dvd2.setStudio("Studio2");
        dvd2.setUserNote("UserNote");
        
        dao.addDVD(dvd2.getSKU(), dvd2);
        
        DVD dvd3 = new DVD("DL3");
        dvd3.setTitle("Three");
        dvd3.setReleaseDate(LocalDate.now().minusYears(9));
        dvd3.setMPAARating("PG-7");
        dvd3.setDirector("Director");       
        dvd3.setStudio("Studio1");
        dvd3.setUserNote("UserNote");      
        
        assertEquals(dao.getAverageAgeOfAllMovies(), LocalDate.now().minusYears(5));
        
    }

    /**
     * Test of getNewestMovie method, of class DVDLibraryDao.
     */
    @Test
    public void testGetNewestMovie() throws Exception {
        
        DVD dvd1 = new DVD("DL1");
        dvd1.setTitle("One");
        dvd1.setReleaseDate(LocalDate.now().minusYears(1));
        dvd1.setMPAARating("PG-13");
        dvd1.setDirector("Director");       
        dvd1.setStudio("Studio1");
        dvd1.setUserNote("UserNote");
        
        dao.addDVD(dvd1.getSKU(), dvd1);
        
        DVD dvd2 = new DVD("DL2");
        dvd2.setTitle("Two");
        dvd2.setReleaseDate(LocalDate.now().minusYears(1));
        dvd2.setMPAARating("PG-13");
        dvd2.setDirector("Director");       
        dvd2.setStudio("Studio2");
        dvd2.setUserNote("UserNote");
        
        dao.addDVD(dvd2.getSKU(), dvd2);
        
        DVD dvd3 = new DVD("DL3");
        dvd3.setTitle("Three");
        dvd3.setReleaseDate(LocalDate.now().minusYears(10));
        dvd3.setMPAARating("PG-7");
        dvd3.setDirector("Director");       
        dvd3.setStudio("Studio1");
        dvd3.setUserNote("UserNote");
        
        
        List<DVD> searchResults = dao.getNewestMovie();
        assertEquals(searchResults.size(), 2);
        
        dvd2.setReleaseDate(LocalDate.now().minusYears(5));
        searchResults = dao.getNewestMovie();
        assertEquals(searchResults.size(), 1);
        DVD currentDVD = searchResults.get(0);
        assertTrue(currentDVD.getTitle().equals("One"));

    }

    /**
     * Test of getOldestMovie method, of class DVDLibraryDao.
     */
    @Test
    public void testGetOldestMovie() throws Exception {
        
        DVD dvd1 = new DVD("DL1");
        dvd1.setTitle("One");
        dvd1.setReleaseDate(LocalDate.now().minusYears(1));
        dvd1.setMPAARating("PG-13");
        dvd1.setDirector("Director");       
        dvd1.setStudio("Studio1");
        dvd1.setUserNote("UserNote");
        
        dao.addDVD(dvd1.getSKU(), dvd1);
        
        DVD dvd2 = new DVD("DL2");
        dvd2.setTitle("Two");
        dvd2.setReleaseDate(LocalDate.now().minusYears(10));
        dvd2.setMPAARating("PG-13");
        dvd2.setDirector("Director");       
        dvd2.setStudio("Studio2");
        dvd2.setUserNote("UserNote");
        
        dao.addDVD(dvd2.getSKU(), dvd2);
        
        DVD dvd3 = new DVD("DL3");
        dvd3.setTitle("Three");
        dvd3.setReleaseDate(LocalDate.now().minusYears(10));
        dvd3.setMPAARating("PG-7");
        dvd3.setDirector("Director");       
        dvd3.setStudio("Studio1");
        dvd3.setUserNote("UserNote");
        
        List<DVD> searchResults = dao.getNewestMovie();
        assertEquals(searchResults.size(), 2);
        
        dvd2.setReleaseDate(LocalDate.now().minusYears(5));
        searchResults = dao.getNewestMovie();
        assertEquals(searchResults.size(), 1);
        DVD currentDVD = searchResults.get(0);
        assertTrue(currentDVD.getTitle().equals("Three"));
        
    }

    /**
     * Test of getAverageNumberOfNotesPerMovie method, of class DVDLibraryDao.
     */
    @Test
    public void testGetAverageNumberOfNotesPerMovie() throws Exception {
        
    }    

    /**
     * Test of initializeLibrary method, of class DVDLibraryDao.
     */

}
