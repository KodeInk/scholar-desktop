/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.helper;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.Response;


/**
 *
 * @author mover 2/9/2018
 */
public class Utilities {
    private static final Logger LOG = Logger.getLogger(Utilities.class.getName());


    public static void throwAndReturnSanizedErrorMessages(Response response) {

    }

    public static String getParameterForLogging(Map parameter) {
        try {

                return "none";

        } catch (Exception ex) {
            return "--- parameter conversion error ---";
        }
    }

    public static void logParameters(String message, Map parameter, String logId) {
        String parameterLog = getParameterForLogging(parameter);
        if (parameterLog.charAt(0) == '-') {
            LOG.log(Level.SEVERE, "{0} :: log parameters failed", logId);
        } else {
            LOG.log(Level.INFO, "{0} :: {1}: {2}", new Object[]{logId, message, parameterLog});
        }
    }


}
