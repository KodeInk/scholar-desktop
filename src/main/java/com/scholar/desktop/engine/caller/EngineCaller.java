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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import main.java.com.scholar.desktop.engine.caller.entities.SchoolData;
import main.java.com.scholar.desktop.helper.Utilities;



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
            .build();

    public EngineCaller() {

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

    private static Map getHeaderParameter(SchoolData schoolData) {
        Map httpHeaders = new HashMap();
        httpHeaders.put("Authorization", schoolData.getAuthentication());
        httpHeaders.put("X-Mifos-Platform-TenantId", schoolData.getSchoolname());
        httpHeaders.put("Content-Type", "application/json");
        return httpHeaders;
    }

    private static <T> T get(String path, Map queryParameter, SchoolData schoolData, Class<T> responseType) {
        T returnValue = null;
        return returnValue;
    }

    public static <T> T post(String path, Map body, SchoolData schoolData, String logId) {
        return post(path, null, body, schoolData, null, logId);
    }

    public static <T> T post(String path, Map body, SchoolData schoolData, Class<T> responseType, String logId) {
        return post(path, null, body, schoolData, responseType, logId);
    }

    public static <T> T post(String path, Map queryParameter, Map body, SchoolData schoolData, String logId) {
        return post(path, queryParameter, body, schoolData, null, logId);
    }

    public static <T> T post(String path, Map queryParameter, Map body, SchoolData tenantData, Class<T> responseType, String logId) {
        Map headerParameter = getHeaderParameter(tenantData);
        LOG.log(Level.INFO,
                "{0} :: send request:\n"
                + "\tmethod         : {1}\n"
                + "\tpath           : {2}\n"
                + "\theader         : {3}\n"
                + "\tquery parameter: {4}\n"
                + "\tbody           : {5}\n"
                + "\tresponse type  : {6}",
                new Object[]{logId, "POST", path, Utilities.getParameterForLogging(headerParameter), Utilities.getParameterForLogging(queryParameter), Utilities.getParameterForLogging(body), responseType});

        Invocation.Builder builder = getBuilderWithHeadersAndQueryParams(path, headerParameter, queryParameter, logId);
        Response response;
        try {
            response = builder.accept(MediaType.APPLICATION_JSON).post(Entity.json(body));
        } catch (NotAuthorizedException e) {
            //    throw new UnauthorizedException();
        } catch (Exception e) {
            //  LOG.log(Level.WARNING, "{0} :: cannot get response of POST request\n{1}", new Object[]{logId, Utilities.getStackTrace(e)});
            throw e;
        }

        //   LOG.log(Level.INFO, "{0} :: response: {1}", new Object[]{logId, response});

        T returnValue = null;
        /* switch (response.getStatus()) {
            case 200:
                try {
                    if (responseType != null) {
                        returnValue = response.readEntity(responseType);
                    } else {
                        returnValue = null;
                    }
                } catch (Exception e) {
                    LOG.log(Level.SEVERE, "{0} :: error while converting entity\n{1}", new Object[]{logId, Utilities.getStackTrace(e)});
                    returnValue = null;
                }
                break;
            case 204:
                returnValue = null;
            case 503:
                returnValue = null;
            case 403:
                Utilities.throwAndReturnSanizedErrorMessages(response);
            case 400:
                Utilities.throwAndReturnSanizedErrorMessages(response);

            default:
                String result = response.readEntity(String.class);
                throw new WebApplicationException(result, response.getStatus());
        }
         */

//        if (responseType != null && responseType.isArray()) {
//            LOG.log(Level.INFO, "{0} :: returnValue: {1}", new Object[]{logId, Arrays.toString((Object[]) returnValue)});
//        } else {
//            LOG.log(Level.INFO, "{0} :: returnValue: {1}", new Object[]{logId, returnValue});
//        }

        return returnValue;
    }

    private static Invocation.Builder getBuilderWithQueryParams(String path, Map<String, String> queryParams, String logId) {
        WebTarget target = getTargetWithQueryParams(path, queryParams, logId);
        Invocation.Builder builder = getBuilder(target, logId);
        return builder.accept(MediaType.APPLICATION_JSON_TYPE);
    }

    private static Invocation.Builder getBuilderWithHeadersAndQueryParams(String path, MultivaluedMap<String, Object> headers, Map<String, String> queryParams, String logId) {
        Invocation.Builder builder = getBuilderWithQueryParams(path, queryParams, logId);
        return getBuilderWithHeaders(builder, headers, logId);
    }

    private static Invocation.Builder getBuilderWithHeadersAndQueryParams(String path, Map<String, Object> headerParameter, Map queryParameter, String logId) {
        MultivaluedHashMap<String, Object> multivaluedHeaderParameter = new MultivaluedHashMap<>();

        if (headerParameter != null && !headerParameter.isEmpty()) {
            headerParameter.keySet().stream().forEach((key) -> {
                multivaluedHeaderParameter.add(key, headerParameter.get(key));
            });
        }

        return getBuilderWithHeadersAndQueryParams(path, multivaluedHeaderParameter, queryParameter, logId);
    }

    private static Invocation.Builder getBuilderWithHeaders(Invocation.Builder builder, MultivaluedMap<String, Object> headers, String logId) {
        if (headers == null) {
            headers = new MultivaluedHashMap<>();
        }
        if (!headers.containsKey("Content-Type")) {
            headers.add("Content-Type", "application/json");
        }
        return builder.headers(headers);
    }

    private static WebTarget getTargetWithQueryParams(String path, Map<String, String> queryParams, String logId) {
        // return addQueryParamsToTarget(getTarget(path), queryParams, logId);
        return null;
    }

    private static Invocation.Builder getBuilder(WebTarget target, String logId) {
        LOG.log(Level.INFO, "{0} :: uri: {1}", new Object[]{logId, target.getUri()});
        // return target.request(MediaType.APPLICATION_JSON_TYPE);
        return null;
    }

    private static WebTarget getTarget(String path) {
        return HTTPS_CLIENT.target(UriBuilder.fromUri(URI).build()).path(path);
    }

}
