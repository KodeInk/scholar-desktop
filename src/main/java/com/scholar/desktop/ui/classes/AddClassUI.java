/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.classes;

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
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.request.Classes;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.response.ClassResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.streams.response.StreamResponse;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.services.classes.ClassesService;
import main.java.com.scholar.desktop.services.streams.StreamsService;

/**
 *
 * @author MOVER 5/27/2018
 */
public final class AddClassUI extends javax.swing.JPanel {

    /**
     * Creates new form AddClassUI
     */
    private static AddClassUI instance;
    private SchoolData schoolData;
    private ClassResponse classResponse;
    private List<StreamResponse> streamResponses;
    List<Integer> curriculumList;
    private List<JCheckBox> checkBoxs = new ArrayList<>();

    /**
     *
     * @param schoolData
     */
    public AddClassUI(SchoolData schoolData) {
        this.schoolData = schoolData;
        initComponents();
        curriculumList = new ArrayList<>();

    }

    public void initData() {
        initRankComboBox();
        resetForm();
        saveButton.setText("SAVE");
        this.classResponse = null;
        fetchStreams();
        resetForm();
        resetList();

    }

    public void resetList() {
        if (curriculumList != null) {
            for (Integer x = 0; x < curriculumList.size(); x++) {
                curriculumList.remove(x);
            }
        }
    }

    public void enableMandatories() {
        saveButton.setEnabled(true);
        classNameField.setEnabled(true);
        classCodeField.setEnabled(true);
        RankJComboBoxField.setEnabled(true);
        if (checkBoxs != null) {
            checkBoxs.forEach((jcb) -> {
                jcb.setEnabled(true);
            });
        }
    }

    public void disableMandatories() {
        saveButton.setEnabled(false);
        classNameField.setEnabled(false);
        classCodeField.setEnabled(false);
        RankJComboBoxField.setEnabled(false);
        if (checkBoxs != null) {
            checkBoxs.forEach((jcb) -> {
                jcb.setEnabled(false);
            });
        }
    }

    /**
     *
     * @param schoolData
     * @return
     */
    public static AddClassUI getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new AddClassUI(schoolData);
        }
        return instance;
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
            classNameField.setText(classResponse.getName());
            classCodeField.setText(classResponse.getCode());
            RankJComboBoxField.setSelectedItem(classResponse.getRanking().toString());
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

    public void resetJCheckBoxes() {
        for (JCheckBox jcb : checkBoxs) {
            jcb.setSelected(false);
        }
    }

    /**
     *
     * @param classResponse
     */
    public void edit(ClassResponse classResponse) {
        this.classResponse = classResponse;
        fetchStreams();

    }

    public void initRankComboBox() {
        RankJComboBoxField.addItem("Select Option");
        for (int x = 0; x <= 10000; x++) {
            RankJComboBoxField.addItem("" + x);
        }
        RankJComboBoxField.setSelectedIndex(1);
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
            curriculumList.remove(permission);

            if (xx.isSelected()) {
                curriculumList.add(permission);
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
        classCodeField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        classNameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        RankJComboBoxField = new javax.swing.JComboBox<>();
        permissionsJpanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Class Information");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Name : *");
        jLabel2.setToolTipText("");

        classCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classCodeFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Code  : *");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Rank  : *");
        jLabel4.setToolTipText("");

        RankJComboBoxField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        permissionsJpanel.setBackground(new java.awt.Color(255, 153, 102));

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));
        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout permissionsJpanelLayout = new javax.swing.GroupLayout(permissionsJpanel);
        permissionsJpanel.setLayout(permissionsJpanelLayout);
        permissionsJpanelLayout.setHorizontalGroup(
            permissionsJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        permissionsJpanelLayout.setVerticalGroup(
            permissionsJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(permissionsJpanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Streams  : ");
        jLabel5.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(permissionsJpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RankJComboBoxField, javax.swing.GroupLayout.Alignment.LEADING, 0, 462, Short.MAX_VALUE)
                                .addComponent(classCodeField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(classNameField, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(classNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(RankJComboBoxField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(permissionsJpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void classCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classCodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classCodeFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        validateForm();
        Classes schoolClass = getSchoolClass();

        String btnText = saveButton.getText();

        SubmitData(btnText, schoolClass);


    }//GEN-LAST:event_saveButtonActionPerformed

    public void validateForm() throws BadRequestException {
        // TODO add your handling code here:
        //todo: form validation
        if (classNameField.getText().isEmpty()) {
            throw new BadRequestException("Class name is   mandatory");
        }
        if (classCodeField.getText().isEmpty()) {
            throw new BadRequestException("Class code is   mandatory");
        }
        if (RankJComboBoxField.getSelectedIndex() <= 1) {
            throw new BadRequestException("Rank   is   mandatory");
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     *
     * @param btnText
     * @param schoolClass
     * @throws HeadlessException
     */
    public void SubmitData(String btnText, Classes schoolClass) throws HeadlessException {
        switch (btnText) {
            case "SAVE":
                saveRecord(schoolClass);
                break;
            case "EDIT":
                editRecord(schoolClass);
                break;
            default:
                break;
        }
    }

    private void editRecord(Classes schoolClass) throws HeadlessException {
        try {
            //todo: get the clas_id
            if (classResponse == null) {
                throw new BadRequestException("Could update record, missing data");
            }

            schoolClass.setId(classResponse.getId());
            ClassesService.getInstance(schoolData).edit(schoolClass, "LOG_ID");
            JOptionPane.showMessageDialog(null, "Record saved succesfully");

            resetForm();

        } catch (IOException ex) {
            Logger.getLogger(AddClassUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went wrong, could not save class");
        }
    }

    private void saveRecord(Classes schoolClass) throws HeadlessException {
        try {
            //todi:  submit to sever
            ClassesService.getInstance(schoolData).create(schoolClass, "LOG_ID");
            JOptionPane.showMessageDialog(null, "Record saved succesfully");

            resetForm();

        } catch (IOException ex) {
            Logger.getLogger(AddClassUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went wrong, could not save class");
        }
    }

    private void resetForm() {
        classNameField.setText("");
        classCodeField.setText("");
        RankJComboBoxField.setSelectedIndex(1);
    }

    public Classes getSchoolClass() throws NumberFormatException {
        Classes schoolClass = new Classes();
        schoolClass.setName(classNameField.getText());
        schoolClass.setCode(classCodeField.getText());
        schoolClass.setRanking(Integer.valueOf(RankJComboBoxField.getSelectedItem().toString()));
        Integer[] streamArray = new Integer[curriculumList.size()];
        schoolClass.setStreams(curriculumList.toArray(streamArray));
        return schoolClass;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> RankJComboBoxField;
    private javax.swing.JTextField classCodeField;
    private javax.swing.JTextField classNameField;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JPanel permissionsJpanel;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
