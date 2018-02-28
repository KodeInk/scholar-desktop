/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.users;

import java.util.List;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.response.UserResponse;

/**
 *
 * @author mover 2/23/2018
 */
public class UsersService {

    private static final Logger LOG = Logger.getLogger(UsersService.class.getName());
    private final SchoolData schoolData;
    private static UsersService instance;

    /**
     *
     * @param schoolData
     */
    public UsersService(SchoolData schoolData) {
        this.schoolData = schoolData;
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

    public static List<UserResponse> manageUsers() {
//todo: the work is going to be in the view
// here fetch the work respond
        return null;
    }


}
