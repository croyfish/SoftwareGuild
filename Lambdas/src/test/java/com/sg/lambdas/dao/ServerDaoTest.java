/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lambdas.dao;

import com.sg.lambdas.dto.Server;
import com.sg.lambdas.dto.ServerDao;
import com.sg.lambdas.dto.ServerDaoInMemImpl;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeffc
 */
public class ServerDaoTest {
    
    public ServerDaoTest() {
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
     * Test of addServer method, of class ServerDao.
     */
    @Test
    public void testAddServer() {
    }

    /**
     * Test of getServer method, of class ServerDao.
     */
    @Test
    public void testGetServer() {
    }

    /**
     * Test of removeServer method, of class ServerDao.
     */
    @Test
    public void testRemoveServer() {
    }

    /**
     * Test of getAllServers method, of class ServerDao.
     */
    @Test
    public void testGetAllServers() {
    }

    /**
     * Test of getAllServersGroupByManufacturer method, of class ServerDao.
     */
    @Test
    public void testGetAllServersGroupByManufacturer() {
    }

    /**
     * Test of getServersByManufacturer method, of class ServerDao.
     */
    @Test
    public void testGetServersByManufacturer() {
        
        ServerDao dao = new ServerDaoInMemImpl();
        
        Server s1 = new Server();
        s1.setManufacturer("Dell");
        s1.setName("One");
        
        Server s2 = new Server();
        s2.setManufacturer("HP");
        s1.setName("Two");        
        
        Server s3 = new Server();
        s3.setManufacturer("Dell");
        s1.setName("Three");
        
        dao.addServer(s1);
        dao.addServer(s2);
        dao.addServer(s3);
        
        List<Server> results = dao.getServersByManufacturer("Dell");
        
        assertTrue(results.size() == 2);
        
        for (Server s : results) {
            assertEquals("Dell", s.getManufacturer());
        }
        
    }

    /**
     * Test of getServersOlderThan method, of class ServerDao.
     */
    @Test
    public void testGetServersOlderThan() {
    }

    /**
     * Test of getServersOlderThanGroupByManufacturer method, of class ServerDao.
     */
    @Test
    public void testGetServersOlderThanGroupByManufacturer() {
    }

    /**
     * Test of getAverageServerAge method, of class ServerDao.
     */
    @Test
    public void testGetAverageServerAge() {
    }
    
}
