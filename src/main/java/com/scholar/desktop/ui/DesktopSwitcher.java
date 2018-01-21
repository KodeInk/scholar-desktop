/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui;

import java.awt.Toolkit;
import javax.swing.JFrame;

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

    public void showDashboard(DashboardScreen dashboardScreen) {
        //  dashboardScreen.setLocation(400, 100);
        dashboardScreen.setVisible(true);

        dashboardScreen.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/java/com/scholar/desktop/ui/images/logox1.png")));

        dashboardScreen.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

}
