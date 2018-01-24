/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.awt.Toolkit;
import javax.swing.JFrame;
import main.java.com.scholar.desktop.ui.helper.DashboardViews;
import main.java.com.scholar.desktop.ui.roles.ManageRoles;
import main.java.com.scholar.desktop.ui.users.ManageUsers;

/**
 *
 * @author mover
 */
public class DesktopSwitcher {

    private static DesktopSwitcher switcher = null;

    public static DesktopSwitcher getInstance() {

        if (switcher == null) {
            switcher = new DesktopSwitcher();
        }
        return switcher;
    }

    public void showDashboard(DashboardScreen dashboardScreen, DashboardViews view) {
        //  dashboardScreen.setLocation(400, 100);

        switch (view.toString()) {
            case "OVERVIEW":
                break;
            case "USERS":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageUsers());
                break;

            case "ROLES":
                dashboardScreen.getjSplitPane1().setRightComponent(new ManageRoles());
                break;

            default:
                // ManageUsers manageUsers = new ManageUsers();

                break;
        }

    }

}
