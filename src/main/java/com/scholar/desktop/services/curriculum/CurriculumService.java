/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.curriculum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.curriculum.CurriculumAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.curriculum.response.CurriculumResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.limit;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.offset;
import main.java.com.scholar.desktop.services.classes.ClassesService;

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
        if (instance == null) {
            instance = new CurriculumService(schoolData);
        }
        return instance;
    }

    public List<CurriculumResponse> list() {

        if (list != null) {
            return list;
        }
        list = new ArrayList<>();

        CurriculumResponse[] responses = curriculumAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }



}
