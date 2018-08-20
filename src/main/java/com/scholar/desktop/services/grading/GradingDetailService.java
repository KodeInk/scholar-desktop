/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.grading;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.grading.GradingDetailAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.grading.request.Grading;
import main.java.com.scholar.desktop.engine.caller.api.v1.grading.request.GradingDetail;
import main.java.com.scholar.desktop.engine.caller.api.v1.grading.response.GradingDetailResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.grading.response.GradingResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.limit;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.offset;

/**
 *
 * @author mover 3/13/2018
 */
public class GradingDetailService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(GradingDetailService.class.getName());
    private final SchoolData schoolData;
    private static GradingDetailService instance;
    GradingDetailAPI gradingAPI;
    private List<GradingDetailResponse> list = null;

    public GradingDetailService(SchoolData schoolData) {
        this.schoolData = schoolData;
        gradingAPI = new GradingDetailAPI(schoolData);
    }

    public static GradingDetailService getInstance(SchoolData schoolData) {
        instance = new GradingDetailService(schoolData);
        return instance;
    }

    /**
     *
     * @return
     */
    public List<GradingDetailResponse> list() {

        list = new ArrayList<>();

        GradingDetailResponse[] responses = gradingAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
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
    public List<GradingDetailResponse> search(String searchQuery, Integer offset, Integer limit, String logId) throws IOException {

        List<GradingDetailResponse> gradingDetailResponses = new ArrayList<>();
        if (!searchQuery.isEmpty()) {
            GradingDetailResponse[] responses = gradingAPI.list(searchQuery, offset, limit);
            if (responses != null) {
                gradingDetailResponses.addAll(Arrays.asList(responses));
            }
        }

        return gradingDetailResponses;
    }

    /**
     *
     * @param offset
     * @param limit
     * @return
     */
    public List<GradingDetailResponse> list(Integer offset, Integer limit) {

        list = new ArrayList<>();

        GradingDetailResponse[] responses = gradingAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

    /**
     *
     * @param gradingDetail
     * @param logId
     * @return
     * @throws IOException
     */
    public GradingResponse create(GradingDetail gradingDetail, String logId) throws IOException {
        if (gradingDetail != null) {
            Map gradingMap = getGradingMap(gradingDetail);
            return gradingAPI.create(gradingMap, logId);
        }
        return null;
    }

    public GradingDetailResponse edit(GradingDetail gradingDetail, String logId) throws IOException {
        if (gradingDetail != null) {
            Map gradingMap = getGradingMap(gradingDetail);
            return gradingAPI.update(gradingMap, logId);
        }
        return null;
    }

    public Map getGradingMap(GradingDetail gradingDetail) {

        Map gradingMap = new HashMap<>();
        if (gradingDetail.getId() != null) {
            gradingMap.put("id", gradingDetail.getId());
        }

        gradingMap.put("grading_scale", gradingDetail.getGrading_scale());
        gradingMap.put("symbol", gradingDetail.getSymbol());
        gradingMap.put("min_grade", gradingDetail.getMin_grade());
        gradingMap.put("max_grade", gradingDetail.getMax_grade());

        System.out.println("==================================");
        System.out.println(gradingMap);
        System.out.println("==================================");

        return gradingMap;
    }
}
