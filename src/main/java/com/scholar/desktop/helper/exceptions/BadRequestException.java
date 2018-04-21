package main.java.com.scholar.desktop.helper.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.rmi.CORBA.Util;
import javax.swing.JOptionPane;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import main.java.com.scholar.desktop.helper.Utilities;

/**
 *
 * @author mover
 */
public class BadRequestException extends WebApplicationException {

    private static final Logger LOG = Logger.getLogger(BadRequestException.class.getName());

    public BadRequestException() {
        super(Response.Status.BAD_REQUEST);
    }

    public BadRequestException(String message) {
        this(message, message);
    }

    public BadRequestException(String message, String logMessage) {
        super(
                Response
                        .status(Response.Status.BAD_REQUEST)
                        .entity(new Message(message))
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build()
        );
        Utilities.hideDialog();
        JOptionPane.showMessageDialog(null, message);
        LOG.log(Level.WARNING, logMessage, Response.Status.BAD_REQUEST);
    }

}
