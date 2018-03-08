/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.UserAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.response.UserResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;

/**
 *
 * @author mover 2/23/2018
 */
public class UsersService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(UsersService.class.getName());
    private final SchoolData schoolData;
    private static UsersService instance;

    private List<UserResponse> list = null;
    private static UserAPI userAPI;

    /**
     *
     * @param schoolData
     */
    public UsersService(SchoolData schoolData) {
        this.schoolData = schoolData;
        userAPI = new UserAPI(schoolData);
    }

    /**
     *
     * @param schoolData
     * @return
     */
    public static UsersService getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new UsersService(schoolData);
        }
        return instance;
    }

    public List<UserResponse> list() {

        if (list != null) {
            return list;
        }
        list = new ArrayList<>();


        UserResponse[] responses = userAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }



}