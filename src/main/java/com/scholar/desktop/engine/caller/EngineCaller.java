/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller;

import com.fasterxml.jackson.core.format.DataFormatDetector;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.AbstractMultivaluedMap;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import main.java.com.scholar.desktop.engine.caller.entities.SchoolData;
import main.java.com.scholar.desktop.helper.Utilities;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;



/**
 *
 * @author mover
 */
public class EngineCaller {

    private static final Logger LOG = Logger.getLogger(EngineCaller.class.getName());

    private static final String ENGINE_URL = System.getenv("ENGINE_URL");
    private static final String ENGINE_PORT = System.getenv("ENGINE_PORT");
    private static final String PROTOCOL = System.getenv("ENGINE_PROTOCOL");
    private static final String URI = PROTOCOL + "://" + ENGINE_URL + ((ENGINE_PORT != null) ? ":" + ENGINE_PORT : "");

    static final Client HTTPS_CLIENT = ClientBuilder
            .newBuilder()
            .sslContext(getSSLContext())
            .hostnameVerifier(getHostnameVerifier())
            .build()
            .register(JacksonJsonProvider.class);
    //ObjectMapperResolver
    private static Client client = null;
    private static WebTarget target = null;

    public EngineCaller() {
        client = ClientBuilder.newClient();
        target = client.target(URI);
    }

    public String getENGINE_URL() {
        return ENGINE_URL;
    }

    public String getENGINE_PORT() {
        return ENGINE_PORT;
    }

    private static HostnameVerifier getHostnameVerifier() {
        return (String hostname, SSLSession sslSession) -> true;
    }

    private static SSLContext getSSLContext() {
        SSLContext ssl_ctx = null;

        try {
            ssl_ctx = SSLContext.getInstance("TLS");
            TrustManager[] trust_mgr = get_trust_mgr();
            ssl_ctx.init(null, // key manager
                    trust_mgr, // trust manager
                    new SecureRandom()); // random number generator
        } catch (NoSuchAlgorithmException | KeyManagementException ex) {
            // LOG.log(Level.SEVERE, Utilities.getStackTrace(ex));
        }

        return ssl_ctx;
    }

    // <editor-fold defaultstate="collapsed" desc=" helper methods ">
    private static TrustManager[] get_trust_mgr() {
        TrustManager[] certs = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String t) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String t) {
                }
            }
        };
        return certs;
    }


    private static MultivaluedMap getHeaderParameter(SchoolData schoolData) {
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
    public static <T> T get(String path, Map queryParameter, SchoolData schoolData, Class<T> responseType) {

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
    public static <T> T post(String path, Map body, SchoolData schoolData, String logId) {

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
    public static <T> T post(String path, Map body, SchoolData schoolData, Class<T> responseType, String logId) {

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
    public static <T> T put(String path, Map body, SchoolData schoolData, String logId) {

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
    public static <T> T put(String path, Map body, SchoolData schoolData, Class<T> responseType, String logId) {

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
    public static void delete(String path, Map body, SchoolData schoolData, String logId) {

        target.path(path)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(getHeaderParameter(schoolData))
                .delete();
    }





}
