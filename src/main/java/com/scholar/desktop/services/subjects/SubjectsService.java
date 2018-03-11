/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.subjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.subjects.SubjectAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.subjects.response.SubjectResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.limit;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.offset;

/**
 *
 * @author mover 3/11/2018
 */
public class SubjectsService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(SubjectsService.class.getName());
    private final SchoolData schoolData;
    private static SubjectsService instance;
    private List<SubjectResponse> list = null;
    SubjectAPI subjectAPI;
    public SubjectsService(SchoolData schoolData) {
        this.schoolData = schoolData;
        subjectAPI = new SubjectAPI(schoolData);
    }

    public static SubjectsService getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new SubjectsService(schoolData);
        }
        return instance;
    }

    public List<SubjectResponse> list() {

        if (list != null) {
            return list;
        }
        list = new ArrayList<>();

        SubjectResponse[] responses = subjectAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

}
