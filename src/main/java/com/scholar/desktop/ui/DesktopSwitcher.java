/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui;

import javax.swing.JOptionPane;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.ui.administration.students.admission.AdmissionsUI;
import main.java.com.scholar.desktop.ui.administration.students.registration.RegistrationUI;
import main.java.com.scholar.desktop.ui.departments.ManageDepartments;
import main.java.com.scholar.desktop.ui.exams.ManageExams;
import main.java.com.scholar.desktop.ui.helper.DashboardViews;
import main.java.com.scholar.desktop.ui.library.LibrarySection;
import main.java.com.scholar.desktop.ui.library.LibraryStock;
import main.java.com.scholar.desktop.ui.library.books.ManageBooks;
import main.java.com.scholar.desktop.ui.marksheet.Marksheet;
import main.java.com.scholar.desktop.ui.roles.RolesUI;
import main.java.com.scholar.desktop.ui.classes.ClassesUI;
import main.java.com.scholar.desktop.ui.curriculum.CurriculumUI;
import main.java.com.scholar.desktop.ui.grading.GradingUI;
import main.java.com.scholar.desktop.ui.subjects.SubjectsUI;
import main.java.com.scholar.desktop.ui.staff.ManageStaff;
import main.java.com.scholar.desktop.ui.studyyear.StudyYearUI;
import main.java.com.scholar.desktop.ui.terms.TermsUI;
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
                dashboardScreen.getjSplitPane1().setRightComponent(ClassesUI.getInstace(schoolData));
                break;

            case "CURRICULUM":
                dashboardScreen.getjSplitPane1().setRightComponent(CurriculumUI.getInstance(schoolData));
                break;

            case "SUBJECTS":
                dashboardScreen.getjSplitPane1().setRightComponent(new SubjectsUI(schoolData));
                break;

            case "GRADING":
                dashboardScreen.getjSplitPane1().setRightComponent(new GradingUI(schoolData));
                break;

            case "STUDY_PERIOD":
                dashboardScreen.getjSplitPane1().setRightComponent(new StudyYearUI(schoolData));
                break;

            case "TERMS":
                dashboardScreen.getjSplitPane1().setRightComponent(new TermsUI(schoolData));
                break;
            case "DEPARTMENTS":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageDepartments(schoolData));
                break;
            case "STAFF":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageStaff(schoolData));
                break;
            case "ADMISSION":
                dashboardScreen.getjSplitPane1().setRightComponent(new AdmissionsUI(schoolData));
                break;

            case "REGISTRATION":
                dashboardScreen.getjSplitPane1().setRightComponent(new RegistrationUI(schoolData));
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
