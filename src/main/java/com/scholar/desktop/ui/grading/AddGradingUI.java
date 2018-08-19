/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.grading;

import java.awt.HeadlessException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.grading.request.Grading;
import main.java.com.scholar.desktop.engine.caller.api.v1.grading.response.GradingResponse;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.services.grading.GradingService;

/**
 *
 * @author Manny
 */
public class AddGradingUI extends javax.swing.JPanel {

    /**
     * Creates new form AddGradingUI
     */
    private static AddGradingUI instance;
    private final SchoolData schoolData;
    private GradingResponse gradingResponse;

    public AddGradingUI(SchoolData schoolData) {
        this.schoolData = schoolData;
        initComponents();
    }

    public void initData() {
        resetForm();
        saveButton.setText("SAVE");
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

    /**
     *
     * @param gradingResponse
     */
    public void edit(GradingResponse gradingResponse) {
        this.gradingResponse = gradingResponse;
        //todo: set the form details
        gradingName.setText(gradingResponse.getName());
        gradingCode.setText(gradingResponse.getCode());
        gradingDescription.setText(gradingResponse.getDescription());
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
        gradingName = new javax.swing.JTextField();
        gradingCode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gradingDescription = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

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

        gradingDescription.setColumns(20);
        gradingDescription.setRows(5);
        jScrollPane2.setViewportView(gradingDescription);

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
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(gradingName, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                .addComponent(gradingCode, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                .addComponent(jScrollPane2)))))
                .addContainerGap(150, Short.MAX_VALUE))
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
                    .addComponent(gradingName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gradingCode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(287, Short.MAX_VALUE))
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
        Grading grading = getGrading();

        String btnText = saveButton.getText();

        SubmitData(btnText, grading);
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     *
     * @return
     */
    protected Grading getGrading() {
        //todo: populae the entity
        String gradeName = gradingName.getText();
        String gradeCode = gradingCode.getText();
        String gradeDesc = gradingDescription.getText();
        Grading grading = new Grading();
        grading.setCode(gradeCode);
        grading.setName(gradeName);
        grading.setDescription(gradeDesc);
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
        gradingName.setText("");
        gradingCode.setText("");
        gradingDescription.setText("");
    }

    /**
     *
     * @throws BadRequestException
     */
    protected void validateGrading() throws BadRequestException {
        //todo: validate the UI
        if (gradingName.getText().isEmpty()) {
            throw new BadRequestException("Grading Name Is Mandatory");
        }

        if (gradingCode.getText().isEmpty()) {
            throw new BadRequestException("Grading Code Is Mandatory");
        }

        if (gradingDescription.getText().isEmpty()) {
            throw new BadRequestException("Grading Description Is Mandatory");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField gradingCode;
    private javax.swing.JTextArea gradingDescription;
    private javax.swing.JTextField gradingName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
