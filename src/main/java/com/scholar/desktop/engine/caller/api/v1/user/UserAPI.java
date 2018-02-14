/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.user;

import java.io.IOException;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.engine.caller.EngineCaller;
import main.java.com.scholar.desktop.engine.caller.entities.SchoolData;

/**
 *
 * @author mover 2/14/2018
 */
public class UserAPI {
    private static final Logger LOG = Logger.getLogger(UserAPI.class.getName());

    public static GetUserResponse create(_Us, SchoolData schoolData, String logId) throws IOException {
        
        EngineCaller.post("user/v1/", body, schoolData, responseType, logId)
        return EngineCaller.get("users/" + userId, tenantdata, GetUserResponse.class, logId);
    }

}
