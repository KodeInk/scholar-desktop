/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.helper;

/**
 *
 * @author mover
 */
public enum DashboardViews {
    OVERVIEW, USERS, ROLES, CLASSES, CURRICULUM, SUBJECTS, STUDY_PERIOD, GRADING, TERMS, OTHERS;

    public static final DashboardViews fromString(String text) {
        DashboardViews returnValue = OTHERS;

        try {
            if (text != null) {
                returnValue = DashboardViews.valueOf(text.toUpperCase());
            }
        } catch (IllegalArgumentException e) {

            returnValue = OTHERS;
        }

        return returnValue;
    }

    public static final DashboardViews fromObject(Object text) {
        return fromString(text.toString());
    }
}
