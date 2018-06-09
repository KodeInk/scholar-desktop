/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.grading;

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
import main.java.com.scholar.desktop.engine.caller.api.v1.grading.response.GradingResponse;
import static main.java.com.scholar.desktop.helper.Utilities.ShowAlertMessage;
import static main.java.com.scholar.desktop.helper.Utilities.getLimit;
import static main.java.com.scholar.desktop.helper.Utilities.getOffset;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.helper.exceptions.Message;

/**
 *
 * @author mover 3/13/2018
 */
public class GradingAPI extends AbstractAPI {

    private static final Logger LOG = Logger.getLogger(GradingAPI.class.getName());
    private final SchoolData schoolData;
    private static GradingAPI instance;
    private final EngineCaller engineCaller;
    private Message message = null;

    public GradingAPI(SchoolData schoolData) {
        this.schoolData = schoolData;
        engineCaller = new EngineCaller(schoolData);
    }

    public GradingResponse[] list(Integer offset, Integer limit) {
        offset = getOffset(offset);
        limit = getLimit(limit);

        Map<String, String> queryParameter = new HashMap<>();
        queryParameter.put("offset", "" + offset);
        queryParameter.put("limit", "" + limit);

        Response response = engineCaller.get("grading/v1/", queryParameter);

        switch (response.getStatus()) {
            case 400:
                ShowAlertMessage(response);
                break;
            case 200:
                GradingResponse[] curriculumResponse = response.readEntity(GradingResponse[].class);
                return curriculumResponse;
            case 401:
                ShowAlertMessage(response);
                break;
            default:
                return null;

        }

        return null;
    }

    public GradingResponse create(Map body, String logId) throws IOException {
        LOG.log(Level.INFO, body.toString());
        Response response = engineCaller.post("grading/v1/", body, logId);

        switch (response.getStatus()) {
            case 400:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            case 500:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            case 200:
                GradingResponse gradingResponse = response.readEntity(GradingResponse.class);
                return gradingResponse;
            case 401:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            default:
                return null;

        }

    }

}
