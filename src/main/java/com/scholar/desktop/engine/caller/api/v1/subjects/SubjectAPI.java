/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.subjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.EngineCaller;
import main.java.com.scholar.desktop.engine.caller.api.v1.abstracts.AbstractAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.response.ClassResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.subjects.response.SubjectResponse;
import static main.java.com.scholar.desktop.helper.Utilities.ShowAlertMessage;
import static main.java.com.scholar.desktop.helper.Utilities.getLimit;
import static main.java.com.scholar.desktop.helper.Utilities.getOffset;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.helper.exceptions.Message;

/**
 *
 * @author mover 3/11/2018
 */
public class SubjectAPI extends AbstractAPI {

    private static final Logger LOG = Logger.getLogger(SubjectAPI.class.getName());
    private final SchoolData schoolData;
    private static SubjectAPI instance;
    private final EngineCaller engineCaller;
    private Message message = null;

    public SubjectAPI(SchoolData schoolData) {
        this.schoolData = schoolData;
        engineCaller = new EngineCaller(schoolData);
    }

    /**
     *
     * @param offset
     * @param limit
     * @return
     */
    public SubjectResponse[] list(Integer offset, Integer limit) {
        
        Map<String, String> queryParameter = new HashMap<>();
        queryParameter.put("offset", "" + offset);
        queryParameter.put("limit", "" + limit);

        Response response = engineCaller.get("subjects/v1/", queryParameter);

        switch (response.getStatus()) {
            case 400:
                ShowAlertMessage(response);
                break;
            case 200:
                SubjectResponse[] subjectResponses = response.readEntity(SubjectResponse[].class);
                return subjectResponses;
            case 401:
                ShowAlertMessage(response);
                break;
            default:
                return null;

        }

        return null;
    }

    public SubjectResponse[] list(String query, Integer offset, Integer limit) {

        Map<String, String> queryParameter = new HashMap<>();
        queryParameter.put("offset", "" + offset);
        queryParameter.put("limit", "" + limit);

        Response response = engineCaller.get("subjects/v1/search/" + query, queryParameter);

        switch (response.getStatus()) {
            case 400:
                ShowAlertMessage(response);
                break;
            case 200:
                SubjectResponse[] subjectResponse = response.readEntity(SubjectResponse[].class);
                return subjectResponse;
            case 401:
                ShowAlertMessage(response);
                break;
            default:
                return null;

        }

        return null;
    }

    public SubjectResponse create(Map body, String logId) throws IOException {
        LOG.log(Level.INFO, body.toString());
        Response response = engineCaller.post("subjects/v1/", body, logId);

        switch (response.getStatus()) {
            case 400:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            case 500:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            case 200:
                SubjectResponse subjectResponse = response.readEntity(SubjectResponse.class);
                return subjectResponse;
            case 401:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            default:
                return null;

        }

    }

    public SubjectResponse update(Map body, String logId) throws IOException {
        LOG.log(Level.INFO, body.toString());
        Response response = engineCaller.put("subjects/v1/", body, logId);

        switch (response.getStatus()) {
            case 400:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            case 500:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            case 200:
                SubjectResponse subjectResponse = response.readEntity(SubjectResponse.class);
                return subjectResponse;
            case 401:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            default:
                return null;

        }

    }

}
