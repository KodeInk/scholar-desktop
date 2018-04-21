/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.user.request;

import com.codemovers.scholar.engine.helper.enums.StatusEnum;
import main.java.com.scholar.desktop.engine.caller.api.v1.profile.request.Profile;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mover
 */
public class UserIT {

    public UserIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        User instance = getInstance();
        instance.setId(1);
        Integer expResult = 1;
        Integer result = instance.getId();
        assertEquals(expResult, result);

    }


    /**
     * Test of setId method, of class User.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = 1;
        User instance = getInstance();
        instance.setId(id);

    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = getInstance();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        User instance = getInstance();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = getInstance();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = getInstance();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmailaddress method, of class User.
     */
    @Test
    public void testGetEmailaddress() {
        System.out.println("getEmailaddress");
        User instance = getInstance();
        String expResult = "";
        String result = instance.getEmailaddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmailaddress method, of class User.
     */
    @Test
    public void testSetEmailaddress() {
        System.out.println("setEmailaddress");
        String emailaddress = "";
        User instance = getInstance();
        instance.setEmailaddress(emailaddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class User.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        User instance = getInstance();
        StatusEnum expResult = null;
        StatusEnum result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class User.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        StatusEnum status = null;
        User instance = getInstance();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExternalid method, of class User.
     */
    @Test
    public void testGetExternalid() {
        System.out.println("getExternalid");
        User instance = getInstance();
        String expResult = "";
        String result = instance.getExternalid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExternalid method, of class User.
     */
    @Test
    public void testSetExternalid() {
        System.out.println("setExternalid");
        String externalid = "";
        User instance = getInstance();
        instance.setExternalid(externalid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate_created method, of class User.
     */
    @Test
    public void testGetDate_created() {
        System.out.println("getDate_created");
        User instance = getInstance();
        String expResult = "";
        Long result = instance.getDate_created();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate_created method, of class User.
     */
    @Test
    public void testSetDate_created() {
        System.out.println("setDate_created");
        Long date_created = null;
        User instance = getInstance();
        instance.setDate_created(date_created);
        assertEquals(date_created, instance.getDate_created());

    }

    /**
     * Test of getRoles method, of class User.
     */
    @Test
    public void testGetRoles() {
        System.out.println("getRoles");
        User instance = getInstance();
        String[] expResult = null;
        String[] result = instance.getRoles();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoles method, of class User.
     */
    @Test
    public void testSetRoles() {
        System.out.println("setRoles");
        String[] roles = null;
        User instance = getInstance();
        instance.setRoles(roles);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProfile method, of class User.
     */
    @Test
    public void testGetProfile() {
        System.out.println("getProfile");
        User instance = getInstance();
        Profile expResult = null;
        Profile result = instance.getProfile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProfile method, of class User.
     */
    @Test
    public void testSetProfile() {
        System.out.println("setProfile");
        Profile profile = null;
        User instance = getInstance();
        instance.setProfile(profile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class User.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        User instance = getInstance();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        User instance = getInstance();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = getInstance();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public User getInstance() {
        User instance = new User();
        return instance;
    }

}
