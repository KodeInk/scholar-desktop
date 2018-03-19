/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.departments;

import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import main.java.com.scholar.desktop.services.classes.ClassesService;

/**
 *
 * @author mover 3/19/2018
 */
public class DepartmentService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(DepartmentService.class.getName());
    private final SchoolData schoolData;
    private static DepartmentService instance;

    public DepartmentService(SchoolData schoolData) {
        this.schoolData = schoolData;
    }


}
