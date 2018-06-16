/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.profile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.profile.request.Profile;
import main.java.com.scholar.desktop.engine.caller.api.v1.profile.response.ProfileResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import main.java.com.scholar.desktop.services.staff.StaffService;

/**
 *
 * @author mover 6/16/2018
 */
public class ProfileService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(StaffService.class.getName());
    private final SchoolData schoolData;
    private static ProfileService instance;

    private List<ProfileResponse> list = null;

    public ProfileService(SchoolData schoolData) {
        this.schoolData = schoolData;

    }

    public static ProfileService getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new ProfileService(schoolData);
        }

        return instance;
    }

    /**
     *
     * @param profile
     * @return
     */
    public Map getProfileMap(Profile profile) {
        Map profileMap = new HashMap<>();
        if (profile != null) {

            profileMap.put("firstName", profile.getFirstName());
            profileMap.put("lastName", profile.getLastName());
            profileMap.put("prefix", profile.getPrefix());
            profileMap.put("dateOfBirth", profile.getDateOfBirth());
        }
        return profileMap;
    }

}
