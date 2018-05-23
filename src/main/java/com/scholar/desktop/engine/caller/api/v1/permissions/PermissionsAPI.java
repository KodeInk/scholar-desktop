/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.permissions;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.EngineCaller;
import main.java.com.scholar.desktop.engine.caller.api.v1.permissions.response.PermissionsResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.response.RoleResponse;
import static main.java.com.scholar.desktop.helper.Utilities.ShowAlertMessage;
import static main.java.com.scholar.desktop.helper.Utilities.getLimit;
import static main.java.com.scholar.desktop.helper.Utilities.getOffset;

/**
 *
 * @author mover
 */
public class PermissionsAPI {

    private static final Logger LOG = Logger.getLogger(PermissionsAPI.class.getName());
    private final SchoolData schoolData;
    private static PermissionsAPI instance;
    private final EngineCaller engineCaller;

    public PermissionsAPI(SchoolData schoolData) {
        this.schoolData = schoolData;
        engineCaller = new EngineCaller(schoolData);
    }

    
       public PermissionsResponse[] list(Integer offset, Integer limit) {
        offset = getOffset(offset);
        limit = getLimit(limit);

        Map<String, String> queryParameter = new HashMap<>();
        queryParameter.put("offset", offset.toString());
        queryParameter.put("limit", limit.toString());

        Response response = engineCaller.get("permissions/v1/", queryParameter);

        switch (response.getStatus()) {
            case 400:
                ShowAlertMessage(response);
                break;
            case 200:
                PermissionsResponse[] permissionResponse = response.readEntity(PermissionsResponse[].class);
                return permissionResponse;
            case 401:
                ShowAlertMessage(response);
                break;
            default:
                return null;

        }

        return null;
    }

       
}
