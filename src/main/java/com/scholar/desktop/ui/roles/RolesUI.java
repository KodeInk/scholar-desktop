/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.roles;

import javax.swing.JOptionPane;
import main.java.com.scholar.desktop.ui.users.*;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import main.java.com.scholar.desktop.config.entities.SchoolData;

/**
 *
 * @author mover
 */
public class RolesUI extends javax.swing.JPanel {

    SchoolData schoolData = null;
    public DefaultTableModel tableModel;

    JTabbedPane jTabbedPane;

    /**
     * Creates new form Users
     * @param schoolData
     */
    public RolesUI(SchoolData schoolData) {
        this.schoolData = schoolData;
        jTabbedPane = new javax.swing.JTabbedPane();
        initComponents();
        jTabbedPane1.addChangeListener(changeListener);
    }

    ChangeListener changeListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
            int index = sourceTabbedPane.getSelectedIndex();
            switch (index) {
                case 0:
                    ManageRolesUI.getInstance(schoolData).fetchData();
                    break;
                case 1:
                   AddRoleUI.getInstance(schoolData);
                    break;
                default:

                    break;
            }

        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        jTabbedPane1.add("Manage Roles",  main.java.com.scholar.desktop.ui.roles.ManageRolesUI.getInstance(schoolData));
        jTabbedPane1.add("Add Role",    main.java.com.scholar.desktop.ui.roles.AddRoleUI.getInstance(schoolData));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
