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
import main.java.com.scholar.desktop.engine.caller.api.v1.students.admissions.request.StudentAdmission;
import main.java.com.scholar.desktop.engine.caller.api.v1.students.admissions.response.StudentAdmissionResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import main.java.com.scholar.desktop.services.profile.ProfileService;
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
        instance = new AdmissionService(schoolData);
        return instance;
    }

    /**
     *
     * @param offset
     * @param limit
     * @return
     */
    public List<StudentAdmissionResponse> list(Integer offset, Integer limit) {

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

    /**
     *
     * @param searchQuery
     * @param offset
     * @param limit
     * @param logId
     * @return
     * @throws IOException
     */
    public List<StudentAdmissionResponse> search(String searchQuery, Integer offset, Integer limit, String logId) throws IOException {

        List<StudentAdmissionResponse> studentAdmissionResponse = new ArrayList<>();
        if (!searchQuery.isEmpty()) {
            StudentAdmissionResponse[] responses = admissionsAPI.list(searchQuery, offset, limit);
            if (responses != null) {
                studentAdmissionResponse.addAll(Arrays.asList(responses));
            }
        }

        return studentAdmissionResponse;
    }

       
       
    /**
     *
     * @param studentAdmission
     * @param logId
     * @return
     * @throws IOException
     */
    public StudentAdmissionResponse create(StudentAdmission studentAdmission, String logId) throws IOException {
        if (studentAdmission != null) {
            Map userMap = getAdmissionMap(studentAdmission);
            return admissionsAPI.create(userMap, logId);
        }
        return null;
    }

    /**
     *
     * @param studentAdmission
     * @return
     */
    public Map getAdmissionMap(StudentAdmission studentAdmission) {
        Map profileMap = ProfileService.getInstance(schoolData).getProfileMap(studentAdmission.getStudent());

        Map studentAdmissionMap = new HashMap<>();
        studentAdmissionMap.put("admission_no", studentAdmission.getAdmission_no());
        studentAdmissionMap.put("date_of_admission", studentAdmission.getDate_of_admission());
        studentAdmissionMap.put("term_id", studentAdmission.getTerm_id());
        studentAdmissionMap.put("stream_id", studentAdmission.getStream_id());
        studentAdmissionMap.put("class_id", studentAdmission.getClass_id());
        studentAdmissionMap.put("student", profileMap);

        System.out.println("==================================");
        System.out.println(studentAdmissionMap);
        System.out.println("==================================");

        return studentAdmissionMap;
    }

}
