package main.java.com.scholar.desktop.helper;

import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER;
import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        MAPPER.enable(ALLOW_UNQUOTED_CONTROL_CHARS);
        MAPPER.enable(ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return MAPPER;
    }

}
