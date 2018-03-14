/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.studyyear;

import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;

/**
 *
 * @author mover 3/14/2018
 */
public class StudyYearService {

    private static final Logger LOG = Logger.getLogger(StudyYearService.class.getName());
    private final SchoolData schoolData;
    private static StudyYearService instance;

    public StudyYearService(SchoolData schoolData) {
        this.schoolData = schoolData;
    }


}
