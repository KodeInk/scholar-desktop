/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.subjects;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.response.ClassResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.streams.response.StreamResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.subjects.request.Subject;
import main.java.com.scholar.desktop.engine.caller.api.v1.subjects.request.SubjectTypeEnum;
import main.java.com.scholar.desktop.engine.caller.api.v1.subjects.response.SubjectResponse;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.services.streams.StreamsService;
import main.java.com.scholar.desktop.services.subjects.SubjectsService;

/**
 *
 * @author mover
 */
public class AddSubjectUI extends javax.swing.JPanel {

    /**
     * Creates new form AddSubjectUI
     */
    private SchoolData schoolData;
    private static AddSubjectUI instance = null;
    private SubjectResponse subjectResponse;

    private List<StreamResponse> streamResponses;
    List<Integer> streamList;
    private List<JCheckBox> checkBoxs = new ArrayList<>();
    private ClassResponse classResponse;

    public AddSubjectUI(SchoolData schoolData) {
        this.schoolData = schoolData;
        initComponents();

    }

    public static AddSubjectUI getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new AddSubjectUI(schoolData);
        }

        return instance;
    }

    public void initData() {
        saveButton.setText("SAVE");
        resetForm();
    }

    public void edit(SubjectResponse subjectResponse) {
        this.subjectResponse = subjectResponse;
        subjectNameField.setText(subjectResponse.getName());
        subjectCodeField.setText(subjectResponse.getCode());
        categoryField.setSelectedItem(subjectResponse.getType());
        saveButton.setText("EDIT");
    }

    public void fetchStreams() {
        jLabel1.setText("Processing...");
        if (streamResponses != null && streamResponses.size() > 0) {
            populateStreams();
        }

        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {

                streamResponses = StreamsService.getInstance(schoolData).list(0, 10000);
                populateStreams();
                jLabel1.setText("Class Information");

                return null;
            }
        };
        swingWorker.execute();

    }

    public void populateStreams() {
        resetJCheckBoxes();
        if (checkBoxs != null && checkBoxs.isEmpty()) {
            JPanel jPanel = null;

            if (streamResponses != null) {
                jPanel = getJpanel("STREAMS", streamResponses);

            }
            if (jPanel != null) {
                jScrollPane3.setPreferredSize(new Dimension(450, 300));
                jScrollPane3.setViewportView(jPanel);
                jScrollPane3.repaint();
            }
        }

        if (this.classResponse != null) {
            subjectNameField.setText(classResponse.getName());
            subjectCodeField.setText(classResponse.getCode());
            categoryField.setSelectedItem(classResponse.getRanking().toString());
            saveButton.setText("EDIT");

            List<StreamResponse> srs = Arrays.asList(classResponse.getStreamResponses());
            if (checkBoxs != null && checkBoxs.size() > 0) {
                for (JCheckBox jcb : checkBoxs) {
                    for (StreamResponse sr : srs) {
                        if (jcb.getActionCommand().equals(sr.getId().toString())) {
                            jcb.setSelected(true);
                        }

                    }
                }

            }
        }

    }

    public JPanel getJpanel(String grouping, List<StreamResponse> list) {

        JPanel container1 = new JPanel();
        container1.setBackground(new java.awt.Color(204, 204, 204));

        container1.setPreferredSize(new Dimension(450, 300));

        JPanel container2 = new JPanel();
        container2.setSize(600, 200);
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

        for (StreamResponse pr : list) {

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

    public void resetJCheckBoxes() {
        for (JCheckBox jcb : checkBoxs) {
            jcb.setSelected(false);
        }
    }

    private JCheckBox getCheckBox(StreamResponse pr) {
        JCheckBox jCheckBoxx = new JCheckBox();
        jCheckBoxx.setText(pr.getName());
        jCheckBoxx.setActionCommand(pr.getId().toString());
        jCheckBoxx.addActionListener((ActionEvent e) -> {
            JCheckBox xx = (JCheckBox) e.getSource();

            /*
            Add permission to the permission List at selection 
             */
            Integer permission = Integer.parseInt(xx.getActionCommand());
            streamList.remove(permission);

            if (xx.isSelected()) {
                streamList.add(permission);
            }

        });

        checkBoxs.add(jCheckBoxx);
        return jCheckBoxx;
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
        subjectCodeField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        subjectNameField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        categoryField = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        clasesJpanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Subject Information");

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

        categoryField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAJOR", "ELECTIVE" }));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Type  : *");
        jLabel4.setToolTipText("");

        clasesJpanel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));
        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout clasesJpanelLayout = new javax.swing.GroupLayout(clasesJpanel);
        clasesJpanel.setLayout(clasesJpanelLayout);
        clasesJpanelLayout.setHorizontalGroup(
            clasesJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        clasesJpanelLayout.setVerticalGroup(
            clasesJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clasesJpanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Classes  : ");
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
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clasesJpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subjectNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                            .addComponent(subjectCodeField, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                            .addComponent(categoryField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(104, Short.MAX_VALUE))
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
                    .addComponent(subjectNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(subjectCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clasesJpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
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
        // TODO add your handling code here:
        //todo: form validation
        if (subjectNameField.getText().isEmpty()) {
            throw new BadRequestException("Subject name is   mandatory");
        }
        if (subjectCodeField.getText().isEmpty()) {
            throw new BadRequestException("Subject code is   mandatory");
        }

        if (categoryField.getSelectedIndex() == -1) {
            throw new BadRequestException("Subject category is mandatory");
        }

        Subject subject = getSubject();

        SubmitData(saveButton.getText(), subject);


    }//GEN-LAST:event_saveButtonActionPerformed

    public void SubmitData(String btnText, Subject subject) throws HeadlessException {
        switch (btnText) {
            case "SAVE":
                saveSubject(subject);
                break;
            case "EDIT":
                editSubject(subject);
                break;
            default:
                break;
        }

    }

    private void resetForm() {
        subjectNameField.setText("");
        subjectCodeField.setText("");
        categoryField.setSelectedIndex(-1);
    }

    private void saveSubject(Subject subject) throws HeadlessException {
        try {

            SubjectResponse subjectResponse = SubjectsService.getInstance(schoolData).create(subject, "LOG ID");
            JOptionPane.showMessageDialog(this, "Record Saved Successfully");
            resetForm();

        } catch (IOException ex) {
            Logger.getLogger(AddSubjectUI.class.getName()).log(Level.SEVERE, null, ex);
            throw new BadRequestException("Could not save the record to the server, something went wrong");
        }

    }

    private void editSubject(Subject subject) throws HeadlessException {
        try {

            if (subjectResponse == null) {
                throw new BadRequestException("Could update record, missing data");
            }

            subject.setId(subjectResponse.getId());
            SubjectsService.getInstance(schoolData).edit(subject, "LOG ID");
            JOptionPane.showMessageDialog(this, "Record Saved Successfully");
            resetForm();

        } catch (IOException ex) {
            Logger.getLogger(AddSubjectUI.class.getName()).log(Level.SEVERE, null, ex);
            throw new BadRequestException("Could not save the record to the server, something went wrong");
        }

    }

    private Subject getSubject() {
        Subject subject = new Subject();
        subject.setName(subjectNameField.getText());
        subject.setCode(subjectCodeField.getText());
        subject.setType(SubjectTypeEnum.fromString(categoryField.getSelectedItem().toString()));
        return subject;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> categoryField;
    private javax.swing.JPanel clasesJpanel;
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
    private javax.swing.JTextField subjectCodeField;
    private javax.swing.JTextField subjectNameField;
    // End of variables declaration//GEN-END:variables
}
