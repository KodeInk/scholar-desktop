/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.classes;

import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;

/**
 *
 * @author mover 3/9/2018
 */
public class ClassesService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(ClassesService.class.getName());
    private final SchoolData schoolData;
    private static ClassesService instance;


}
