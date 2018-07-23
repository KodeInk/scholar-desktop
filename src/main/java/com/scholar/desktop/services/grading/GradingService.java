/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.grading;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.request.Streams;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.response.ClassResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.grading.GradingAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.grading.request.Grading;
import main.java.com.scholar.desktop.engine.caller.api.v1.grading.response.GradingResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.limit;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.offset;

/**
 *
 * @author mover 3/13/2018
 */
public class GradingService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(GradingService.class.getName());
    private final SchoolData schoolData;
    private static GradingService instance;
    GradingAPI gradingAPI;
    private List<GradingResponse> list = null;

    public GradingService(SchoolData schoolData) {
        this.schoolData = schoolData;
        gradingAPI = new GradingAPI(schoolData);
    }

    public static GradingService getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new GradingService(schoolData);
        }
        return instance;
    }

    public List<GradingResponse> list() {

        if (list != null) {
            return list;
        }
        list = new ArrayList<>();

        GradingResponse[] responses = gradingAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

    
     public GradingResponse create(Grading grading, String logId) throws IOException {
        if (grading != null) {
            Map gradingMap = getGradingMap(grading);
            return gradingAPI.create(gradingMap, logId);
        }
        return null;
    }
     
     
      public Map getGradingMap(Grading grading) {

        Map gradingMap = new HashMap<>();
        gradingMap.put("name", grading.getName());
        gradingMap.put("code", grading.getCode());
        gradingMap.put("description", grading.getDescription());

        System.out.println("==================================");
        System.out.println(gradingMap);
        System.out.println("==================================");

        return gradingMap;
    }
}
