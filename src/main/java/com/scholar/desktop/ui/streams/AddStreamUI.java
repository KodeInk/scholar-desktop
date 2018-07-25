/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.streams;

import java.awt.HeadlessException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.request.Classes;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.response.ClassResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.streams.request.Stream;
import main.java.com.scholar.desktop.engine.caller.api.v1.streams.response.StreamResponse;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.services.classes.ClassesService;
import main.java.com.scholar.desktop.services.streams.StreamsService;
import main.java.com.scholar.desktop.ui.classes.AddClassUI;

/**
 *
 * @author mover 7/22/2018
 */
public class AddStreamUI extends javax.swing.JPanel {

    /**
     * Creates new form AddStreamUI
     */
    private static AddStreamUI instance;
    private SchoolData schoolData;
    private ClassResponse classResponse;
    private StreamResponse streamResponse;

    public AddStreamUI(SchoolData schoolData) {
        this.schoolData = schoolData;
        initComponents();
    }

    public static AddStreamUI getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new AddStreamUI(schoolData);
        }

        return instance;
    }

    public void edit(StreamResponse streamResponse) {
        this.streamResponse = streamResponse;
        streamName.setText(streamResponse.getName());
        streamCode.setText(streamResponse.getCode());
        jButton1.setText("EDIT");
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
        streamCode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        streamName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jScrollPane1.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Stream  Information");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Name : *");
        jLabel2.setToolTipText("");

        streamCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamCodeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Code  : *");
        jLabel3.setToolTipText("");

        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CANCEL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(streamCode, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(streamName, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(222, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
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
                    .addComponent(streamName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streamCode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(323, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void streamCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streamCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streamCodeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //todo: form validation
        if (streamName.getText().isEmpty()) {
            throw new BadRequestException("Stream name is   mandatory");
        }
        if (streamCode.getText().isEmpty()) {
            throw new BadRequestException("Stream code is   mandatory");
        }

        Stream streams = getStream();

        String btnText = jButton1.getText();

        SubmitData(btnText, streams);

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     *
     * @param btnText
     * @param stream
     * @throws HeadlessException
     */
    public void SubmitData(String btnText, Stream stream) throws HeadlessException {
        switch (btnText) {
            case "SAVE":
                saveClass(stream);
                break;
            case "EDIT":
                editClass(stream);
                break;
            default:
                break;
        }
    }

    private void editClass(Stream stream) throws HeadlessException {
        try {
            //todo: get the clas_id
            if (classResponse == null) {
                throw new BadRequestException("Could update record, missing data");
            }

            stream.setId(classResponse.getId());
            StreamsService.getInstance(schoolData).edit(stream, "LOG_ID");
            JOptionPane.showMessageDialog(null, "Record saved succesfully");

            resetForm();

        } catch (IOException ex) {
            Logger.getLogger(AddClassUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went wrong, could not save class");
        }
    }

    private void saveClass(Stream stream) throws HeadlessException {
        try {
            //todi:  submit to sever
            StreamsService.getInstance(schoolData).create(stream, "LOG_ID");
            JOptionPane.showMessageDialog(null, "Record saved succesfully");

            resetForm();

        } catch (IOException ex) {
            Logger.getLogger(AddClassUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went wrong, could not save class");
        }
    }

    private void resetForm() {
        streamName.setText("");
        streamCode.setText("");

    }

    public Stream getStream() {
        Stream stream = new Stream();
        stream.setName(streamName.getText());
        stream.setCode(streamCode.getText());
        return stream;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField streamCode;
    private javax.swing.JTextField streamName;
    // End of variables declaration//GEN-END:variables
}
