/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.departments;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.EngineCaller;
import main.java.com.scholar.desktop.engine.caller.api.v1.departments.response.DepartmentResponse;
import static main.java.com.scholar.desktop.helper.Utilities.ShowAlertMessage;
import static main.java.com.scholar.desktop.helper.Utilities.getLimit;
import static main.java.com.scholar.desktop.helper.Utilities.getOffset;

/**
 *
 * @author mover 3/19/2018
 */
public class DepartmentAPI {

    private static final Logger LOG = Logger.getLogger(DepartmentAPI.class.getName());
    private final SchoolData schoolData;
    private static DepartmentAPI instance;
    private final EngineCaller engineCaller;

    public DepartmentAPI(SchoolData schoolData) {
        this.schoolData = schoolData;
        engineCaller = new EngineCaller(schoolData);

    }

    public DepartmentResponse[] list(Integer offset, Integer limit) {
        offset = getOffset(offset);
        limit = getLimit(limit);

        Map<String, String> queryParameter = new HashMap<>();
        queryParameter.put("offset", "" + offset);
        queryParameter.put("limit", "" + limit);

        Response response = engineCaller.get("departments/v1/", queryParameter);

        switch (response.getStatus()) {
            case 400:
                ShowAlertMessage(response);
                break;
            case 200:
                DepartmentResponse[] curriculumResponse = response.readEntity(DepartmentResponse[].class);
                return curriculumResponse;
            case 401:
                ShowAlertMessage(response);
                break;
            default:
                return null;

        }

        return null;
    }
}
