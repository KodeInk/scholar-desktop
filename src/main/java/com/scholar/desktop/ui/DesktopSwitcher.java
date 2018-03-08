/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui;

import javax.swing.JOptionPane;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.ui.administration.students.admission.ManageAdmissions;
import main.java.com.scholar.desktop.ui.departments.ManageDepartments;
import main.java.com.scholar.desktop.ui.setup.classes.ManageClasses;
import main.java.com.scholar.desktop.ui.setup.curriculum.ManageCurriculum;
import main.java.com.scholar.desktop.ui.helper.DashboardViews;
import main.java.com.scholar.desktop.ui.roles.ManageRoles;
import main.java.com.scholar.desktop.ui.setup.grading.ManageGrading;
import main.java.com.scholar.desktop.ui.setup.subjects.ManageSubjects;
import main.java.com.scholar.desktop.ui.staff.ManageStaff;
import main.java.com.scholar.desktop.ui.study_year.ManageStudyYear;
import main.java.com.scholar.desktop.ui.study_year.terms.ManageTerms;
import main.java.com.scholar.desktop.ui.users.ManageUsers;

/**
 *
 * @author mover
 */
public class DesktopSwitcher {

    private static DesktopSwitcher switcher = null;

    private final SchoolData schoolData;

    public DesktopSwitcher(SchoolData schoolData) {
        this.schoolData = schoolData;
    }

    public static DesktopSwitcher getInstance(SchoolData schoolData) {

        if (switcher == null) {
            switcher = new DesktopSwitcher(schoolData);
        }
        return switcher;
    }

    public void showDashboard(DashboardScreen dashboardScreen, DashboardViews view) {
        //  dashboardScreen.setLocation(400, 100);


        switch (view.toString()) {
            case "OVERVIEW":
                JOptionPane.showMessageDialog(null, schoolData.getSchoolname());
                break;
            case "USERS":

                dashboardScreen.getjSplitPane1().setRightComponent(new ManageUsers(schoolData));
                break;

            case "ROLES":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageRoles(schoolData));
                break;

            case "CLASSES":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageClasses());
                break;

            case "CURRICULUM":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageCurriculum());
                break;

            case "SUBJECTS":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageSubjects());
                break;

            case "GRADING":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageGrading());
                break;

            case "STUDY_PERIOD":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageStudyYear());
                break;

            case "TERMS":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageTerms());
                break;
            case "DEPARTMENTS":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageDepartments());
                break;
            case "STAFF":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageStaff());
                break;
            case "ADMISSION":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageAdmissions());
                break;

//            case "REGISTRATION":
//                dashboardScreen.getjSplitPane1().setRightComponent(new ManageStaff());
//                break;



            default:
                // ManageUsers manageUsers = new ManageUsers();

                break;
        }

    }

}
