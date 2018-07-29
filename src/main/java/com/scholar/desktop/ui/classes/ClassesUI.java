/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.classes;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.response.ClassResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.streams.response.StreamResponse;
import main.java.com.scholar.desktop.ui.streams.AddStreamUI;
import main.java.com.scholar.desktop.ui.streams.ManageStreamsUI;

/**
 *
 * @author mover 5/27/2018
 */
public class ClassesUI extends javax.swing.JPanel {

    private SchoolData schoolData;
    /**
     * Creates new form ClassesUI
     */
    JTabbedPane jTabbedPane;
    private static ClassesUI instance;

    public ClassesUI(SchoolData schoolData) {
        this.schoolData = schoolData;
        jTabbedPane = new javax.swing.JTabbedPane();
        initComponents();
        jTabbedPane1.addChangeListener(changeListener);
    }

    public static ClassesUI getInstace(SchoolData schoolData) {
        if (instance == null) {
            instance = new ClassesUI(schoolData);
        }

        return instance;
    }

    public void editClass(ClassResponse classResponse) {

        jTabbedPane1.setSelectedIndex(1);
        // AddClassUI.getInstance(schoolData).initData();
        AddClassUI.getInstance(schoolData).edit(classResponse);

    }
    
     public void editStream(StreamResponse classResponse) {

        jTabbedPane1.setSelectedIndex(3);
        // AddClassUI.getInstance(schoolData).initData();
        AddStreamUI.getInstance(schoolData).edit(classResponse);

    }
     
     

    ChangeListener changeListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
            int index = sourceTabbedPane.getSelectedIndex();
            switch (index) {
                case 0:
                    ManageClassesUI.getInstance(schoolData).initData();
                    break;
                case 1:
                    AddClassUI.getInstance(schoolData).initData();
                    break;

                case 2:
                    ManageStreamsUI.getInstance(schoolData).initData();
                    break;

                case 3:
                    AddStreamUI.getInstance(schoolData).initData();
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

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.add("Manage Classes",ManageClassesUI.getInstance(schoolData));
        jTabbedPane1.add("Add Class",AddClassUI.getInstance(schoolData));
        jTabbedPane1.add("Manage Streams", ManageStreamsUI.getInstance(schoolData));
        jTabbedPane1.add("Add Stream", AddStreamUI.getInstance(schoolData));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
