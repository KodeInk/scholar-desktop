/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import main.java.com.scholar.desktop.config.entities.SchoolData;

/**
 *
 * @author mover
 */
public class EngineCaller {

    private static final Logger LOG = Logger.getLogger(EngineCaller.class.getName());

    private static String ENGINE_URL;
    private static String ENGINE_PORT;
    private static String ENGINE_PROTOCOL;
    private static String URI;

    //ObjectMapperResolver
    private static Client client = null;
    private static WebTarget target = null;

    private static EngineCaller instance;

    private final SchoolData schoolData;

    /**
     *
     * @param schoolData
     */
    public EngineCaller(SchoolData schoolData) {

        ENGINE_URL = schoolData.getEngine().getUrl();
        ENGINE_PORT = schoolData.getEngine().getPort();
        ENGINE_PROTOCOL = schoolData.getEngine().getProtocol();
        URI = ENGINE_PROTOCOL + "://" + ENGINE_URL + ((ENGINE_PORT != null && !ENGINE_PORT.isEmpty()) ? ":" + ENGINE_PORT : "");

        client = ClientBuilder.newClient();
        target = client.target(URI);

        this.schoolData = schoolData;

        System.out.println("URI  ::::::::::::::; " + URI);
    }

    /**
     *
     * @param schoolData
     * @return
     */
    public static EngineCaller getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new EngineCaller(schoolData);
        }
        return instance;

    }

    /**
     *
     * @return
     */
    public String getENGINE_URL() {
        return ENGINE_URL;
    }

    /**
     *
     * @return
     */
    public String getENGINE_PORT() {
        return ENGINE_PORT;
    }

    /**
     *
     * @return
     */
    public MultivaluedMap getHeaderParameter() {

        Map httpHeaders = new HashMap();

        if (schoolData.getAuthentication() != null) {
            System.out.println("AUTHENTICATION " + schoolData.getAuthentication().getAuthentication());
            httpHeaders.put("authentication", schoolData.getAuthentication().getAuthentication());
        }
        httpHeaders.put("schoolname", schoolData.getSchoolname());
        httpHeaders.put("Content-Type", "application/json");

        MultivaluedMap map = new MultivaluedHashMap(httpHeaders);

        return map;
    }

    /**
     *
     * @param queryParameter
     */
    public void getQuerParameters(Map<String, String> queryParameter) {
        if (queryParameter != null) {
            for (String key : queryParameter.keySet()) {
                System.out.println(" VALUE " + queryParameter.get(key));
                target.queryParam(key, queryParameter.get(key));
            }
        }
    }

    private static WebTarget addQueryParamsToTarget(WebTarget target, Map<String, String> queryParams) {
        if (queryParams != null) {
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                target = target.queryParam(entry.getKey(), entry.getValue());
            }
        }
        return target;
    }

    /**
     *
     * @param path
     * @param queryParameter
     * @return
     */
    public Response get(String path, Map<String, String> queryParameter) {

        target = addQueryParamsToTarget(target, queryParameter);

        Response response = target.path(path)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(getHeaderParameter())
                .get(Response.class);

        return response;

    }

    public Response get(String path) {
        return get(path, null);
    }

    /**
     *
     * @param path
     * @param body
     * @param logId
     * @return
     */
    public Response post(String path, Map body, String logId) {

        Response response = target.path(path)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(getHeaderParameter())
                .post(Entity.entity(body, MediaType.APPLICATION_JSON), Response.class);

        return response;

    }

    /**
     *
     * @param path
     * @param body
     * @param logId
     * @return
     */
    public Response put(String path, Map body, String logId) {

        Response response = target.path(path)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(getHeaderParameter())
                .put(Entity.entity(body, MediaType.APPLICATION_JSON), Response.class);

        return response;

    }

    /**
     *
     * @param <T>
     * @param path
     * @param body
     * @param responseType
     * @param logId
     * @return
     */
    public <T> T put(String path, Map body, Class<T> responseType, String logId) {

        return target.path(path)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(getHeaderParameter())
                .put(Entity.entity(body, MediaType.APPLICATION_JSON), responseType);

    }

    /**
     *
     * @param path
     * @param body
     * @param logId
     */
    public void delete(String path, Map body, String logId) {

        target.path(path)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(getHeaderParameter())
                .delete();
    }

}
