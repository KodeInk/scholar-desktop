/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.streams;

import main.java.com.scholar.desktop.services.classes.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.ClassesAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.request.Classes;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.response.ClassResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.streams.StreamsAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.streams.request.Stream;
import main.java.com.scholar.desktop.engine.caller.api.v1.streams.response.StreamResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;

/**
 *
 * @author mover 3/9/2018
 */
public class StreamsService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(StreamsService.class.getName());
    private final SchoolData schoolData;
    private static StreamsService instance;
    private StreamsAPI streamsAPI;

    private List<StreamResponse> list = null;

    /**
     *
     * @param schoolData
     */
    public StreamsService(SchoolData schoolData) {
        this.schoolData = schoolData;
        streamsAPI = new StreamsAPI(schoolData);
    }

    /**
     *
     * @param schoolData
     * @return
     */
    public static StreamsService getInstance(SchoolData schoolData) {
        instance = new StreamsService(schoolData);
        return instance;
    }

    /**
     *
     * @return
     */
    public List<StreamResponse> list() {

        if (list != null) {
            return list;
        }
        list = new ArrayList<>();

        StreamResponse[] responses = streamsAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

    /**
     *
     * @param offset
     * @param limit
     * @return
     */
    public List<StreamResponse> list(Integer offset, Integer limit) {

        list = new ArrayList<>();

        StreamResponse[] responses = streamsAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }

        return list;
    }

    /**
     *
     * @param streams
     * @param logId
     * @return
     * @throws IOException
     */
    public StreamResponse create(Stream streams, String logId) throws IOException {
        if (streams != null) {
            Map classesMap = getStreamMap(streams);
            return streamsAPI.create(classesMap, logId);
        }
        return null;
    }

    public ClassResponse edit(Stream streams, String logId) throws IOException {
        if (streams != null) {
            Map classesMap = getStreamMap(streams);
            return streamsAPI.update(classesMap, logId);
        }
        return null;
    }

    /**
     *
     * @param searchQuery
     * @param offset
     * @param limit
     * @param logId
     * @return
     * @throws IOException
     */
    public List<StreamResponse> search(String searchQuery, Integer offset, Integer limit, String logId) throws IOException {

        List<StreamResponse> streamResponses = new ArrayList<>();
        if (!searchQuery.isEmpty()) {
            StreamResponse[] responses = streamsAPI.list(searchQuery, offset, limit);
            if (responses != null) {
                streamResponses.addAll(Arrays.asList(responses));
            }
        }

        return streamResponses;
    }

    /**
     *
     * @param stream
     * @return
     */
    public Map getStreamMap(Stream stream) {

        Map classesMap = new HashMap<>();
        if (stream.getId() != null) {
            classesMap.put("id", stream.getId());
        }

        classesMap.put("name", stream.getName());
        classesMap.put("code", stream.getCode());

        System.out.println("==================================");
        System.out.println(classesMap);
        System.out.println("==================================");

        return classesMap;
    }

}
