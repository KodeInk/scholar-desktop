/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.curriculum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.curriculum.CurriculumAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.curriculum.request.Curriculum;
import main.java.com.scholar.desktop.engine.caller.api.v1.curriculum.response.CurriculumResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;

/**
 *
 * @author mover 3/10/2018
 */
public class CurriculumService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(CurriculumService.class.getName());
    private final SchoolData schoolData;
    private static CurriculumService instance;
    CurriculumAPI curriculumAPI;
    private List<CurriculumResponse> list = null;

    public CurriculumService(SchoolData schoolData) {
        this.schoolData = schoolData;
        curriculumAPI = new CurriculumAPI(schoolData);

    }

    public static CurriculumService getInstance(SchoolData schoolData) {
        instance = new CurriculumService(schoolData);
        return instance;
    }

    public List<CurriculumResponse> list(Integer offset, Integer limit) {

        list = new ArrayList<>();

        CurriculumResponse[] responses = curriculumAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }

        return list;
    }

    public List<CurriculumResponse> search(String searchQuery, Integer offset, Integer limit, String logId) throws IOException {

        List<CurriculumResponse> classResponses = new ArrayList<>();
        if (!searchQuery.isEmpty()) {
            CurriculumResponse[] responses = curriculumAPI.list(searchQuery, offset, limit);
            if (responses != null) {
                classResponses.addAll(Arrays.asList(responses));
            }
        }

        return classResponses;
    }

    public CurriculumResponse create(Curriculum curriculum, String logId) throws IOException {
        if (curriculum != null) {
            Map curriculumMap = getCurriculumMap(curriculum);
            return curriculumAPI.create(curriculumMap, logId);
        }
        return null;
    }

    public CurriculumResponse edit(Curriculum curriculum, String logId) throws IOException {
        if (curriculum != null) {
            Map curriculumMap = getCurriculumMap(curriculum);
            return curriculumAPI.update(curriculumMap, logId);
        }
        return null;
    }

    public Map getCurriculumMap(Curriculum curriculum) {

        Map curriculumMap = new HashMap<>();
        if (curriculum.getId() != null) {
            curriculumMap.put("id", curriculum.getId());
        }
        curriculumMap.put("name", curriculum.getName());
        curriculumMap.put("code", curriculum.getCode());
        curriculumMap.put("description", curriculum.getDescription());

        System.out.println("==================================");
        System.out.println(curriculumMap);
        System.out.println("==================================");

        return curriculumMap;
    }

}
