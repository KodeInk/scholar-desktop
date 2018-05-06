/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.users;

import java.awt.image.BufferedImage;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Manny
 */
public class AddUserIT {

    public AddUserIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getInstance method, of class AddUserUI.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        SchoolData schoolData = null;
        AddUserUI result = AddUserUI.getInstance(schoolData);
        assertNotNull(result);
        assertEquals(result.schoolData, schoolData);

    }

    /**
     * Test of initData method, of class AddUserUI.
     */
    @Test
    public void testInitData() {
        System.out.println("initData");
        AddUserUI instance = null;
        instance.initData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateRolesComboBox method, of class AddUserUI.
     */
    @Test
    public void testPopulateRolesComboBox() {
        System.out.println("populateRolesComboBox");
        AddUserUI instance = null;
        instance.populateRolesComboBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scaleImage method, of class AddUserUI.
     */
    @Test
    public void testScaleImage() throws Exception {
        System.out.println("scaleImage");
        int w = 0;
        int h = 0;
        BufferedImage img = null;
        BufferedImage expResult = null;
        BufferedImage result = AddUserUI.scaleImage(w, h, img);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFormData method, of class AddUserUI.
     */
    @Test
    public void testGetFormData() {
        System.out.println("getFormData");
        AddUserUI instance = null;
        instance.getFormData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateForm method, of class AddUserUI.
     */
    @Test
    public void testValidateForm() {
        System.out.println("validateForm");
        AddUserUI instance = null;
        instance.validateForm();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
