/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.departments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.departments.DepartmentAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.departments.response.DepartmentResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.limit;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.offset;

/**
 *
 * @author mover 3/19/2018
 */
public class DepartmentService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(DepartmentService.class.getName());
    private final SchoolData schoolData;
    private static DepartmentService instance;
    private List<DepartmentResponse> list = null;
    DepartmentAPI deparmentAPI;

    public DepartmentService(SchoolData schoolData) {
        this.schoolData = schoolData;
        deparmentAPI = new DepartmentAPI(schoolData);
    }

    public static DepartmentService getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new DepartmentService(schoolData);
        }
        return instance;
    }

    public List<DepartmentResponse> list() {

        if (list != null) {
            return list;
        }
        list = new ArrayList<>();

        DepartmentResponse[] responses = deparmentAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

}
