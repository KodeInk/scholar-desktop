/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui;

import javax.swing.JOptionPane;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.ui.administration.students.admission.ManageAdmissions;
import main.java.com.scholar.desktop.ui.administration.students.registration.ManageRegistration;
import main.java.com.scholar.desktop.ui.departments.ManageDepartments;
import main.java.com.scholar.desktop.ui.setup.exams.ManageExams;
import main.java.com.scholar.desktop.ui.setup.classes.ManageClassesUI;
import main.java.com.scholar.desktop.ui.setup.curriculum.ManageCurriculumUI;
import main.java.com.scholar.desktop.ui.helper.DashboardViews;
import main.java.com.scholar.desktop.ui.library.LibrarySection;
import main.java.com.scholar.desktop.ui.library.LibraryStock;
import main.java.com.scholar.desktop.ui.library.books.ManageBooks;
import main.java.com.scholar.desktop.ui.marksheet.Marksheet;
import main.java.com.scholar.desktop.ui.roles.RolesUI;
import main.java.com.scholar.desktop.ui.setup.classes.ClassesUI;
import main.java.com.scholar.desktop.ui.setup.curriculum.CurriculumUI;
import main.java.com.scholar.desktop.ui.setup.grading.ManageGrading;
import main.java.com.scholar.desktop.ui.setup.subjects.ManageSubjectsUI;
import main.java.com.scholar.desktop.ui.setup.subjects.SubjectsUI;
import main.java.com.scholar.desktop.ui.staff.ManageStaff;
import main.java.com.scholar.desktop.ui.studyyear.ManageStudyYear;
import main.java.com.scholar.desktop.ui.studyyear.terms.ManageTerms;
import main.java.com.scholar.desktop.ui.timetable.students.StudentTimeTable;
import main.java.com.scholar.desktop.ui.users.UsersUI;

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

                // dashboardScreen.getjSplitPane1().setRightComponent(new ManageUsersUI(schoolData));
                dashboardScreen.getjSplitPane1().setRightComponent(new UsersUI(schoolData));
                break;

            case "ROLES":
                dashboardScreen.getjSplitPane1().setRightComponent(new RolesUI(schoolData));
                break;

            case "CLASSES":
                dashboardScreen.getjSplitPane1().setRightComponent(new ClassesUI(schoolData));
                break;

            case "CURRICULUM":
                dashboardScreen.getjSplitPane1().setRightComponent(new CurriculumUI(schoolData));
                break;

            case "SUBJECTS":
                dashboardScreen.getjSplitPane1().setRightComponent(new SubjectsUI(schoolData));
                break;

            case "GRADING":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageGrading(schoolData));
                break;

            case "STUDY_PERIOD":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageStudyYear(schoolData));
                break;

            case "TERMS":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageTerms(schoolData));
                break;
            case "DEPARTMENTS":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageDepartments(schoolData));
                break;
            case "STAFF":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageStaff(schoolData));
                break;
            case "ADMISSION":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageAdmissions());
                break;

            case "REGISTRATION":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageRegistration());
                break;

            case "EXAMS":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageExams());
                break;
            case "STUDENTTIMETABLE":
                dashboardScreen.getjSplitPane1().setRightComponent(new StudentTimeTable());
                break;

            case "MARKSHEET":
                dashboardScreen.getjSplitPane1().setRightComponent(new Marksheet());
                break;

            case "LIBRARYSECTION":
                dashboardScreen.getjSplitPane1().setRightComponent(new LibrarySection());
                break;

            case "BOOKS":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageBooks());
                break;

            case "LIBRARYSTOCK":
                dashboardScreen.getjSplitPane1().setRightComponent(new LibraryStock());
                break;

            default:
                // ManageUsersUI manageUsers = new ManageUsersUI();

                break;
        }

    }

}
