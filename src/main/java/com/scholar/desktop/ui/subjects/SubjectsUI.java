/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.subjects;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.subjects.response.SubjectResponse;
import main.java.com.scholar.desktop.ui.subjects.papers.AddSubjectPaperUI;
import main.java.com.scholar.desktop.ui.subjects.papers.ManageSubjectPaperUI;

/**
 *
 * @author Mover 6/1/2018
 */
public class SubjectsUI extends javax.swing.JPanel {

    /**
     * Creates new form SubjectsUI
     */
    private SchoolData schoolData;
    private static SubjectsUI instance;

    public SubjectsUI(SchoolData schoolData) {
        this.schoolData = schoolData;
        initComponents();
        jTabbedPane1.addChangeListener(changeListener);
    }

    public static SubjectsUI getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new SubjectsUI(schoolData);
        }

        return instance;
    }

    ChangeListener changeListener = new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent changeEvent) {

            JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
            Integer index = sourceTabbedPane.getSelectedIndex();

            switch (index) {
                case 0:
                    ManageSubjectsUI.getInstance(schoolData).initData();
                    break;
                case 1:
                    AddSubjectUI.getInstance(schoolData).initData();
                    break;
                case 2:
                    ManageSubjectPaperUI.getInstance(schoolData).initData();
                    break;
                case 3:
                    AddSubjectPaperUI.getInstance(schoolData).initData();
                    break;

                default:

                    break;
            }

        }
    };

    public void edit(SubjectResponse subjectResponse) {
        jTabbedPane1.setSelectedIndex(1);
        AddSubjectUI.getInstance(schoolData).edit(subjectResponse);

    }

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

        jTabbedPane1.add("Manage Subjects", ManageSubjectsUI.getInstance(schoolData));
        jTabbedPane1.add("Add Subject", AddSubjectUI.getInstance(schoolData));
        jTabbedPane1.add("Manage Subject Papers", ManageSubjectPaperUI.getInstance(schoolData));
        jTabbedPane1.add("Add Subject Paper", AddSubjectPaperUI.getInstance(schoolData));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
