/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.ClassesAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.response.ClassResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;

/**
 *
 * @author mover 3/9/2018
 */
public class ClassesService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(ClassesService.class.getName());
    private final SchoolData schoolData;
    private static ClassesService instance;

    ClassesAPI classesAPI;

    private List<ClassResponse> list = null;

    public ClassesService(SchoolData schoolData) {
        this.schoolData = schoolData;
        classesAPI = new ClassesAPI(schoolData);
    }

    public static ClassesService getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new ClassesService(schoolData);
        }
        return instance;
    }

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
}
