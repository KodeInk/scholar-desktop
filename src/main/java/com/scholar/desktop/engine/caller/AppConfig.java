/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller;

import java.io.File;

/**
 *
 * @author mover 2/15/2018
 */
public class AppConfig {

    private File configuration_file;

    private static AppConfig instance;
    public AppConfig() {
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }


    public void readFile(String filePath) {

    }
}
