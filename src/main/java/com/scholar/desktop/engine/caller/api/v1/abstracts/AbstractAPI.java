/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.abstracts;

import javax.ws.rs.core.Response;
import main.java.com.scholar.desktop.helper.exceptions.Message;

/**
 *
 * @author mover
 */
public class AbstractAPI {

    public AbstractAPI() {
    }

    public Message getMessage(Response response) {
        //   ShowAlertMessage(response);
        Message message = response.readEntity(Message.class);
        return message;
    }

}
