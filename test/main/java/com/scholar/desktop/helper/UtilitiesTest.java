/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.helper;

import java.util.Date;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Response;
import static main.java.com.scholar.desktop.helper.Utilities.getSimpleDateFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Manny
 */
public class UtilitiesTest {

    public UtilitiesTest() {
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
     * Test of throwAndReturnSanizedErrorMessages method, of class Utilities.
     */
    @Test
    public void testThrowAndReturnSanizedErrorMessages() {
        System.out.println("throwAndReturnSanizedErrorMessages");
        Response response = null;
        Utilities.throwAndReturnSanizedErrorMessages(response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParameterForLogging method, of class Utilities.
     */
    @Test
    public void testGetParameterForLogging() {
        System.out.println("getParameterForLogging");
        Map parameter = null;
        String expResult = "";
        String result = Utilities.getParameterForLogging(parameter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logParameters method, of class Utilities.
     */
    @Test
    public void testLogParameters() {
        System.out.println("logParameters");
        String message = "";
        Map parameter = null;
        String logId = "";
        Utilities.logParameters(message, parameter, logId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ShowAlertMessage method, of class Utilities.
     */
    @Test
    public void testShowAlertMessage() {
        System.out.println("ShowAlertMessage");
        javax.ws.rs.core.Response response = null;
        Utilities.ShowAlertMessage(response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOffset method, of class Utilities.
     */
    @Test
    public void testGetOffset() {
        System.out.println("getOffset");
        Integer offset = null;
        Integer expResult = null;
        Integer result = Utilities.getOffset(offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLimit method, of class Utilities.
     */
    @Test
    public void testGetLimit() {
        System.out.println("getLimit");
        Integer limit = null;
        Integer expResult = null;
        Integer result = Utilities.getLimit(limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeRowsFromDefaultModel method, of class Utilities.
     */
    @Test
    public void testRemoveRowsFromDefaultModel() {
        System.out.println("removeRowsFromDefaultModel");
        DefaultTableModel defaultTableModel = null;
        Utilities.removeRowsFromDefaultModel(defaultTableModel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ShowDialogMessage method, of class Utilities.
     */
    @Test
    public void testShowDialogMessage() {
        System.out.println("ShowDialogMessage");
        String message = "";
        Utilities.ShowDialogMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initDialogJLabel method, of class Utilities.
     */
    @Test
    public void testInitDialogJLabel() {
        System.out.println("initDialogJLabel");
        String message = "";
        JLabel expResult = null;
        JLabel result = Utilities.initDialogJLabel(message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hideDialog method, of class Utilities.
     */
    @Test
    public void testHideDialog() {
        System.out.println("hideDialog");
        Utilities.hideDialog();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toISO8601UTC method, of class Utilities.
     */
    @Test
    public void testToISO8601UTC() {
        System.out.println("toISO8601UTC");
        Date date = null;
        Date expResult = null;
        Date result = Utilities.toISO8601UTC(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fromISO8601UTC method, of class Utilities.
     */
    @Test
    public void testFromISO8601UTC() {
        System.out.println("fromISO8601UTC");
        String dateStr = "";
        Date expResult = null;
        Date result = Utilities.fromISO8601UTC(dateStr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toISO8601Local method, of class Utilities.
     */
    @Test
    public void testToISO8601Local() {
        System.out.println("toISO8601Local");
        Date date = null;
        String expResult = "";
        String result = Utilities.toISO8601Local(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fromISO8601Local method, of class Utilities.
     */
    @Test
    public void testFromISO8601Local() {
        System.out.println("fromISO8601Local");
        String dateStr = "";
        Date expResult = null;
        Date result = Utilities.fromISO8601Local(dateStr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hideColumn method, of class Utilities.
     */
    @Test
    public void testHideColumn() {
        System.out.println("hideColumn");
        Integer columnIndex = null;
        JTable jTable = null;
        Utilities.hideColumn(columnIndex, jTable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFullDateString method, of class Utilities.
     */
    @Test
    public void testGetFullDateString() {
        System.out.println("getFullDateString");
        Long longDate = null;
        String expResult = "";
        String result = Utilities.getFullDateString(longDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYearString method, of class Utilities.
     */
    @Test
    public void testGetYearString() {
        System.out.println("getYearString");
        Long longDate = null;
        Integer expResult = null;
        Integer result = Utilities.getYearString(longDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSimpleDateFormat method, of class Utilities.
     */
    @Test
    public void testGetSimpleDateFormatWithNullParams() {
        System.out.println("getSimpleDateFormat");
        Date date = null;
        String date_format = "";
        String expResult = "";
        String result = Utilities.getSimpleDateFormat(date, date_format);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetSimpleDateFormat() {
        System.out.println("getSimpleDateFormat");
        Date date = new Date();
        String date_format = "dd MMM, yyyy";
        String expresult = getSimpleDateFormat(date, date_format);
        String result = Utilities.getSimpleDateFormat(date, date_format);
        assertNotNull(result);
        assertEquals(expresult, result);

    }

}
