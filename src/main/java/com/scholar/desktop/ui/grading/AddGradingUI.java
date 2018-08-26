/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.grading;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.grading.request.Grading;
import main.java.com.scholar.desktop.engine.caller.api.v1.grading.response.GradingResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.subjects.response.SubjectResponse;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.services.grading.GradingService;
import main.java.com.scholar.desktop.services.subjects.SubjectsService;

/**
 *
 * @author mover
 */
public class AddGradingUI extends javax.swing.JPanel {

    /**
     * Creates new form AddGradingUI
     */
    private static AddGradingUI instance;
    private final SchoolData schoolData;
    private GradingResponse gradingResponse;

    private List<Integer> subjectsList = new ArrayList<>();
    private List<JCheckBox> checkBoxs = new ArrayList<>();
    private List<SubjectResponse> subjectResponse;

    public AddGradingUI(SchoolData schoolData) {
        this.schoolData = schoolData;
        initComponents();
    }

    public void initData() {
        resetForm();
        saveButton.setText("SAVE");
        fetchCurricula();
    }

    /**
     *
     * @param schoolData
     * @return
     */
    public static AddGradingUI getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new AddGradingUI(schoolData);
        }
        return instance;
    }

    private void fetchCurricula() {
        jLabel1.setText("Processing...");
        if (subjectResponse != null && subjectResponse.size() > 0) {
            populateCarricula();
        }

        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                disableMandatories();
                subjectResponse = SubjectsService.getInstance(schoolData).list(0, 10000);
                populateCarricula();
                jLabel1.setText("Study Period  Information");
                enableMandatories();
                return null;
            }
        };
        swingWorker.execute();

    }

    /**
     *
     * @param gradingResponse
     */
    public void edit(GradingResponse gradingResponse) {
        this.gradingResponse = gradingResponse;
        //todo: set the form details
        gradingNameField.setText(gradingResponse.getName());
        gradingCodeField.setText(gradingResponse.getCode());
        gradingDescriptionField.setText(gradingResponse.getDescription());
        saveButton.setText("EDIT");

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
        jLabel2 = new javax.swing.JLabel();
        gradingNameField = new javax.swing.JTextField();
        gradingCodeField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gradingDescriptionField = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        subjectsPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Grading Information");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Name : *");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Code : *");
        jLabel3.setToolTipText("");

        gradingDescriptionField.setColumns(20);
        gradingDescriptionField.setRows(5);
        jScrollPane2.setViewportView(gradingDescriptionField);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Description : *");
        jLabel4.setToolTipText("");

        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("CANCEL");

        subjectsPanel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));
        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout subjectsPanelLayout = new javax.swing.GroupLayout(subjectsPanel);
        subjectsPanel.setLayout(subjectsPanelLayout);
        subjectsPanelLayout.setHorizontalGroup(
            subjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        subjectsPanelLayout.setVerticalGroup(
            subjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectsPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Subjects ");
        jLabel5.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(gradingNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                .addComponent(gradingCodeField, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                .addComponent(jScrollPane2)
                                .addComponent(subjectsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(25, Short.MAX_VALUE))
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
                    .addComponent(gradingNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gradingCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subjectsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
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
        validateGrading();
        Grading grading = populateEntity();

        String btnText = saveButton.getText();

        SubmitData(btnText, grading);
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     *
     * @return
     */
    protected Grading populateEntity() {
        //todo: populae the entity
        String gradeName = gradingNameField.getText();
        String gradeCode = gradingCodeField.getText();
        String gradeDesc = gradingDescriptionField.getText();
        Grading grading = new Grading();
        grading.setCode(gradeCode);
        grading.setName(gradeName);
        grading.setDescription(gradeDesc);
        if (subjectsList != null && subjectsList.size() > 0) {
            grading.setSubjects(subjectsList);
        }

        return grading;
    }

    /**
     *
     * @param btnText
     * @param grading
     * @throws HeadlessException
     */
    public void SubmitData(String btnText, Grading grading) throws HeadlessException {
        switch (btnText) {
            case "SAVE":
                saveRecord(grading);
                break;
            case "EDIT":
                editRecord(grading);
                break;
            default:
                break;
        }
    }

    /**
     *
     * @param grading
     */
    public void saveRecord(Grading grading) {
        try {
            //todo: submit to the server
            GradingService.getInstance(schoolData).create(grading, "LOG_ID");
            //todo: Success Message
            JOptionPane.showMessageDialog(this, "Record Saved Succesfully");
            resetForm();
        } catch (IOException ex) {
            Logger.getLogger(AddGradingUI.class.getName()).log(Level.SEVERE, null, ex);
            throw new BadRequestException("Sorry,Record was not saved succesfuly, something went wrong");
        }
    }

    /**
     *
     * @param grading
     */
    public void editRecord(Grading grading) {
        try {
            //todo: get the clas_id
            if (gradingResponse == null) {
                throw new BadRequestException("Could update record, missing data");
            }

            grading.setId(gradingResponse.getId());

            //todo: submit to the server
            GradingService.getInstance(schoolData).edit(grading, "LOG_ID");
            //todo: Success Message
            JOptionPane.showMessageDialog(this, "Record Saved Succesfully");
            resetForm();
        } catch (IOException ex) {
            Logger.getLogger(AddGradingUI.class.getName()).log(Level.SEVERE, null, ex);
            throw new BadRequestException("Sorry,Record was not saved succesfuly, something went wrong");
        }
    }

    /**
     *
     */
    public void resetForm() {
        //todo: reset and fnish
        gradingNameField.setText("");
        gradingCodeField.setText("");
        gradingDescriptionField.setText("");
        subjectsList = new ArrayList<>();
        resetJCheckBoxes();
        saveButton.setText("SAVE");
    }

    /**
     *
     * @throws BadRequestException
     */
    protected void validateGrading() throws BadRequestException {
        //todo: validate the UI
        if (gradingNameField.getText().isEmpty()) {
            throw new BadRequestException("Grading Name Is Mandatory");
        }

        if (gradingCodeField.getText().isEmpty()) {
            throw new BadRequestException("Grading Code Is Mandatory");
        }

        if (gradingDescriptionField.getText().isEmpty()) {
            throw new BadRequestException("Grading Description Is Mandatory");
        }
    }

    public JPanel getJpanel(String grouping, List<SubjectResponse> list) {

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
        GroupLayout.ParallelGroup parallelGroup = groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.SequentialGroup sequentialGroup = groupLayout2.createSequentialGroup();
        sequentialGroup.addContainerGap();

        for (SubjectResponse pr : list) {

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

    private JCheckBox getCheckBox(SubjectResponse curricula) {
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
        if (subjectsList != null) {
            subjectsList.remove(curriculum);
        }

        if (xx.isSelected()) {
            subjectsList.add(curriculum);
        }
    }

    public void enableMandatories() {
        saveButton.setEnabled(true);
        gradingNameField.setEnabled(true);
        gradingCodeField.setEnabled(true);
        gradingDescriptionField.setEnabled(true);
        if (checkBoxs != null) {
            checkBoxs.forEach((jcb) -> {
                jcb.setEnabled(true);
            });
        }
    }

    public void disableMandatories() {
        saveButton.setEnabled(false);
        gradingNameField.setEnabled(false);
        gradingCodeField.setEnabled(false);
        gradingDescriptionField.setEnabled(false);
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

            if (subjectResponse != null) {
                jPanel = getJpanel("SUBJECTS", subjectResponse);
            }
            if (jPanel != null) {
                jScrollPane3.setPreferredSize(new Dimension(450, 300));
                jScrollPane3.setViewportView(jPanel);
                jScrollPane3.repaint();
            }
        }

        if (this.gradingResponse != null) {
            List<SubjectResponse> subjectResponses = gradingResponse.getSubjectResponses();
            if (checkBoxs != null && checkBoxs.size() > 0) {
                checkBoxs.stream().filter((jcb) -> (subjectResponses != null)).forEachOrdered((jcb) -> {
                    subjectResponses.stream().filter((sr) -> (jcb.getActionCommand().equals(sr.getId().toString()))).map((_item) -> {
                        jcb.setSelected(true);
                        return _item;
                    }).forEachOrdered((_item) -> {
                        perfomAction(jcb);
                    });
                });

            }
        }
    }

    public void resetJCheckBoxes() {
        checkBoxs.forEach((jcb) -> {
            jcb.setSelected(false);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField gradingCodeField;
    private javax.swing.JTextArea gradingDescriptionField;
    private javax.swing.JTextField gradingNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel subjectsPanel;
    // End of variables declaration//GEN-END:variables
}
