/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.roles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.role.RoleAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.role.response.RoleResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.limit;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.offset;
import main.java.com.scholar.desktop.services.users.UsersService;

/**
 *
 * @author mover 3/8/2018
 */
public class RolesService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(UsersService.class.getName());
    private final SchoolData schoolData;
    private static RolesService instance;
    private static RoleAPI roleAPI;

    private List<RoleResponse> list = null;

    /**
     *
     * @param schoolData
     */
    public RolesService(SchoolData schoolData) {
        this.schoolData = schoolData;
        roleAPI = new RoleAPI(schoolData);
    }

    /**
     *
     * @param schoolData
     * @return
     */
    public static RolesService getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new RolesService(schoolData);
        }
        return instance;
    }

    /**
     *
     * @return
     */
    public List<RoleResponse> list() {
        if (list != null) {
            return list;
        }
        list = new ArrayList<>();

        RoleResponse[] responses = roleAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

    public List<RoleResponse> list(Integer offset, Integer limit) {
        list = new ArrayList<>();
        RoleResponse[] responses = roleAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }

        return list;
    }

}
