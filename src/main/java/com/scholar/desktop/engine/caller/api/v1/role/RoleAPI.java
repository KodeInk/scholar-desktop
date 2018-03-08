/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.role;

import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.EngineCaller;

/**
 *
 * @author mover 3/8/2018
 */
public class RoleAPI {

    private static final Logger LOG = Logger.getLogger(RoleAPI.class.getName());
    private final SchoolData schoolData;
    private static RoleAPI instance;
    private final EngineCaller engineCaller;

    public RoleAPI(SchoolData schoolData) {
        this.schoolData = schoolData;
        engineCaller = new EngineCaller(schoolData);
    }

}
