/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.abstracts;

import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.core.Response;
import main.java.com.scholar.desktop.helper.exceptions.Message;

/**
 *
 * @author mover
 */
public class AbstractAPI {

    public AbstractAPI() {
    }

    protected static String toString(final Response r) {
        try {
            try (final InputStream is = (InputStream) r.getEntity()) {
                final byte[] b = new byte[1024];
                int read = 0;
                final StringBuffer buff = new StringBuffer();
                while ((read = is.read(b)) > 0) {
                    buff.append(new String(b, 0, read));
                }
                return buff.toString();
            }
        } catch (final IOException e) {

        }

        return null;
    }

    public Message getMessage(Response response) {
        //   ShowAlertMessage(response);
        Message message = response.readEntity(Message.class);
        return message;
    }

}
