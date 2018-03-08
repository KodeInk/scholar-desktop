/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.roles;

import java.util.logging.Logger;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.services.abstracts.AbstractService;
import main.java.com.scholar.desktop.services.users.UsersService;

/**
 *
 * @author mover 3/8/2018
 */
public class RolesService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(UsersService.class.getName());
    private final SchoolData schoolData;
    private static RolesService instance;

    public RolesService(SchoolData schoolData) {
        this.schoolData = schoolData;
    }

}
