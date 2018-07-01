/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.students.registration.terms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.students.registration.term.RegistrationAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.students.registration.term.request._StudentTermRegistration;
import main.java.com.scholar.desktop.engine.caller.api.v1.students.registration.term.response.StudentTermRegistrationResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.limit;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.offset;
import main.java.com.scholar.desktop.services.staff.StaffService;

/**
 *
 * @author mover 6.24.2018
 */
public class TermRegistrationService extends AbstractService  {

    private static final Logger LOG = Logger.getLogger(StaffService.class.getName());
    private final SchoolData schoolData;
    private static TermRegistrationService instance;
    private static RegistrationAPI registrationAPI;
    private List<StudentTermRegistrationResponse> list = null;

    public TermRegistrationService(SchoolData schoolData) {
        this.schoolData = schoolData;
        registrationAPI = new RegistrationAPI(schoolData);
    }

    public static TermRegistrationService getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new TermRegistrationService(schoolData);
        }
        return instance;
    }
    
    
     /**
     *
     * @return
     */
    public List<StudentTermRegistrationResponse> list() {

        if (list != null) {
            return list;
        }
        list = new ArrayList<>();

        StudentTermRegistrationResponse[] responses = registrationAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

    /**
     *
     * @param termRegistration
     * @param logId
     * @return
     * @throws IOException
     */
    public StudentTermRegistrationResponse create(_StudentTermRegistration termRegistration, String logId) throws IOException {
        if (termRegistration != null) {
            Map userMap = getAdmissionMap(termRegistration);
            return registrationAPI.create(userMap, logId);
        }
        return null;
    }

    /**
     *
     * @param termRegistration
     * @return
     */
    public Map getAdmissionMap(_StudentTermRegistration termRegistration) {
       
        Map studentAdmissionMap = new HashMap<>();
        studentAdmissionMap.put("admission_number", termRegistration.getAdmission_number());
        studentAdmissionMap.put("term_id", termRegistration.getTerm_id());
        studentAdmissionMap.put("class_id", termRegistration.getClass_id());        
        studentAdmissionMap.put("stream_id", termRegistration.getStream_id());   
         studentAdmissionMap.put("date_registered", termRegistration.getDate_registered());   
        
        System.out.println("==================================");
        System.out.println(studentAdmissionMap);
        System.out.println("==================================");

        return studentAdmissionMap;
    }

}
