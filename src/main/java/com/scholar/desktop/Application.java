/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop;

import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import main.java.com.scholar.desktop.config.AppConfig;
import main.java.com.scholar.desktop.engine.caller.EngineCaller;
import main.java.com.scholar.desktop.ui.SplashScreen;
import org.w3c.dom.Document;

/**
 *
 * @author mover
 */
public class Application {
    static SplashScreen screen = null;
    public Application() {
        screen = new SplashScreen();
        screen.setVisible(true);
        screen.setLocation(250, 250);
        screen.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/java/com/scholar/desktop/ui/images/logox1.png")));

        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        screen.InitLoginScreen();

    }

    public static void main(String[] args) {
        //todo: get the path of the configuration file :
        /*
        SUGGESTIONS : U WILL ADD IT AS PART OF THE EMBEDED DB:
        ITS CREATED AT TENANT SETUP ;
         */

        Application application = new Application();
        //todo: start splash screen ::
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                SplashScreen screen = new SplashScreen();
//                screen.setVisible(true);
//
//                screen.setLocation(250, 250);
//
////                try {
////                    Thread.sleep(9000);
////                     System.exit(0);
////                } catch (InterruptedException e) {
////                }
//                for (int i = 0; i < 100; i++) {
//
//                }
//
//                // ImageIcon icon = new ImageIcon(image);
//            }
//        });
    }
}
