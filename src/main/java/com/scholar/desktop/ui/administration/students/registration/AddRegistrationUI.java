/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.administration.students.registration;

import com.codemovers.scholar.engine.helper.enums.StatusEnum;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.Terms.response.TermResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.response.ClassResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.students.admissions.request._StudentAdmission;
import main.java.com.scholar.desktop.engine.caller.api.v1.students.registration.term.request._StudentTermRegistration;
import main.java.com.scholar.desktop.engine.caller.api.v1.studyyear.response.StudyYearResponse;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.services.classes.ClassesService;
import main.java.com.scholar.desktop.services.students.admissions.AdmissionService;
import main.java.com.scholar.desktop.services.students.registration.terms.TermRegistrationService;
import main.java.com.scholar.desktop.services.studyyear.StudyYearService;
import main.java.com.scholar.desktop.services.terms.TermsService;

/**
 *
 * @author mover 6.24.2018
 *
 */
public class AddRegistrationUI extends javax.swing.JPanel {

    /**
     * Creates new form AddRegistrationUI
     */
    private final SchoolData schoolData;
    private static AddRegistrationUI instance;
    private List<StudyYearResponse> studyYearResponses = null;
    private List<ClassResponse> classResponses = null;

    /**
     *
     * @param schoolData
     */
    public AddRegistrationUI(SchoolData schoolData) {
        this.schoolData = schoolData;
        initComponents();

    }

    /**
     * Init Data :: Call Fetch Study Year, Fetch Classes
     */
    public void initData() {
        fetchStudyYear();
        //todo: get classes
        fetchClasses();
    }

    /**
     *
     * @param schoolData
     * @return
     */
    public static AddRegistrationUI getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new AddRegistrationUI(schoolData);
        }

        return instance;
    }

    /**
     * Fetch Classes
     */
    public void fetchClasses() {
        if (classResponses != null) {
            populateClassesCombo(classResponses);
        } else {
            registeredClass.removeAll();
            registeredClass.addItem("Processing ...");
            SwingWorker swingWorker = new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    classResponses = ClassesService.getInstance(schoolData).list(-1, -1);
                    populateClassesCombo(classResponses);
                    return null;
                }
            };
            swingWorker.execute();
        }
    }

    /**
     *
     */
    public void fetchStudyYear() {
        if (studyYearResponses != null) {
            populateStudyYearComboBox(studyYearResponses);
        } else {
            admissionYear.removeAll();
            admissionYear.addItem("Processing ...");
            SwingWorker swingWorker = new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    studyYearResponses = StudyYearService.getInstance(schoolData).list(-1, -1);
                    admissionYear.removeAll();
                    populateStudyYearComboBox(studyYearResponses);

                    return null;
                }
            };
            swingWorker.execute();
        }
    }

    /**
     *
     * @param studyYearResponses
     */
    public void populateStudyYearComboBox(List<StudyYearResponse> studyYearResponses) {
        //StudyYearCombo
        admissionYear.removeAllItems();
        admissionYear.addItem("Select Option");
        studyYearResponses.forEach((StudyYearResponse syr) -> {
            try {
                admissionYear.addItem(syr.getTheme().concat(" [ ").concat(new Date(syr.getStart_date()).toString()).concat(" - ").concat(new Date(syr.getEnd_date()).toString()));
            } catch (Exception er) {
            }
        });

        admissionYear.addActionListener((ActionEvent e) -> {
            getSelectedYear();
        });

    }

    /**
     *
     * @param ClassResponse
     */
    public void populateClassesCombo(List<ClassResponse> ClassResponse) {
        //StudyYearCombo
        registeredClass.removeAllItems();
        registeredClass.addItem("Select Option");
        ClassResponse.forEach(aClass -> {
            try {
                registeredClass.addItem(aClass.getName());
                registeredClass.setActionCommand(aClass.getId().toString());

            } catch (Exception er) {

            }
        });

    }

    /**
     *
     */
    public void getSelectedYear() {
        registeredTerm.removeAllItems();

        if (admissionYear.getSelectedIndex() > 0) {
            StudyYearResponse syr = studyYearResponses.get(admissionYear.getSelectedIndex() - 1);
            fetchTerms(syr.getId());
        }

    }
    List<TermResponse> termResponses = null;

    /**
     *
     * @param studyYear
     */
    public void fetchTerms(Integer studyYear) {

        registeredTerm.removeAllItems();
        registeredTerm.addItem("Processing ...");

        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                termResponses = TermsService.getInstance(schoolData).list(studyYear);
                registeredTerm.removeAllItems();
                registeredTerm.addItem("Select Option");
                termResponses.forEach((tr) -> {
                    registeredTerm.addItem(tr.getName());
                });
                return null;
            }
        };
        swingWorker.execute();
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
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        admissionYear = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dateOfAdmission = new org.jdesktop.swingx.JXDatePicker();
        jLabel14 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        registeredClass = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        registeredTerm = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        admissionNumber = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Admission Information");

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));

        jButton2.setText("SAVE");
        jButton2.setActionCommand("save_user");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("CANCEL");

        admissionYear.setSelectedItem(null);
        admissionYear.setActionCommand("");
        admissionYear.setName("prefix"); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Academic Year");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Admission Number");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Registration Date");

        jSeparator3.setBackground(new java.awt.Color(153, 153, 153));

        registeredClass.setSelectedItem(null);
        registeredClass.setName("prefix"); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Class");

        registeredTerm.setSelectedItem(null);
        registeredTerm.setName("prefix"); // NOI18N

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Term");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Registration Information");

        admissionNumber.setName("admission_no"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registeredClass, 0, 533, Short.MAX_VALUE)
                            .addComponent(registeredTerm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(admissionYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateOfAdmission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(769, 769, 769))
            .addComponent(jSeparator3)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admissionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(admissionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(admissionYear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateOfAdmission, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registeredClass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registeredTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        validateForm();
        submit();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Validate the form :: Admission Number, Date of Admission , Admission
     * Year, Class Registered , Term Registered
     */
    public void validateForm() {
        //todo: check for mandatories
        if (admissionNumber.getText().isEmpty()) {
            throw new BadRequestException("Admission Number is Mandatory");
        }

        try {
            dateOfAdmission.getDate().toString();
        } catch (NullPointerException er) {
            throw new BadRequestException("Date of Regoistration  is Madantory");
        }

        if (admissionYear.getSelectedIndex() <= 0) {
            throw new BadRequestException("Select Admission Year");
        }

        if (registeredClass.getSelectedIndex() <= 0) {
            throw new BadRequestException("Select Class of Registration ");
        }

        if (registeredTerm.getSelectedIndex() <= 0) {
            throw new BadRequestException("Select Term of Registration ");
        }

    }

    public void submit() {
        String addmission_number = admissionNumber.getText();
        Long date_of_admission = dateOfAdmission.getDate().getTime();
        Integer selecteYearIndex = admissionYear.getSelectedIndex() - 1;
        Integer admissionYear = studyYearResponses.get(selecteYearIndex).getId();
        Integer admissionClass = classResponses.get(registeredClass.getSelectedIndex() - 1).getId();
        Integer admissionTerm = termResponses.get(registeredTerm.getSelectedIndex() - 1).getId();

        _StudentTermRegistration registration = populateEntity(addmission_number, admissionTerm, admissionClass);

        try {
            TermRegistrationService.getInstance(schoolData).create(registration, TOOL_TIP_TEXT_KEY);
            JOptionPane.showMessageDialog(null, " Record saved succesfully");
            reset();
        } catch (HeadlessException | IOException er) {
            throw new BadRequestException("Something went wrong, record could not be saved ");
        }
    }

    public _StudentTermRegistration populateEntity(String addmission_number, Integer admissionTerm, Integer admissionClass) {
        //populateEntity(firstname, middlename, lastname, studentSex, dateOfBirth, admissionNumber, admissionClass, admissionTerm, addmissionDate);
        _StudentTermRegistration registration = new _StudentTermRegistration();
        registration.setAdmission_number(addmission_number);
        registration.setTerm_id(admissionTerm);
        registration.setClass_id(admissionClass);
        registration.setStatus(StatusEnum.ACTIVE);
        return registration;
    }

    public void reset() {
        admissionNumber.setText("");
        dateOfAdmission.setDate(null);
        admissionYear.setSelectedIndex(-1);
        registeredClass.setSelectedIndex(-1);
        registeredTerm.setSelectedIndex(-1);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admissionNumber;
    private javax.swing.JComboBox<String> admissionYear;
    private org.jdesktop.swingx.JXDatePicker dateOfAdmission;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> registeredClass;
    private javax.swing.JComboBox<String> registeredTerm;
    // End of variables declaration//GEN-END:variables
}
