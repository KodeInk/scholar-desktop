/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.administration.students.admission;

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
import main.java.com.scholar.desktop.engine.caller.api.v1.profile.request.Profile;
import main.java.com.scholar.desktop.engine.caller.api.v1.students.admissions.request._StudentAdmission;
import main.java.com.scholar.desktop.engine.caller.api.v1.studyyear.response.StudyYearResponse;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.services.classes.ClassesService;
import main.java.com.scholar.desktop.services.students.admissions.AdmissionService;
import main.java.com.scholar.desktop.services.studyyear.StudyYearService;
import main.java.com.scholar.desktop.services.terms.TermsService;

/**
 *
 * @author MOVER
 */
public class AddAdmissionsUI extends javax.swing.JPanel {

    /**
     * Creates new form AddAdmissionsUI
     */
    private final SchoolData schoolData;
    private static AddAdmissionsUI instance;
    private List<StudyYearResponse> studyYearResponses = null;
    private List<ClassResponse> classResponses = null;

    public AddAdmissionsUI(SchoolData schoolData) {
        this.schoolData = schoolData;
        initComponents();
    }

    /**
     *
     * @param schoolData
     * @return
     */
    public static AddAdmissionsUI getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new AddAdmissionsUI(schoolData);
        }
        return instance;
    }

    /**
     *
     */
    public void initData() {
        //todo: get study year
        fetchStudyYear();
        //todo: get classes
        fetchClasses();

    }

    /**
     *
     */
    public void fetchStudyYear() {
        if (studyYearResponses != null) {
            populateStudyYearComboBox(studyYearResponses);
        } else {
            yearCombo.removeAll();
            yearCombo.addItem("Processing ...");
            SwingWorker swingWorker = new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    studyYearResponses = StudyYearService.getInstance(schoolData).list(-1, -1);
                    yearCombo.removeAll();
                    populateStudyYearComboBox(studyYearResponses);

                    return null;
                }
            };
            swingWorker.execute();
        }
    }

    public void fetchClasses() {
        if (classResponses != null) {
            populateClassesCombo(classResponses);
        } else {
            classCombo.removeAll();
            classCombo.addItem("Processing ...");
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

    public void populateClassesCombo(List<ClassResponse> ClassResponse) {
        //StudyYearCombo
        classCombo.removeAllItems();
        classCombo.addItem("Select Option");
        ClassResponse.forEach(aClass -> {
            try {
                classCombo.addItem(aClass.getName());
                classCombo.setActionCommand(aClass.getId().toString());

            } catch (Exception er) {

            }
        });

    }

    public void populateStudyYearComboBox(List<StudyYearResponse> studyYearResponses) {
        //StudyYearCombo
        yearCombo.removeAllItems();
        yearCombo.addItem("Select Option");
        studyYearResponses.forEach((StudyYearResponse syr) -> {
            try {
                yearCombo.addItem(syr.getTheme().concat(" [ ").concat(new Date(syr.getStart_date()).toString()).concat(" - ").concat(new Date(syr.getEnd_date()).toString()));
            } catch (Exception er) {
            }
        });

        yearCombo.addActionListener((ActionEvent e) -> {
            getSelectedYear();
        });

    }

    public void getSelectedYear() {
        termCombo.removeAllItems();

        if (yearCombo.getSelectedIndex() > 0) {
            StudyYearResponse syr = studyYearResponses.get(yearCombo.getSelectedIndex() - 1);
            fetchTerms(syr.getId());
        }

    }
    List<TermResponse> termResponses = null;

    public void fetchTerms(Integer studyYear) {

        termCombo.removeAllItems();
        termCombo.addItem("Processing ...");

        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                termResponses = TermsService.getInstance(schoolData).list(studyYear);
                termCombo.removeAllItems();
                termCombo.addItem("Select Option");
                termResponses.forEach((tr) -> {
                    termCombo.addItem(tr.getName());
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jFirstName = new javax.swing.JTextField();
        sex = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jMiddleName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDateOfBirth = new org.jdesktop.swingx.JXDatePicker();
        jLabel8 = new javax.swing.JLabel();
        jLastName = new javax.swing.JTextField();
        yearCombo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        classCombo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        termCombo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        admisionNumber = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        dateOfAdmission = new org.jdesktop.swingx.JXDatePicker();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Profile Information");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Sex");

        sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE", "OTHER" }));
        sex.setSelectedItem(null);
        sex.setName("prefix"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("FirstName");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("MiddleName");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Date Of Birth");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/com/scholar/desktop/ui/images/image_avatar.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Image");

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

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("LastName");

        yearCombo.setSelectedItem(null);
        yearCombo.setActionCommand("");
        yearCombo.setName("prefix"); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Year");

        classCombo.setSelectedItem(null);
        classCombo.setName("prefix"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Class");

        termCombo.setSelectedItem(null);
        termCombo.setName("prefix"); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Term");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Admission Number");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Date of Admission");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jMiddleName)
                                        .addComponent(jFirstName)
                                        .addComponent(jDateOfBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                                        .addComponent(jLastName))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel9)
                        .addGap(60, 60, 60)
                        .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(termCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateOfAdmission, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(admisionNumber, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(781, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)))
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(termCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admisionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateOfAdmission, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

//        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            // textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
//            File f = fileChooser.getSelectedFile();
//            String filename = f.getAbsolutePath();
//            try {
//                ImageIcon ii = new ImageIcon(scaleImage(120, 120, ImageIO.read(new File(f.getAbsolutePath()))));//get the image from file chooser and scale it to match JLabel size
//                jLabel6.setIcon(ii);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//
//            // JOptionPane.showMessageDialog(null, "MOVERS ");
//        }
//
//        //         if (mode == MODE_OPEN) {
//            //            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//                //               // textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
//                //            }
//            //        } else if (mode == MODE_SAVE) {
//            //            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
//                //                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
//                //            }
//            //        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        validateForm();
        //todo: submit to server
        submit();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void submit() {
        String firstname = jFirstName.getText();
        String middlename = jMiddleName.getText();
        String lastname = jLastName.getText();
        String studentSex = sex.getSelectedItem().toString();
        Long dateOfBirth = jDateOfBirth.getDate().getTime();
        Integer selecteYearIndex = yearCombo.getSelectedIndex() - 1;
        Integer admissionYear = studyYearResponses.get(selecteYearIndex).getId();
        Integer admissionClass = classResponses.get(classCombo.getSelectedIndex() - 1).getId();
        Integer admissionTerm = termResponses.get(termCombo.getSelectedIndex() - 1).getId();
        String admissionNumber = admisionNumber.getText();
        Long addmissionDate = dateOfAdmission.getDate().getTime();

        _StudentAdmission studentAdmission = populateEntity(firstname, middlename, lastname, studentSex, dateOfBirth, admissionNumber, admissionClass, admissionTerm, addmissionDate);

        try {
            AdmissionService.getInstance(schoolData).create(studentAdmission, "LOG_ID");
            JOptionPane.showMessageDialog(null, " Record saved succesfully");
            reset();
        } catch (HeadlessException | IOException er) {
            throw new BadRequestException("Something went wrong, record could not be saved ");
        }

    }

    public void reset() {
        admisionNumber.setText("");
        jFirstName.setText("");
        jMiddleName.setText("");
        jLastName.setText("");
        sex.setSelectedIndex(0);
        yearCombo.setSelectedIndex(0);
        classCombo.setSelectedIndex(0);
        termCombo.setSelectedIndex(0);
    }

    /**
     *
     * @param firstname
     * @param middlename
     * @param lastname
     * @param studentSex
     * @param dateOfBirth
     * @param admissionNumber
     * @param admissionClass
     * @param admissionTerm
     * @param addmissionDate
     * @return
     */
    public _StudentAdmission populateEntity(String firstname, String middlename, String lastname, String studentSex, Long dateOfBirth, String admissionNumber, Integer admissionClass, Integer admissionTerm, Long addmissionDate) {
        Profile profile = new Profile();
        profile.setFirstName(firstname);
        profile.setMiddleName(middlename);
        profile.setLastName(lastname);
        profile.setSex(studentSex);
        profile.setDateOfBirth(dateOfBirth);
        _StudentAdmission studentAdmission = new _StudentAdmission();
        studentAdmission.setStudent(profile);
        studentAdmission.setAdmission_no(admissionNumber);
        studentAdmission.setClass_id(admissionClass);
        studentAdmission.setTerm_id(admissionTerm);
        studentAdmission.setDate_of_admission(addmissionDate);
        return studentAdmission;
    }

    /**
     *
     * @throws BadRequestException
     */
    public void validateForm() throws BadRequestException {
        //todo: validate the project
        if (jFirstName.getText().isEmpty()) {
            throw new BadRequestException("Firstname is mandatory");
        }
        if (jLastName.getText().isEmpty()) {
            throw new BadRequestException("Lastname is mandatory");
        }

        try {
            jDateOfBirth.getDate().toString();
        } catch (NullPointerException er) {
            throw new BadRequestException("Date of Birth is Madantory");
        }

        if (yearCombo.getSelectedIndex() <= 0) {
            throw new BadRequestException("Select Year");
        }

        if (classCombo.getSelectedIndex() <= 0) {
            throw new BadRequestException("Select Class");
        }

        if (termCombo.getSelectedIndex() <= 0) {
            throw new BadRequestException("Select Term");
        }

        if (admisionNumber.getText().isEmpty()) {
            throw new BadRequestException("Admission Number is mandatory");
        }

        try {
            dateOfAdmission.getDate().toString();
        } catch (NullPointerException er) {
            throw new BadRequestException("Date of Admission  is Madantory");
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admisionNumber;
    private javax.swing.JComboBox<String> classCombo;
    private org.jdesktop.swingx.JXDatePicker dateOfAdmission;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private org.jdesktop.swingx.JXDatePicker jDateOfBirth;
    private javax.swing.JTextField jFirstName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLastName;
    private javax.swing.JTextField jMiddleName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> sex;
    private javax.swing.JComboBox<String> termCombo;
    private javax.swing.JComboBox<String> yearCombo;
    // End of variables declaration//GEN-END:variables
}
