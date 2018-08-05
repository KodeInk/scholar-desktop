/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.subjects.papers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.subjects.SubjectPaperAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.subjects.request.SubjectPaper;
import main.java.com.scholar.desktop.engine.caller.api.v1.subjects.response.SubjectPaperResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;

/**
 *
 * @author mover 3/11/2018
 */
public class SubjectPapersService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(SubjectPapersService.class.getName());
    private final SchoolData schoolData;
    private static SubjectPapersService instance;
    private List<SubjectPaperResponse> list = null;
    private SubjectPaperAPI subjectPaperAPI;

    public SubjectPapersService(SchoolData schoolData) {
        this.schoolData = schoolData;
        subjectPaperAPI = new SubjectPaperAPI(schoolData);
    }

    public static SubjectPapersService getInstance(SchoolData schoolData) {
        instance = new SubjectPapersService(schoolData);
        return instance;
    }

    public List<SubjectPaperResponse> list(Integer offset, Integer limit) {

        list = new ArrayList<>();

        SubjectPaperResponse[] responses = subjectPaperAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

    public List<SubjectPaperResponse> search(String searchQuery, Integer offset, Integer limit, String logId) throws IOException {

        List<SubjectPaperResponse> subjectResponse = new ArrayList<>();
        if (!searchQuery.isEmpty()) {
            SubjectPaperResponse[] responses = subjectPaperAPI.list(searchQuery, offset, limit);
            if (responses != null) {
                subjectResponse.addAll(Arrays.asList(responses));
            }
        }

        return subjectResponse;
    }

    public SubjectPaperResponse create(SubjectPaper subjectpaper, String logId) throws IOException {
        if (subjectpaper != null) {
            Map subjectMap = getSubjectMap(subjectpaper);
            return subjectPaperAPI.create(subjectMap, logId);
        }
        return null;
    }

    public SubjectPaperResponse edit(SubjectPaper subjectpaper, String logId) throws IOException {
        if (subjectpaper != null) {
            Map subjectMap = getSubjectMap(subjectpaper);
            return subjectPaperAPI.update(subjectMap, logId);
        }
        return null;
    }

    public Map getSubjectMap(SubjectPaper subjectpaper) {

        Map subjectMap = new HashMap<>();
        if (subjectpaper.getId() != null) {
            subjectMap.put("id", subjectpaper.getId());
        }

        subjectMap.put("name", subjectpaper.getName());
        subjectMap.put("code", subjectpaper.getCode());
        subjectMap.put("subject_id", subjectpaper.getSubject_id().toString());

        System.out.println("==================================");
        System.out.println(subjectMap);
        System.out.println("==================================");

        return subjectMap;
    }

}
