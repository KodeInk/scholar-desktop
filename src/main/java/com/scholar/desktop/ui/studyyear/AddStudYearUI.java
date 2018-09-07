/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.studyyear;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.curriculum.response.CurriculumResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.studyyear.request.StudyYear;
import main.java.com.scholar.desktop.engine.caller.api.v1.studyyear.response.StudyYearResponse;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.services.curriculum.CurriculumService;
import main.java.com.scholar.desktop.services.studyyear.StudyYearService;
import main.java.com.scholar.desktop.ui.classes.AddClassUI;

/**
 *
 * @author mover 6/9/2018
 */
public class AddStudYearUI extends javax.swing.JPanel {

    /**
     * Creates new form AddStudYear
     */
    private static AddStudYearUI instance;
    private final SchoolData schoolData;
    private List<Integer> curriculaList = new ArrayList<>();
    private List<JCheckBox> checkBoxs = new ArrayList<>();
    private List<CurriculumResponse> curriculaResponses;
    private StudyYearResponse studyYearResponse;

    public AddStudYearUI(SchoolData schoolData) {
        this.schoolData = schoolData;
        initComponents();
    }

    public static AddStudYearUI getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new AddStudYearUI(schoolData);
        }
        return instance;
    }

    public void initData() {
        studyYearResponse = null;
        resetForm();
        fetchCurricula();
    }

    public void edit(StudyYearResponse studyYearResponse) {
        this.studyYearResponse = studyYearResponse;
        themeField.setText(studyYearResponse.getTheme());
        startDateField.setDate(new Date(studyYearResponse.getStart_date()));
        endDateField.setDate(new Date(studyYearResponse.getEnd_date()));
        saveButton.setText("EDIT");
        fetchCurricula();

    }

    public void fetchCurricula() {
        jLabel1.setText("Processing...");
        if (curriculaResponses != null && curriculaResponses.size() > 0) {
            populateCarricula();
        }

        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                disableMandatories();
                curriculaResponses = CurriculumService.getInstance(schoolData).list(0, 10000);
                populateCarricula();
                jLabel1.setText("Study Period  Information");
                enableMandatories();
                return null;
            }
        };
        swingWorker.execute();

    }

    public void resetJCheckBoxes() {
        checkBoxs.forEach((jcb) -> {
            jcb.setSelected(false);
        });
    }

    public void enableMandatories() {
        saveButton.setEnabled(true);
        themeField.setEnabled(true);
        startDateField.setEnabled(true);
        endDateField.setEnabled(true);
        if (checkBoxs != null) {
            checkBoxs.forEach((jcb) -> {
                jcb.setEnabled(true);
            });
        }
    }

    public void disableMandatories() {
        saveButton.setEnabled(false);
        themeField.setEnabled(false);
        startDateField.setEnabled(false);
        endDateField.setEnabled(false);
        if (checkBoxs != null) {
            checkBoxs.forEach((jcb) -> {
                jcb.setEnabled(false);
            });
        }
    }

    public void populateCarricula() {
        resetJCheckBoxes();
        if (checkBoxs != null && checkBoxs.isEmpty()) {
            JPanel jPanel = null;

            if (curriculaResponses != null) {
                jPanel = getJpanel("CURRICULA", curriculaResponses);
            }
            if (jPanel != null) {
                jScrollPane3.setPreferredSize(new Dimension(450, 300));
                jScrollPane3.setViewportView(jPanel);
                jScrollPane3.repaint();
            }
        }

        if (this.studyYearResponse != null) {
            List<CurriculumResponse> curriculumResponses = studyYearResponse.getCurricula();
            if (checkBoxs != null && checkBoxs.size() > 0) {
                checkBoxs.stream().filter((jcb) -> (curriculumResponses != null)).forEachOrdered((jcb) -> {
                    curriculumResponses.stream().filter((sr) -> (jcb.getActionCommand().equals(sr.getId().toString()))).map((_item) -> {
                        jcb.setSelected(true);
                        return _item;
                    }).forEachOrdered((_item) -> {
                        perfomAction(jcb);
                    });
                });

            }
        }
    }

    public JPanel getJpanel(String grouping, List<CurriculumResponse> list) {

        JPanel container1 = new JPanel();
        container1.setBackground(new java.awt.Color(204, 204, 204));

        container1.setPreferredSize(new Dimension(450, 200));

        JPanel container2 = new JPanel();
        container2.setSize(400, 10);
        container2.setBackground(new java.awt.Color(255, 255, 255));
        JLabel groupLabel = new JLabel();
        groupLabel.setFont(new java.awt.Font("Arial", 0, 12));
        groupLabel.setText(grouping);

        javax.swing.GroupLayout groupLayout1 = new javax.swing.GroupLayout(container2);
        container2.setLayout(groupLayout1);
        groupLayout1.setHorizontalGroup(groupLayout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout1.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(groupLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        groupLayout1.setVerticalGroup(groupLayout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, groupLayout1.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(groupLabel)
                        .addContainerGap())
        );

        JPanel container3 = new JPanel();
        container3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout groupLayout2 = new javax.swing.GroupLayout(container3);
        container3.setLayout(groupLayout2);
        ParallelGroup parallelGroup = groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING);
        SequentialGroup sequentialGroup = groupLayout2.createSequentialGroup();
        sequentialGroup.addContainerGap();

        for (CurriculumResponse pr : list) {

            JCheckBox jCheckBoxx = getCheckBox(pr);

            parallelGroup.addComponent(jCheckBoxx, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE);
            sequentialGroup.addComponent(jCheckBoxx);
            sequentialGroup.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);

        }

        //182 
        sequentialGroup.addContainerGap(154, Short.MAX_VALUE);

        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout2.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(parallelGroup)
                        .addContainerGap())
        );
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sequentialGroup)
        );

        JScrollPane scollPane1 = new JScrollPane();
        scollPane1.setViewportView(container3);
        JPanel jPanel9 = new JPanel();

        javax.swing.GroupLayout groupLayout3 = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(groupLayout3);
        groupLayout3.setHorizontalGroup(groupLayout3.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scollPane1)
        );
        groupLayout3.setVerticalGroup(groupLayout3.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scollPane1)
        );

        javax.swing.GroupLayout groupLayout4 = new javax.swing.GroupLayout(container1);
        container1.setLayout(groupLayout4);
        groupLayout4.setHorizontalGroup(groupLayout4.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout4.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(groupLayout4.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(container2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        groupLayout4.setVerticalGroup(groupLayout4.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout4.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(container2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );

        jPanel3.add(container1);

        return jPanel3;
    }

    private JCheckBox getCheckBox(CurriculumResponse curricula) {
        JCheckBox jCheckBoxx = new JCheckBox();
        jCheckBoxx.setText(curricula.getName());
        jCheckBoxx.setActionCommand(curricula.getId().toString());
        jCheckBoxx.addActionListener((ActionEvent e) -> {
            JCheckBox xx = (JCheckBox) e.getSource();

            perfomAction(xx);

        });

        checkBoxs.add(jCheckBoxx);
        return jCheckBoxx;
    }

    public void perfomAction(JCheckBox xx) throws NumberFormatException {
        /*
        Add curriculum to the curriculum List at selection
         */
        Integer curriculum = Integer.parseInt(xx.getActionCommand());
        if (curriculaList != null) {
            curriculaList.remove(curriculum);
        }

        if (xx.isSelected()) {
            curriculaList.add(curriculum);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        themeField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        startDateField = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        endDateField = new org.jdesktop.swingx.JXDatePicker();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        curriculumJpanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Study Period  Information");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Theme : *");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Start Date : *");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("End  Date : *");
        jLabel4.setToolTipText("");

        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("CANCEL");

        curriculumJpanel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));
        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout curriculumJpanelLayout = new javax.swing.GroupLayout(curriculumJpanel);
        curriculumJpanel.setLayout(curriculumJpanelLayout);
        curriculumJpanelLayout.setHorizontalGroup(
            curriculumJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(curriculumJpanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        curriculumJpanelLayout.setVerticalGroup(
            curriculumJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(curriculumJpanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Curriculum");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(startDateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(themeField, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(curriculumJpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(endDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                                        .addGap(14, 14, 14)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(themeField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(curriculumJpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        validateForm();
        StudyYear studyYear = populateEntity();
        String btnText = saveButton.getText();
        SubmitData(btnText, studyYear);

    }//GEN-LAST:event_saveButtonActionPerformed

    public void SubmitData(String btnText, StudyYear studyYear) throws HeadlessException {
        switch (btnText) {
            case "SAVE":
                saveRecord(studyYear);
                break;
            case "EDIT":
                editRecord(studyYear);
                break;
            default:
                break;
        }
    }

    private void editRecord(StudyYear studyYear) throws HeadlessException {
        try {
            //todo: get the clas_id
            if (studyYearResponse == null) {
                throw new BadRequestException("Could update record, missing data");
            }

            studyYear.setId(studyYearResponse.getId());
            StudyYearService.getInstance(schoolData).edit(studyYear, "LOG_ID");
            JOptionPane.showMessageDialog(null, "Record saved succesfully");

            resetForm();

        } catch (IOException ex) {
            Logger.getLogger(AddClassUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went wrong, could not save class");
        }
    }

    private void saveRecord(StudyYear studyYear) throws HeadlessException {

        try {
            StudyYearResponse studyYearResponse = StudyYearService.getInstance(schoolData).create(studyYear, "log_id");
            JOptionPane.showMessageDialog(this, "Record Saved Succesfully");
            resetForm();
        } catch (IOException ex) {
            Logger.getLogger(AddStudYearUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went wrong, could not save class");
        }

    }

    public void resetForm() {
        themeField.setText("");
        startDateField.setDate(null);
        endDateField.setDate(null);
        curriculaList = new ArrayList<>();
        resetJCheckBoxes();
        saveButton.setText("SAVE");

    }

    /**
     *
     * @return
     */
    public StudyYear populateEntity() {
        //todo:populate template
        StudyYear studyYear = new StudyYear();
        studyYear.setTheme(themeField.getText());
        studyYear.setStart_date(startDateField.getDate().getTime());
        studyYear.setEnd_date(endDateField.getDate().getTime());
        if (curriculaList != null && curriculaList.size() > 0) {
            studyYear.setCurricula(curriculaList);
        }
        return studyYear;
    }

    private void validateForm() throws BadRequestException {
        //todo: validate the form
        if (themeField.getText().isEmpty()) {
            throw new BadRequestException("Theme is mandatory");
        }
        try {
            startDateField.getDate().toString();
        } catch (NullPointerException er) {
            throw new BadRequestException("Start Date  is Madantory");
        }

        try {
            endDateField.getDate().toString();
        } catch (NullPointerException er) {
            throw new BadRequestException("End Date  is Madantory");
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel curriculumJpanel;
    private org.jdesktop.swingx.JXDatePicker endDateField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton saveButton;
    private org.jdesktop.swingx.JXDatePicker startDateField;
    private javax.swing.JTextField themeField;
    // End of variables declaration//GEN-END:variables
}
