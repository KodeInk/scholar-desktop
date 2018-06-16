/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.students.admissions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.students.admissions.AdmissionsAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.students.admissions.request._StudentAdmission;
import main.java.com.scholar.desktop.engine.caller.api.v1.students.admissions.response.StudentAdmissionResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.request.User;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.limit;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.offset;
import main.java.com.scholar.desktop.services.staff.StaffService;

/**
 *
 * @author mover 6/16/2018
 */
public class AdmissionService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(StaffService.class.getName());
    private final SchoolData schoolData;
    private static AdmissionService instance;
    private static AdmissionsAPI admissionsAPI;
    private List<StudentAdmissionResponse> list = null;

    public AdmissionService(SchoolData schoolData) {
        this.schoolData = schoolData;
        admissionsAPI = new AdmissionsAPI(schoolData);
    }

    public static AdmissionService getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new AdmissionService(schoolData);
        }
        return instance;
    }

    public List<StudentAdmissionResponse> list() {

        if (list != null) {
            return list;
        }
        list = new ArrayList<>();

        StudentAdmissionResponse[] responses = admissionsAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

    public StudentAdmissionResponse create(_StudentAdmission studentAdmission, String logId) throws IOException {
        if (studentAdmission != null) {
            Map userMap = getUserMap(studentAdmission);
            return admissionsAPI.create(userMap, logId);
        }
        return null;
    }

    public Map getAdmissionMap(User user) {
        Map profileMap = getProfileMap(user);
        Map staffMap = getStaffMap(user, profileMap);
        Map userMap = new HashMap<>();
        userMap.put("username", user.getUsername());
        userMap.put("password", user.getPassword());
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>(Arrays.asList(user.getRoles()));
        Map<String, ArrayList<String>> m1 = new HashMap<>();
        m1.put("roles", arrayList);
        userMap.put("roles", m1.get("roles"));
        userMap.put("profile", profileMap);
        userMap.put("staff", staffMap);

        System.out.println("==================================");
        System.out.println(userMap);
        System.out.println("==================================");

        return userMap;
    }

}
