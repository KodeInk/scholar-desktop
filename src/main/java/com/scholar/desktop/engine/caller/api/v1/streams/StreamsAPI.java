/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.streams;

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
import main.java.com.scholar.desktop.engine.caller.api.v1.streams.response.StreamResponse;
import static main.java.com.scholar.desktop.helper.Utilities.ShowAlertMessage;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.helper.exceptions.Message;

/**
 *
 * @author mover 3/9/2018
 */
public class StreamsAPI extends AbstractAPI {

    private static final Logger LOG = Logger.getLogger(StreamsAPI.class.getName());
    private final SchoolData schoolData;
    private static StreamsAPI instance;
    private final EngineCaller engineCaller;
    private Message message = null;

    public StreamsAPI(SchoolData schoolData) {
        this.schoolData = schoolData;
        engineCaller = new EngineCaller(schoolData);
    }

    public StreamResponse[] list(Integer offset, Integer limit) {
//        offset = getOffset(offset);
//        limit = getLimit(limit);

        Map<String, String> queryParameter = new HashMap<>();
        queryParameter.put("offset", "" + offset);
        queryParameter.put("limit", "" + limit);

             
         
        Response response = engineCaller.get("streams/v1/", queryParameter);

        switch (response.getStatus()) {
            case 400:
                ShowAlertMessage(response);
                break;
            case 200:
                StreamResponse[] streamResponse = response.readEntity(StreamResponse[].class);
                return streamResponse;
            case 401:
                ShowAlertMessage(response);
                break;
            default:
                return null;

        }

        return null;
    }
    
     public StreamResponse[] list(String query,Integer offset, Integer limit) {
//        offset = getOffset(offset);
//        limit = getLimit(limit);

        Map<String, String> queryParameter = new HashMap<>();
        queryParameter.put("offset", "" + offset);
        queryParameter.put("limit", "" + limit);

        Response response = engineCaller.get("streams/v1/search/"+query, queryParameter);

        switch (response.getStatus()) {
            case 400:
                ShowAlertMessage(response);
                break;
            case 200:
                StreamResponse[] streamResponse = response.readEntity(StreamResponse[].class);
                return streamResponse;
            case 401:
                ShowAlertMessage(response);
                break;
            default:
                return null;

        }

        return null;
    }
     
     

    public StreamResponse create(Map body, String logId) throws IOException {
        LOG.log(Level.INFO, body.toString());
        Response response = engineCaller.post("streams/v1/", body, logId);

        switch (response.getStatus()) {
            case 400:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            case 500:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            case 200:
                StreamResponse streamResponse = response.readEntity(StreamResponse.class);
                return streamResponse;
            case 401:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            default:
                return null;

        }

    }
    
      public ClassResponse update(Map body, String logId) throws IOException {
        LOG.log(Level.INFO, body.toString());
        Response response = engineCaller.put("streams/v1/", body, logId);

        switch (response.getStatus()) {
            case 400:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            case 500:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            case 200:
                ClassResponse classResponse = response.readEntity(ClassResponse.class);
                return classResponse;
            case 401:
                message = getMessage(response);
                throw new BadRequestException(message.getMessage());

            default:
                return null;

        }

    }
      
      

}
