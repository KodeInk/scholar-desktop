/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.helper;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mover
 */
public class Utilities {

    public Utilities() {
    }

    /**
     *
     * @param defaultTableModel
     */
    public static void removeRowsFromDefaultModel(DefaultTableModel defaultTableModel) {
        if (defaultTableModel.getRowCount() > 0) {
            for (int i = defaultTableModel.getRowCount() - 1; i > -1; i--) {
                defaultTableModel.removeRow(i);
            }
        }
    }

}
