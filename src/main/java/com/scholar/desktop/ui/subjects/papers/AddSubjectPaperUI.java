/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.subjects.papers;

import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.subjects.request.SubjectPaper;
import main.java.com.scholar.desktop.engine.caller.api.v1.subjects.response.SubjectPaperResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.subjects.response.SubjectResponse;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.services.subjects.SubjectsService;
import main.java.com.scholar.desktop.services.subjects.papers.SubjectPapersService;
import main.java.com.scholar.desktop.ui.subjects.AddSubjectUI;

/**
 *
 * @author mover
 */
public class AddSubjectPaperUI extends javax.swing.JPanel {

    /**
     * Creates new form AddSubjectPaperUI
     */
    private Integer offset;
    private Integer limit;

    private static AddSubjectPaperUI instance;
    private SchoolData schoolData;
    private List<SubjectResponse> subjectResponse = null;
    private SubjectPaperResponse subjectpaperresponse = null;

    public AddSubjectPaperUI(SchoolData schoolData) {
        this.schoolData = schoolData;
        initComponents();

    }

    public static AddSubjectPaperUI getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new AddSubjectPaperUI(schoolData);
        }

        return instance;
    }

    public void initData() {
        this.subjectpaperresponse = null;
        offset = 0;
        limit = 10000;
        resetForm();
        fetchSubjects(offset, limit);
    }

    public void fetchSubjects(Integer offset, Integer limIt) {

        resetSubjectCombo();
        subjectField.addItem("Processing ... ");
        jLabel1.setText("Processing ... ");
        if (subjectResponse != null) {
            populateSubjectsCombo();
        }

        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                subjectResponse = SubjectsService.getInstance(schoolData).list(offset, limit);
                jLabel1.setText("Subject Paper  Information");
                populateSubjectsCombo();

                return null;
            }

        };
        swingWorker.execute();
    }

    public void populateSubjectsCombo() {
        resetSubjectCombo();
        if (subjectResponse != null) {
            subjectResponse.forEach((response) -> {
                subjectField.addItem(response.getName());
            });
        }

        if (subjectpaperresponse != null) {
            subjectField.setSelectedItem(subjectpaperresponse.getSubject().getName());
        } else {
            subjectField.setSelectedIndex(-1);
        }
    }

    public void resetSubjectCombo() {
        subjectField.removeAllItems();
    }

    public void edit(SubjectPaperResponse subjectpaperresponse) {
        this.subjectpaperresponse = subjectpaperresponse;
        subjectField.setSelectedItem(subjectpaperresponse.getSubject().getName());
        paperNameField.setText(subjectpaperresponse.getName());
        paperCodeField.setText(subjectpaperresponse.getCode());
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
        paperCodeField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        paperNameField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        subjectField = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Subject Paper  Information");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Name : *");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Code  : *");
        jLabel3.setToolTipText("");

        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("CANCEL");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Subject  : *");
        jLabel4.setToolTipText("");

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(paperNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                            .addComponent(paperCodeField, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(subjectField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(419, Short.MAX_VALUE))
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
                    .addComponent(subjectField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(paperNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(paperCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(236, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        //todo: form validation
        if (paperNameField.getText().isEmpty()) {
            throw new BadRequestException("Subject name is   mandatory");
        }
        if (paperCodeField.getText().isEmpty()) {
            throw new BadRequestException("Subject code is   mandatory");
        }

        if (subjectField.getSelectedIndex() == -1) {
            throw new BadRequestException("Subject category is mandatory");
        }

        SubjectPaper subjectpaper = getSubjectPaper();
        SubmitData(saveButton.getText(), subjectpaper);

    }//GEN-LAST:event_saveButtonActionPerformed

    public void SubmitData(String btnText, SubjectPaper subjectpaper) throws HeadlessException {
        switch (btnText) {
            case "SAVE":
                saveSubjectPaper(subjectpaper);
                break;
            case "EDIT":
                editSubject(subjectpaper);
                break;
            default:
                break;
        }

    }

    private void resetForm() {
        paperNameField.setText("");
        paperCodeField.setText("");
        subjectField.setSelectedIndex(-1);
    }

    private void editSubject(SubjectPaper subjectpaper) throws HeadlessException {
        try {

            if (subjectpaperresponse == null) {
                throw new BadRequestException("Could update record, missing data");
            }

            subjectpaper.setId(subjectpaperresponse.getId());
            SubjectPapersService.getInstance(schoolData).edit(subjectpaper, "LOG ID");
            JOptionPane.showMessageDialog(this, "Record Saved Successfully");
            resetForm();

        } catch (IOException ex) {
            Logger.getLogger(AddSubjectUI.class.getName()).log(Level.SEVERE, null, ex);
            throw new BadRequestException("Could not save the record to the server, something went wrong");
        }

    }

    private void saveSubjectPaper(SubjectPaper subjectpaper) throws HeadlessException {
        try {

            SubjectPaperResponse subjectPaperResponse = SubjectPapersService.getInstance(schoolData).create(subjectpaper, "LOG ID");
            JOptionPane.showMessageDialog(this, "Record Saved Successfully");
            resetForm();

        } catch (HeadlessException | IOException ex) {
            Logger.getLogger(AddSubjectUI.class.getName()).log(Level.SEVERE, null, ex);
            throw new BadRequestException("Could not save the record to the server, something went wrong");
        }

    }

    private SubjectPaper getSubjectPaper() {
        SubjectPaper subjectpaper = new SubjectPaper();
        subjectpaper.setName(paperNameField.getText());
        subjectpaper.setCode(paperCodeField.getText());
        SubjectResponse roleResponse = subjectResponse.get(subjectField.getSelectedIndex());
        subjectpaper.setSubject_id(roleResponse.getId());
        return subjectpaper;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField paperCodeField;
    private javax.swing.JTextField paperNameField;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> subjectField;
    // End of variables declaration//GEN-END:variables
}
