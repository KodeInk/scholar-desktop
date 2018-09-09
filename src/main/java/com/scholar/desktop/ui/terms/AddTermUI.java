/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.terms;

import java.awt.HeadlessException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.Terms.request.Term;
import main.java.com.scholar.desktop.engine.caller.api.v1.Terms.response.TermResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.request.Classes;
import main.java.com.scholar.desktop.engine.caller.api.v1.studyyear.response.StudyYearResponse;
import main.java.com.scholar.desktop.helper.Utilities;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.services.classes.ClassesService;
import main.java.com.scholar.desktop.services.studyyear.StudyYearService;
import main.java.com.scholar.desktop.services.terms.TermsService;
import main.java.com.scholar.desktop.ui.classes.AddClassUI;

/**
 *
 * @author mover 6/10/2018
 */
public final class AddTermUI extends javax.swing.JPanel {

    /**
     * Creates new form AddTermUI
     */
    private static AddTermUI instance;
    private final SchoolData schoolData;
    private List<StudyYearResponse> studyYearResponses = null;
    private TermResponse termResponse = null;

    public AddTermUI(SchoolData schoolData) {
        this.schoolData = schoolData;
        initComponents();
        initRankComboBox();
    }

    public static AddTermUI getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new AddTermUI(schoolData);
        }

        return instance;
    }

    public void initData() {
        resetForm();
        initStudyYear();
    }

    public void edit(TermResponse termResponse) {
        this.termResponse = termResponse;
        initRankComboBox();

        termNameField.setText(termResponse.getName());
        startDateField.setDate(new Date(termResponse.getStart_date()));
        endDateField.setDate(new Date(termResponse.getEnd_date()));
//        termRankingField.setSelectedItem(termResponse.getRanking());

    }

    public final void initStudyYear() {

        if (studyYearResponses != null) {
            populateStudyYearComboBox(studyYearResponses);
        }

        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                jLabel1.setText("Processsing...");
                disableMandatories();
                studyYearResponses = StudyYearService.getInstance(schoolData).list(0, 100000);
                populateStudyYearComboBox(studyYearResponses);
                enableMandatories();
                jLabel1.setText("Terms Information");
                return null;
            }
        };
        swingWorker.execute();

    }

    public void enableMandatories() {
        saveButton.setEnabled(true);
        StudyYearComboField.setEnabled(true);
        termNameField.setEnabled(true);
        startDateField.setEnabled(true);
        endDateField.setEnabled(true);
        termRankingField.setEnabled(true);

    }

    public void disableMandatories() {
        saveButton.setEnabled(false);
        StudyYearComboField.setEnabled(false);
        termNameField.setEnabled(false);
        startDateField.setEnabled(false);
        endDateField.setEnabled(false);
        termRankingField.setEnabled(false);
    }

    /**
     *
     * @param studyYearResponses
     */
    public void populateStudyYearComboBox(List<StudyYearResponse> studyYearResponses) {

        StudyYearComboField.removeAllItems();
        studyYearResponses.stream().map((syr) -> {
            Integer start_date = Utilities.getYearString(syr.getStart_date());
            Integer end_string = Utilities.getYearString(syr.getStart_date());
            String themed = (start_date == 0 || end_string == 0) ? start_date + " - " + end_string : syr.getTheme();
            return themed;
        }).forEachOrdered((themed) -> {
            StudyYearComboField.addItem(themed);
        });

        if (this.termResponse != null) {
            StudyYearComboField.setSelectedItem(termResponse.getStudy_year());
        }
    }

    public void initRankComboBox() {
        termRankingField.addItem("Select Option");
        for (int x = 0; x <= 500; x++) {
            termRankingField.addItem("" + x);
        }
        if (this.termResponse != null) {
            termRankingField.setSelectedItem("" + termResponse.getRanking());
        } else {
            termRankingField.setSelectedIndex(1);
        }
    }

    private List<StudyYearResponse> fetchRoles(SchoolData schoolData) {

        if (studyYearResponses != null && studyYearResponses.size() > 0) {
            populate();
        }

        final String message = "     Processsing ...     ";
        Utilities.ShowDialogMessage(message);
        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                studyYearResponses = StudyYearService.getInstance(schoolData).list(-1, -1);
                populate();
                return studyYearResponses;
            }
        };
        swingWorker.execute();
        return null;
    }

    public void populate() {
        //   StudyYearCombo
        StudyYearComboField.removeAllItems();
        if (studyYearResponses.size() > 0) {
            for (StudyYearResponse syr : studyYearResponses) {
                StudyYearComboField.addItem("Testme");
            }
        }

        StudyYearComboField.repaint();
    }

    /**
     *
     * @param schoolData
     * @return
     */
    public static AddTermUI getIntance(SchoolData schoolData) {
        if (instance == null) {
            instance = new AddTermUI(schoolData);
        }
        return instance;
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
        termNameField = new javax.swing.JTextField();
        startDateField = new org.jdesktop.swingx.JXDatePicker();
        StudyYearComboField = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        endDateField = new org.jdesktop.swingx.JXDatePicker();
        termRankingField = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Terms Information");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Study Year : *");
        jLabel2.setToolTipText("");

        startDateField.setDate(Calendar.getInstance().getTime());
        startDateField.setFormats(new SimpleDateFormat( Utilities.getDATE_FORMAT()));

        StudyYearComboField.setAutoscrolls(true);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText(" Name : *");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText(" Start Date : *");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText(" Start Date : *");
        jLabel5.setToolTipText("");

        endDateField.setDate(Calendar.getInstance().getTime());
        endDateField.setFormats(new SimpleDateFormat( Utilities.getDATE_FORMAT()));
        endDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateFieldActionPerformed(evt);
            }
        });

        termRankingField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Ranking : *");
        jLabel6.setToolTipText("");

        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("CANCEL");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(termRankingField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(endDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(10, 10, 10)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(termNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StudyYearComboField, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(StudyYearComboField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(termNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(termRankingField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(159, Short.MAX_VALUE))
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

    private void endDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        validateForm();
        Term term = populateEntity();
        String btnText = saveButton.getText();
        saveRecord(term);


    }//GEN-LAST:event_saveButtonActionPerformed

    public void SubmitData(String btnText, Term term) throws HeadlessException {
        switch (btnText) {
            case "SAVE":
                saveRecord(term);
                break;
            case "EDIT":
                editRecord(term);
                break;
            default:
                break;
        }
    }

    public void saveRecord(Term term) throws HeadlessException, BadRequestException {
        try {
            TermsService.getInstance(schoolData).create(term, "LOG_ID");
            JOptionPane.showMessageDialog(null, "Record saved successfully");
            resetForm();
        } catch (IOException ex) {
            Logger.getLogger(AddTermUI.class.getName()).log(Level.SEVERE, null, ex);
            throw new BadRequestException("Sorry, something went wrong, record could not be saved");
        }
    }

    private void editRecord(Term term) throws HeadlessException {
        try {
            //todo: get the clas_id
            if (this.termResponse == null) {
                throw new BadRequestException("Could update record, missing data");
            }

            term.setId(termResponse.getId());
            ClassesService.getInstance(schoolData).edit(term, "LOG_ID");
            JOptionPane.showMessageDialog(null, "Record saved succesfully");

            resetForm();

        } catch (IOException ex) {
            Logger.getLogger(AddClassUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went wrong, could not save class");
        }
    }

    private void resetForm() {
        termNameField.setText("");
        startDateField.setDate(null);
        endDateField.setDate(null);
        termRankingField.setSelectedIndex(1);
        StudyYearComboField.setSelectedIndex(1);
    }

    public Term populateEntity() {
        //todo: populate Entity
        Term term = new Term();
        StudyYearResponse studyYearResponse = studyYearResponses.get(StudyYearComboField.getSelectedIndex());
        term.setStudy_year(studyYearResponse.getId());
        term.setStart_date(startDateField.getDate().getTime());
        term.setEnd_date(endDateField.getDate().getTime());
        term.setRanking(Integer.parseInt(termRankingField.getSelectedItem().toString()));
        term.setName(termNameField.getText());
        return term;
    }

    public void validateForm() throws BadRequestException {
        //todo: validate form
        if (StudyYearComboField.getSelectedIndex() < 0) {
            throw new BadRequestException("Study Year is mandatory ");
        }

        if (termNameField.getText().isEmpty()) {
            throw new BadRequestException("Term Name is Mandatory");
        }

        try {
            startDateField.getDate().toString();
        } catch (NullPointerException er) {
            throw new BadRequestException("Start date is Madantory");
        }

        try {
            endDateField.getDate().toString();
        } catch (NullPointerException er) {
            throw new BadRequestException("End date is Madantory");
        }

        if (termRankingField.getSelectedIndex() <= 1) {
            throw new BadRequestException("Ranking is Mandatory");
        }

        //todo: populate entity
        //todo: 
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> StudyYearComboField;
    private javax.swing.JButton cancelButton;
    private org.jdesktop.swingx.JXDatePicker endDateField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton saveButton;
    private org.jdesktop.swingx.JXDatePicker startDateField;
    private javax.swing.JTextField termNameField;
    private javax.swing.JComboBox<String> termRankingField;
    // End of variables declaration//GEN-END:variables
}
