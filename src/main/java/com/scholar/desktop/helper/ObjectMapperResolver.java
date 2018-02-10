package main.java.com.scholar.desktop.helper;

import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER;
import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author podolak
 */
@Provider
public class ObjectMapperResolver implements ContextResolver<ObjectMapper> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public ObjectMapperResolver() {
//        String zs = ALLOW_UNQUOTED_CONTROL_CHARS.toString();
//        MAPPER.enable(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID)
//
//        MAPPER.enable(null);
//
//        MAPPER.enable(ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return MAPPER;
    }

}
