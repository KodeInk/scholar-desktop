/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.user;

import main.java.com.scholar.desktop.engine.caller.api.v1.abstracts.AbstractAPI;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.ws.rs.core.Response;
import main.java.com.scholar.desktop.engine.caller.EngineCaller;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.request.Login;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.response.AuthenticationResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.response.UserResponse;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import static main.java.com.scholar.desktop.helper.Utilities.ShowAlertMessage;
import static main.java.com.scholar.desktop.helper.Utilities.getLimit;
import static main.java.com.scholar.desktop.helper.Utilities.getOffset;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.helper.exceptions.Message;

/**
 *
 * @author mover 2/14/2018
 */
public class UserAPI extends AbstractAPI {

    private static final Logger LOG = Logger.getLogger(UserAPI.class.getName());
    private final SchoolData schoolData;
    private static UserAPI instance;
    private Message message = null;

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
    public UserResponse[] list(Integer offset, Integer limit) {
        offset = getOffset(offset);
        limit = getLimit(limit);

        Map<String, String> queryParameter = new HashMap<>();
        queryParameter.put("offset", "" + offset);
        queryParameter.put("limit", "" + limit);

        Response response = engineCaller.get("user/v1/", queryParameter);

        switch (response.getStatus()) {
            case 400:
                ShowAlertMessage(response);
                break;
            case 200:
                UserResponse[] userResponse = response.readEntity(UserResponse[].class);
                return userResponse;
            case 401:
                ShowAlertMessage(response);
                break;
            default:
                return null;

        }

        return null;
    }

    /**
     *
     * @param body
     * @param logId
     * @return
     * @throws IOException
     */
    public UserResponse create(Map body, String logId) throws IOException {
        //  return engineCaller.post("body/v1/", (Map) body, UserResponse.class, logId);
        Response response = engineCaller.post("user/v1/", body, logId);
        JOptionPane.showMessageDialog(null, "JOEKEI " + response.getStatus());

        if (response.getStatus() == 500) {
            JOptionPane.showMessageDialog(null, "Milolor zi " + response.getStatus());
        }

        switch (response.getStatus()) {
            case 400:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            case 500:
                message = getMessage(response);
                JOptionPane.showMessageDialog(null, "Milolor zi " + response.getStatus());
                throw new BadRequestException(message.getMessage());


            case 200:
                UserResponse userResponse = response.readEntity(UserResponse.class);
                return userResponse;
            case 401:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            default:
                return null;

        }


    }

    /**
     *
     * @param login
     * @param logId
     * @return
     */
    public AuthenticationResponse login(Login login, String logId) {
        try {
            Map body = getLogin(login);

            Response response = engineCaller.post("user/v1/login", body, logId);

//            JOptionPane.showMessageDialog(null, response.toString());
            switch (response.getStatus()) {
                case 400:
                    ShowAlertMessage(response);
                    break;
                case 200:
                    AuthenticationResponse authenticationResponse = response.readEntity(AuthenticationResponse.class);
//                    JOptionPane.showMessageDialog(null, authenticationResponse.getAuthentication());
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
     * @param login
     * @return
     */
    public Map getLogin(Login login) {
        Map body = new HashMap();
        body.put("username", login.getUsername());
        body.put("password", login.getPassword());
        return body;
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
