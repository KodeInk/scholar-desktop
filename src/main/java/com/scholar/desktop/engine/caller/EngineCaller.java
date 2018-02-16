/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;



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

    private SchoolData schoolData;

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
     * @param schoolData
     * @return
     */
    public MultivaluedMap getHeaderParameter(SchoolData schoolData) {
        MultivaluedMap httpHeaders = new MultivaluedHashMap<>();
        httpHeaders.put("Authorization", schoolData.getAuthentication());
        httpHeaders.put("X-Mifos-Platform-TenantId", schoolData.getSchoolname());
        httpHeaders.put("Content-Type", "application/json");
        return httpHeaders;
    }

    /**
     *
     * @param <T>
     * @param path
     * @param queryParameter
     * @param schoolData
     * @param responseType
     * @return
     */
    public <T> T get(String path, Map queryParameter, SchoolData schoolData, Class<T> responseType) {

        return target.path(path)
                .request(MediaType.APPLICATION_JSON)
                .headers(getHeaderParameter(schoolData))
                .get(responseType);

    }

    /**
     *
     * @param <T>
     * @param path
     * @param body
     * @param schoolData
     * @param logId
     * @return
     */
    public <T> T post(String path, Map body, SchoolData schoolData, String logId) {

        target.path(path)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(getHeaderParameter(schoolData))
                .post(Entity.entity(body, MediaType.APPLICATION_JSON));

        return null;

    }

    /**
     *
     * @param <T>
     * @param path
     * @param body
     * @param schoolData
     * @param responseType
     * @param logId
     * @return
     */
    public <T> T post(String path, Map body, SchoolData schoolData, Class<T> responseType, String logId) {

        return target.path(path)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(getHeaderParameter(schoolData))
                .post(Entity.entity(body, MediaType.APPLICATION_JSON), responseType);


    }

    /**
     *
     * @param <T>
     * @param path
     * @param body
     * @param schoolData
     * @param logId
     * @return
     */
    public <T> T put(String path, Map body, SchoolData schoolData, String logId) {

        target.path(path)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(getHeaderParameter(schoolData))
                .put(Entity.entity(body, MediaType.APPLICATION_JSON));

        return null;

    }

    /**
     *
     * @param <T>
     * @param path
     * @param body
     * @param schoolData
     * @param responseType
     * @param logId
     * @return
     */
    public <T> T put(String path, Map body, SchoolData schoolData, Class<T> responseType, String logId) {

        return target.path(path)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(getHeaderParameter(schoolData))
                .put(Entity.entity(body, MediaType.APPLICATION_JSON), responseType);

    }

    /**
     *
     * @param path
     * @param body
     * @param schoolData
     * @param logId
     */
    public void delete(String path, Map body, SchoolData schoolData, String logId) {

        target.path(path)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(getHeaderParameter(schoolData))
                .delete();
    }





}
