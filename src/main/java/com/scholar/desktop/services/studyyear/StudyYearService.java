/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.studyyear;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.request.Classes;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.response.ClassResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.studyyear.StudyYearAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.studyyear.request.StudyYear;
import main.java.com.scholar.desktop.engine.caller.api.v1.studyyear.response.StudyYearResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.request.User;
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

    /**
     *
     * @param schoolData
     */
    public StudyYearService(SchoolData schoolData) {
        this.schoolData = schoolData;
        studyYearAPI = new StudyYearAPI(schoolData);
    }

    /**
     *
     * @param schoolData
     * @return
     */
    public static StudyYearService getInstance(SchoolData schoolData) {
        instance = new StudyYearService(schoolData);
        return instance;
    }

    /**
     *
     * @return
     */
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

    public List<StudyYearResponse> list(Integer offset, Integer limit) {

        list = new ArrayList<>();

        StudyYearResponse[] responses = studyYearAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

    
      public List<StudyYearResponse> search(String searchQuery, Integer offset, Integer limit, String logId) throws IOException {

        List<StudyYearResponse> classResponses = new ArrayList<>();
        if (!searchQuery.isEmpty()) {
            StudyYearResponse[] responses = studyYearAPI.list(searchQuery, offset, limit);
            if (responses != null) {
                classResponses.addAll(Arrays.asList(responses));
            }
        }

        return classResponses;
    }

      
      
    /**
     *
     * @param studyYear
     * @param logId
     * @return
     * @throws IOException
     */
    public StudyYearResponse create(StudyYear studyYear, String logId) throws IOException {
        if (studyYear != null) {
            Map studyYearMap = getStudyYearMap(studyYear);
            return studyYearAPI.create(studyYearMap, logId);
        }
        return null;
    }

    public StudyYearResponse edit(StudyYear studyYear, String logId) throws IOException {
        if (studyYear != null) {
            Map classesMap = getStudyYearMap(studyYear);
            return studyYearAPI.update(classesMap, logId);
        }
        return null;
    }

    /**
     *
     * @param studyYear
     * @return
     */
    public Map getStudyYearMap(StudyYear studyYear) {

        Map studyYearMap = new HashMap<>();
        if (studyYear.getId() != null) {
            studyYearMap.put("id", studyYear.getId());
        }

        studyYearMap.put("theme", studyYear.getTheme());
        studyYearMap.put("start_date", studyYear.getStart_date());
        studyYearMap.put("end_date", studyYear.getEnd_date());
        studyYearMap.put("curricula", studyYear.getCurricula());

        System.out.println("==================================");
        System.out.println(studyYearMap);
        System.out.println("==================================");

        return studyYearMap;
    }

}
