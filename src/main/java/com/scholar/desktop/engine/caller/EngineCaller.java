/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.engine.caller.entities.SchoolData;

/**
 *
 * @author mover
 */
public class EngineCaller {

    private static final Logger LOG = Logger.getLogger(EngineCaller.class.getName());

    private final String engine_url = System.getenv("ENGINE_URL");
    private final String engine_port = System.getenv("ENGINE_PORT");

    public EngineCaller() {
    }

    public String getEngine_url() {
        return engine_url;
    }

    public String getEngine_port() {
        return engine_port;
    }

    private static Map getHeaderParameter(SchoolData schoolData) {
        Map httpHeaders = new HashMap();
        httpHeaders.put("Authorization", schoolData.getAuthentication());
        httpHeaders.put("X-Mifos-Platform-TenantId", schoolData.getSchoolname());
        httpHeaders.put("Content-Type", "application/json");
        return httpHeaders;
    }



}
