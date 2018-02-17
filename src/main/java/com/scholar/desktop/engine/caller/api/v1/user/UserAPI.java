/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.user;

import com.google.common.collect.HashBiMap;
import java.io.IOException;
import java.util.HashMap;
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
    private final SchoolData schoolData;
    private static UserAPI instance;

    private EngineCaller engineCaller;
    public UserAPI(SchoolData schoolData) {
        this.schoolData = schoolData;
        engineCaller = new EngineCaller(schoolData);
    }


    /**
     *
     * @param user
     * @param logId
     * @return
     * @throws IOException
     */
    public UserResponse create(_User user, String logId) throws IOException {
        return engineCaller.post("user/v1/", (Map) user, UserResponse.class, logId);
    }

    /**
     *
     * @param login
     * @param logId
     * @return
     */
    public AuthenticationResponse login(_login login, String logId) {
        Map body = new HashMap();
        body.put("username", login.getUsername());
        body.put("password", login.getPassword());

        return engineCaller.post("user/v1/login", body, AuthenticationResponse.class, logId);
    }

    /**
     *
     * @param user_id
     * @param logId
     * @return
     */
    public Response deactivateAccount(Integer user_id, String logId) {
        return engineCaller.post("user/v1/deactivate/" + user_id, null, Response.class, logId);
    }

    /**
     *
     * @param user_id
     * @param logId
     * @return
     */
    public Response activateAccount(Integer user_id, String logId) {
        return engineCaller.post("user/v1/activate/" + user_id, null, Response.class, logId);
    }


}
