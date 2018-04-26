/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.staff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.staff.StaffAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.staff.response.StaffResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.limit;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.offset;

/**
 *
 * @author mover 3/21/2018
 */
public class StaffService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(StaffService.class.getName());
    private final SchoolData schoolData;
    private static StaffService instance;
    private static StaffAPI staffAPI;
    private List<StaffResponse> list = null;

    public StaffService(SchoolData schoolData) {
        this.schoolData = schoolData;
        staffAPI = new StaffAPI(schoolData);
    }

    public static StaffService getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new StaffService(schoolData);
        }
        return instance;
    }

    public List<StaffResponse> list() {

        if (list != null) {
            return list;
        }
        list = new ArrayList<>();

        StaffResponse[] responses = staffAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

}
