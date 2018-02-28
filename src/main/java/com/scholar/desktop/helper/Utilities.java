/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.helper;

import java.awt.HeadlessException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.ws.Response;
import main.java.com.scholar.desktop.helper.exceptions.Message;


/**
 *
 * @author mover 2/9/2018
 */
public class Utilities {
    private static final Logger LOG = Logger.getLogger(Utilities.class.getName());

    public static final Integer default_offset = 0;
    public static final Integer default_limit = 50;


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

    public static void ShowAlertMessage(javax.ws.rs.core.Response response) throws HeadlessException {
        Message message = response.readEntity(Message.class);
        JOptionPane.showMessageDialog(null, message.getMessage());
    }

    public static Integer getOffset(Integer offset) {
        if (offset == null) {
            offset = default_offset;
        }
        return offset;

    }

    public static Integer getLimit(Integer limit) {
        if (limit == null) {
            limit = default_offset;
        }
        return limit;

    }

}
