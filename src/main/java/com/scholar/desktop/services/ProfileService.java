/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services;

import java.util.List;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.students.admissions.AdmissionsAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.students.admissions.response.StudentAdmissionResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.response.ProfileResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import main.java.com.scholar.desktop.services.staff.StaffService;
import main.java.com.scholar.desktop.services.students.admissions.AdmissionService;

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

}
