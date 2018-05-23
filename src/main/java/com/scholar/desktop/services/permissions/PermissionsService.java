/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.permissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.permissions.PermissionsAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.permissions.response.PermissionsResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.limit;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.offset;
import main.java.com.scholar.desktop.services.users.UsersService;

/**
 *
 * @author mover 3/8/2018
 */
public class PermissionsService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(UsersService.class.getName());
    private final SchoolData schoolData;
    private static PermissionsService instance;
    private static PermissionsAPI permissionsAPI;

    private List<PermissionsResponse> list = null;

    /**
     *
     * @param schoolData
     */
    public PermissionsService(SchoolData schoolData) {
        this.schoolData = schoolData;
        permissionsAPI = new PermissionsAPI(schoolData);
    }

    /**
     *
     * @param schoolData
     * @return
     */
    public static PermissionsService getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new PermissionsService(schoolData);
        }
        return instance;
    }

    /**
     *
     * @return
     */
    public List<PermissionsResponse> list() {
        if (list != null) {
            return list;
        }
        list = new ArrayList<>();

        PermissionsResponse[] responses = permissionsAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

    public List<PermissionsResponse> list(Integer offset, Integer limit) {
        list = new ArrayList<>();
        PermissionsResponse[] responses = permissionsAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }

        return list;
    }

}
