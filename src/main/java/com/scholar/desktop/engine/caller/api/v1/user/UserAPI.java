/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.ws.rs.core.Response;
import main.java.com.scholar.desktop.engine.caller.EngineCaller;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.request._User;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.request._login;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.response.AuthenticationResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.response.UserResponse;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import static main.java.com.scholar.desktop.helper.Utilities.ShowAlertMessage;

/**
 *
 * @author mover 2/14/2018
 */
public class UserAPI {
    private static final Logger LOG = Logger.getLogger(UserAPI.class.getName());
    private final SchoolData schoolData;
    private static UserAPI instance;

    private final EngineCaller engineCaller;
    public UserAPI(SchoolData schoolData) {
        this.schoolData = schoolData;
        engineCaller = new EngineCaller(schoolData);
    }

    /**
     *
     * @param offset
     * @param limit
     * @return
     */
    public List<UserResponse> list(int offset, int limit) {

        return null;
    }



    /**
     *
     * @param user
     * @param logId
     * @return
     * @throws IOException
     */
    public UserResponse create(_User user, String logId) throws IOException {
        //  return engineCaller.post("user/v1/", (Map) user, UserResponse.class, logId);
        return null;

    }

    /**
     *
     * @param login
     * @param logId
     * @return
     */
    public AuthenticationResponse login(_login login, String logId) {
        try {
            Map body = new HashMap();
            body.put("username", login.getUsername());
            body.put("password", login.getPassword());

            Response response = engineCaller.post("user/v1/login", body, logId);


                switch (response.getStatus()) {
                    case 400:
                        ShowAlertMessage(response);
                        break;
                    case 200:
                        AuthenticationResponse authenticationResponse = response.readEntity(AuthenticationResponse.class);
                        return authenticationResponse;
                    case 401:
                        ShowAlertMessage(response);
                        break;
                    default:
                        return null;

                }

            return null;


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Something Went Wrong , Contact System Administrator");
            return null;
        }

    }


    /**
     *
     * @param user_id
     * @param logId
     * @return
     */
    public Response deactivateAccount(Integer user_id, String logId) {
        //  return engineCaller.post("user/v1/deactivate/" + user_id, null, Response.class, logId);
        return null;
    }

    /**
     *
     * @param user_id
     * @param logId
     * @return
     */
    public Response activateAccount(Integer user_id, String logId) {
        //   return engineCaller.post("user/v1/activate/" + user_id, null, Response.class, logId);
        return null;
    }

}
