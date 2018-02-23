/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.authentication;

import java.awt.Toolkit;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.request._login;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.UserAPI;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.response.AuthenticationResponse;
import main.java.com.scholar.desktop.ui.DashboardScreen;
import main.java.com.scholar.desktop.ui.DesktopSwitcher;
import main.java.com.scholar.desktop.ui.LoginScreen;
import main.java.com.scholar.desktop.ui.helper.DashboardViews;

/**
 *
 * @author mover 2/15/2018
 */
public class LoginService {

    private static final Logger LOG = Logger.getLogger(LoginService.class.getName());

    private static LoginService instance;

    private final SchoolData schoolData;

    public LoginService(SchoolData schoolData) {
        this.schoolData = schoolData;
    }

    /**
     *
     * @return
     */
    public static LoginService getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new LoginService(schoolData);
        }
        return instance;

    }

    //todo: create login 
    /**
     *
     * @param Username
     * @param password
     * @param loginScreen
     */
    public boolean login(String Username, String password, LoginScreen loginScreen) {
        // todo:  check if not null
        if (password.isEmpty() || Username.isEmpty()) {
            if (password.isEmpty() && Username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "FILL MANDATORIES ");
            } else if (Username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "USERNAME IS MANDATORY  ");
            } else {
                JOptionPane.showMessageDialog(null, "PASSWORD IS MANDATORY  ");
            }

            return false;
        }
        //todo: send to  Fill in the pojo
        _login login = new _login();
        login.setPassword(password);
        login.setUsername(Username);

        UserAPI aPI = new UserAPI(schoolData);
        AuthenticationResponse authenticationResponse = aPI.login(login, "LOG_ID");

        if (authenticationResponse != null) {
            initDashboard(loginScreen);
        }


        return true;

    }

    private void initDashboard(LoginScreen loginScreen) {
        loginScreen.setVisible(false);

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            DashboardScreen dashboardScreen = new DashboardScreen();
            dashboardScreen.setVisible(true);
            dashboardScreen.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/java/com/scholar/desktop/ui/images/logox1.png")));
            dashboardScreen.setExtendedState(JFrame.MAXIMIZED_BOTH);

            DesktopSwitcher.getInstance().showDashboard(dashboardScreen, DashboardViews.OTHERS);
        });
    }

}
