/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.streams;

import main.java.com.scholar.desktop.services.classes.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.ClassesAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.request.SchoolClass;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.response.ClassResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;

/**
 *
 * @author mover 3/9/2018
 */
public class StreamsService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(StreamsService.class.getName());
    private final SchoolData schoolData;
    private static StreamsService instance;

    ClassesAPI classesAPI;

    private List<ClassResponse> list = null;

    /**
     *
     * @param schoolData
     */
    public StreamsService(SchoolData schoolData) {
        this.schoolData = schoolData;
        classesAPI = new ClassesAPI(schoolData);
    }

    /**
     *
     * @param schoolData
     * @return
     */
    public static StreamsService getInstance(SchoolData schoolData) {
        instance = new StreamsService(schoolData);
        return instance;
    }

    /**
     *
     * @return
     */
    public List<ClassResponse> list() {

        if (list != null) {
            return list;
        }
        list = new ArrayList<>();

        ClassResponse[] responses = classesAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

    /**
     *
     * @param offset
     * @param limit
     * @return
     */
    public List<ClassResponse> list(Integer offset, Integer limit) {

//        if (list == null) {
//            list = new ArrayList<>();
//        }
        list = new ArrayList<>();

        ClassResponse[] responses = classesAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
//        IncreaseOffsetLimit();

        return list;
    }

    /**
     *
     * @param classes
     * @param logId
     * @return
     * @throws IOException
     */
    public ClassResponse create(SchoolClass classes, String logId) throws IOException {
        if (classes != null) {
            Map classesMap = getClassMap(classes);
            return classesAPI.create(classesMap, logId);
        }
        return null;
    }

    public ClassResponse edit(SchoolClass classes, String logId) throws IOException {
        if (classes != null) {
            Map classesMap = getClassMap(classes);
            return classesAPI.update(classesMap, logId);
        }
        return null;
    }

    /**
     *
     * @param searchQuery
     * @param offset
     * @param limit
     * @param logId
     * @return
     * @throws IOException
     */
    public List<ClassResponse> search(String searchQuery, Integer offset, Integer limit, String logId) throws IOException {

        List<ClassResponse> classResponses = new ArrayList<>();
        if (!searchQuery.isEmpty()) {
            ClassResponse[] responses = classesAPI.list(searchQuery, offset, limit);
            if (responses != null) {
                classResponses.addAll(Arrays.asList(responses));
            }
        }

        return classResponses;
    }

    /**
     *
     * @param classes
     * @return
     */
    public Map getClassMap(SchoolClass classes) {

        Map classesMap = new HashMap<>();
        if (classes.getId() != null) {
            classesMap.put("id", classes.getId());
        }

        classesMap.put("name", classes.getName());
        classesMap.put("code", classes.getCode());
        classesMap.put("ranking", classes.getRanking());

        System.out.println("==================================");
        System.out.println(classesMap);
        System.out.println("==================================");

        return classesMap;
    }

}
