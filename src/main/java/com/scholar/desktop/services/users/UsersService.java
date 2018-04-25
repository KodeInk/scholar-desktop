/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.profile.request.Profile;
import main.java.com.scholar.desktop.engine.caller.api.v1.staff.request.Staff;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.UserAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.request.User;
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

    /**
     *
     * @param user
     * @param logId
     * @return
     * @throws IOException
     */
    public UserResponse create(User user, String logId) throws IOException {
        if (user != null) {
            Map userMap = getUserMap(user);
            return userAPI.create(userMap, logId);
        }
        return null;
    }

    /**
     *
     * @return
     */
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

    /**
     *
     * @param user
     * @return
     */
    public Map getUserMap(User user) {
        Map profileMap = getProfileMap(user);
        Map staffMap = getStaffMap(user, profileMap);
        Map userMap = new HashMap<>();
        userMap.put("username", user.getUsername());
        userMap.put("password", user.getPassword());
        //todo: how to convert an array inot a hashmap
        userMap.put("roles", Arrays.asList(user.getRoles()));
        userMap.put("profile", profileMap);
        userMap.put("staff", staffMap);
        return userMap;
    }

    /**
     *
     * @param user
     * @return
     */
    public Map getProfileMap(User user) {
        Map profileMap = new HashMap<>();
        if (user.getProfile() != null) {
            Profile _profile = user.getProfile();
            profileMap.put("firstName", _profile.getFirstName());
            profileMap.put("lastName", _profile.getLastName());
            profileMap.put("prefix", _profile.getPrefix());
        }
        return profileMap;
    }

    /**
     *
     * @param user
     * @param profileMap
     * @return
     */
    public Map getStaffMap(User user, Map profileMap) {
        Map staffMap = new HashMap<>();
        if (user.getStaff() != null) {
            Staff staff = user.getStaff();
            staffMap.put("isTeacher", staff.getIsTeacher());
            staffMap.put("joinDate", staff.getJoinDate());
            if (profileMap != null) {
                staffMap.put("profile", profileMap);
            }
        }
        return staffMap;
    }

}
