/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.studyyear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.studyyear.StudyYearAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.studyyear.response.StudyYearResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.limit;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.offset;

/**
 *
 * @author mover 3/14/2018
 */
public class StudyYearService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(StudyYearService.class.getName());
    private final SchoolData schoolData;
    private static StudyYearService instance;
    private static StudyYearAPI studyYearAPI;

    private List<StudyYearResponse> list = null;

    public StudyYearService(SchoolData schoolData) {
        this.schoolData = schoolData;
        studyYearAPI = new StudyYearAPI(schoolData);
    }

    public static StudyYearService getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new StudyYearService(schoolData);
        }
        return instance;
    }

    public List<StudyYearResponse> list() {

        if (list != null) {
            return list;
        }
        list = new ArrayList<>();

        StudyYearResponse[] responses = studyYearAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

}
