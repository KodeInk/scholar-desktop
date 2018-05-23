/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.roles;

import java.util.List;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.role.response.RoleResponse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Manny
 */
public class RolesServiceIT {

    public RolesServiceIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getInstance method, of class RolesService.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        SchoolData schoolData = null;
        RolesService expResult = null;
        RolesService result = RolesService.getInstance(schoolData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class RolesService.
     */
    @Test
    public void testList_0args() {
        System.out.println("list");
        RolesService instance = null;
        List<RoleResponse> expResult = null;
        List<RoleResponse> result = instance.list();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class RolesService.
     */
    @Test
    public void testList_Integer_Integer() {
        System.out.println("list");
        Integer offset = null;
        Integer limit = null;
        RolesService instance = null;
        List<RoleResponse> expResult = null;
        List<RoleResponse> result = instance.list(offset, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
