/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.permissions;

import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.EngineCaller;

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

}
