/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.helper;

import java.text.SimpleDateFormat;
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
     * Test of getYearString method, of class Utilities.
     */
    @Test
    public void testGetYearString() {
        System.out.println("getYearString");
        String date_format = "yyyy";
        Long longDate = new Date().getTime();
        SimpleDateFormat df2 = new SimpleDateFormat(date_format);
        Integer expResult = Integer.parseInt(df2.format(new Date(longDate)));
        Integer result = Utilities.getYearString(longDate);
        assertEquals(expResult, result);

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
        SimpleDateFormat df2 = new SimpleDateFormat(date_format);
        String expresult = df2.format(date);

        String result = Utilities.getSimpleDateFormat(date, date_format);
        assertNotNull(result);
        assertEquals(expresult, result);

    }

}
