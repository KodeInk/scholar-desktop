/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.students.registration.term;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.EngineCaller;
import main.java.com.scholar.desktop.engine.caller.api.v1.abstracts.AbstractAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.ClassesAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.students.registration.term.response.StudentTermRegistrationResponse;
import static main.java.com.scholar.desktop.helper.Utilities.ShowAlertMessage;
import static main.java.com.scholar.desktop.helper.Utilities.getLimit;
import static main.java.com.scholar.desktop.helper.Utilities.getOffset;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.helper.exceptions.Message;

/**
 *
 * @author mover 6/24/2018
 */
public class RegistrationAPI extends AbstractAPI {

    private static final Logger LOG = Logger.getLogger(RegistrationAPI.class.getName());
    private final SchoolData schoolData;
    private static ClassesAPI instance;
    private final EngineCaller engineCaller;
    private Message message = null;

    public RegistrationAPI(SchoolData schoolData) {
        this.schoolData = schoolData;
        engineCaller = new EngineCaller(schoolData);
    }

    
     public StudentTermRegistrationResponse[] list(Integer offset, Integer limit) {
        offset = getOffset(offset);
        limit = getLimit(limit);

        Map<String, String> queryParameter = new HashMap<>();
        queryParameter.put("offset", "" + offset);
        queryParameter.put("limit", "" + limit);

        Response response = engineCaller.get("registration/term/v1/", queryParameter);

        switch (response.getStatus()) {
            case 400:
                ShowAlertMessage(response);
                break;
            case 200:
                StudentTermRegistrationResponse[] registrationResponse = response.readEntity(StudentTermRegistrationResponse[].class);
                return registrationResponse;
            case 401:
                ShowAlertMessage(response);
                break;
            default:
                return null;

        }

        return null;
    }

    public StudentTermRegistrationResponse create(Map body, String logId) throws IOException {
        LOG.log(Level.INFO, body.toString());
        Response response = engineCaller.post("registration/term/v1/", body, logId);

        switch (response.getStatus()) {
            case 400:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            case 500:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            case 200:
                StudentTermRegistrationResponse registrationResponse = response.readEntity(StudentTermRegistrationResponse.class);
                return registrationResponse;
            case 401:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            default:
                return null;

        }

    }

    
    
}
