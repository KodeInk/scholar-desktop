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

    private static final String ENGINE_URL = System.getenv("ENGINE_URL");
    private static final String ENGINE_PORT = System.getenv("ENGINE_PORT");
    private static final String PROTOCOL = System.getenv("ENGINE_PROTOCOL");
    private static final String URL = PROTOCOL + "://" + ENGINE_URL + ((ENGINE_PORT != null) ? ":" + ENGINE_PORT : "");

    public EngineCaller() {
    }

    public String getENGINE_URL() {
        return ENGINE_URL;
    }

    public String getENGINE_PORT() {
        return ENGINE_PORT;
    }

    private static Map getHeaderParameter(SchoolData schoolData) {
        Map httpHeaders = new HashMap();
        httpHeaders.put("Authorization", schoolData.getAuthentication());
        httpHeaders.put("X-Mifos-Platform-TenantId", schoolData.getSchoolname());
        httpHeaders.put("Content-Type", "application/json");
        return httpHeaders;
    }



}
