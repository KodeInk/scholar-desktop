/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.user;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import main.java.com.scholar.desktop.engine.caller.EngineCaller;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.request._User;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.request._login;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.response.AuthenticationResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.response.UserResponse;
import main.java.com.scholar.desktop.config.entities.SchoolData;

/**
 *
 * @author mover 2/14/2018
 */
public class UserAPI {
    private static final Logger LOG = Logger.getLogger(UserAPI.class.getName());
    private SchoolData schoolData;
    private UserAPI instance;

    public UserAPI(SchoolData schoolData) {
        this.schoolData = schoolData;
    }

    private UserAPI getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new UserAPI(schoolData);
        }

        return instance;
    }

    public UserResponse create(_User user, SchoolData schoolData, String logId) throws IOException {
        return EngineCaller.post("user/v1/", (Map) user, schoolData, UserResponse.class, logId);
    }

    public AuthenticationResponse login(_login login, SchoolData schoolData, String logId) {
        return EngineCaller.post("user/v1/login", (Map) login, schoolData, AuthenticationResponse.class, logId);
    }

    public Response deactivateAccount(Integer user_id, SchoolData schoolData, String logId) {
        return EngineCaller.post("user/v1/deactivate/" + user_id, null, schoolData, Response.class, logId);
    }

    public Response activateAccount(Integer user_id, SchoolData schoolData, String logId) {
        return EngineCaller.post("user/v1/activate/" + user_id, null, schoolData, Response.class, logId);
    }


}
