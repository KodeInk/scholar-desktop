/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.terms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.Terms.TermsAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.Terms.request.Term;
import main.java.com.scholar.desktop.engine.caller.api.v1.Terms.response.TermResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.request.Classes;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.response.ClassResponse;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.limit;
import static main.java.com.scholar.desktop.services.abstracts.Offsets.offset;

/**
 *
 * @author mover 3/15/2018
 */
public class TermsService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(TermsService.class.getName());
    private final SchoolData schoolData;
    private static TermsService instance;
    private List<TermResponse> list = null;
    private TermsAPI termsAPI = null;

    public TermsService(SchoolData schoolData) {
        this.schoolData = schoolData;
        termsAPI = new TermsAPI(schoolData);
    }

    public static TermsService getInstance(SchoolData schoolData) {
        instance = new TermsService(schoolData);
        return instance;
    }

    public List<TermResponse> list(Integer offset, Integer limit) {

        list = new ArrayList<>();

        TermResponse[] responses = termsAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

    public List<TermResponse> list(Integer studyYear) {

        List<TermResponse> list = new ArrayList<>();

        TermResponse[] responses = termsAPI.list(studyYear, offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

    public TermResponse create(Term term, String logId) throws IOException {
        if (term != null) {
            Map classesMap = getTermMap(term);
            return termsAPI.create(classesMap, logId);
        }
        return null;
    }

    public Map getTermMap(Term term) {

        Map termMap = new HashMap<>();
        termMap.put("study_year", term.getStudy_year());
        termMap.put("name", term.getName());
        termMap.put("start_date", term.getStart_date());
        termMap.put("end_date", term.getEnd_date());
        termMap.put("ranking", term.getRanking());

        System.out.println("==================================");
        System.out.println(termMap);
        System.out.println("==================================");

        return termMap;
    }

}
