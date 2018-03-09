/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.curriculum;

import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.services.classes.ClassesService;

/**
 *
 * @author mover 3/10/2018
 */
public class CurriculumService {

    private static final Logger LOG = Logger.getLogger(CurriculumService.class.getName());
    private final SchoolData schoolData;
    private static ClassesService instance;

    public CurriculumService(SchoolData schoolData) {
        this.schoolData = schoolData;
    }



}
