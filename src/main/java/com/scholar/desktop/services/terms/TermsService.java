/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.terms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.Terms.TermsAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.Terms.response.TermResponse;
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
        if (instance == null) {
            instance = new TermsService(schoolData);
        }
        return instance;
    }

    public List<TermResponse> list() {

        if (list != null) {
            return list;
        }
        list = new ArrayList<>();

        TermResponse[] responses = termsAPI.list(offset, limit);
        if (responses != null) {
            list.addAll(Arrays.asList(responses));
        }
        IncreaseOffsetLimit();
        return list;
    }

}
