/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.helper;

import java.awt.BorderLayout;
import static java.awt.Component.CENTER_ALIGNMENT;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mover
 */
public class Utilities {

    private static JDialog dialog;

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

    public static void ShowDialogMessage(String message) {

        if (dialog == null) {
            dialog = new JDialog();
        }
        hideDialog();

        JLabel jl = initDialogJLabel(message);

        dialog.add(BorderLayout.CENTER, jl);

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        dialog.setVisible(true);
    }

    public static JLabel initDialogJLabel(String message) {
        JLabel jl = new JLabel();
        jl.setFont(new java.awt.Font("Arial", 1, 18));
        jl.setText(message);
        jl.setAlignmentX(CENTER_ALIGNMENT);
        return jl;
    }

    public static void hideDialog() {
        if (dialog != null) {
            dialog.setVisible(false);
        }
    }

}
