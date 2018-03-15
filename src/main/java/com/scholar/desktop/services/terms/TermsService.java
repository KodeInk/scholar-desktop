/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.terms;

import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.services.users.UsersService;

/**
 *
 * @author mover 3/15/2018
 */
public class TermsService {

    private static final Logger LOG = Logger.getLogger(TermsService.class.getName());
    private final SchoolData schoolData;
    private static TermsService instance;

    public TermsService(SchoolData schoolData) {
        this.schoolData = schoolData;
    }

}
