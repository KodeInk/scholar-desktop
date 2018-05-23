/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.users;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.event.ListDataListener;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.profile.request.Profile;
import main.java.com.scholar.desktop.engine.caller.api.v1.role.response.RoleResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.staff.request.Staff;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.request.User;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.response.UserResponse;
import main.java.com.scholar.desktop.helper.Utilities;
import main.java.com.scholar.desktop.helper.exceptions.BadRequestException;
import main.java.com.scholar.desktop.services.roles.RolesService;
import main.java.com.scholar.desktop.services.users.UsersService;

/**
 *
 * @author mover
 */
public class AddUserUI extends javax.swing.JPanel {

    /**
     * Creates new form AddUserUI
     */
    private JFileChooser fileChooser;
    private List<RoleResponse> roleResponses;
    SchoolData schoolData = null;

    private static AddUserUI instance;
    ComboBoxModel<RoleResponse> comboBoxModel;
    JComboBox usersList;

    public AddUserUI(SchoolData schoolData) {
        this.schoolData = schoolData;

        initComboBoxModel();

        initComponents();
        fileChooser = new JFileChooser();
        //  roleResponses = fetchRoles(schoolData);

    }

    public static AddUserUI getInstance(SchoolData schoolData) {

        if (instance == null) {
            instance = new AddUserUI(schoolData);
        }

        return instance;
    }

    private void populateList(List<RoleResponse> roleResponses) {
        usersList.addItem("movers");
    }

    public void initData() {
        roleResponses = fetchRoles(schoolData);
    }

    private List<RoleResponse> fetchRoles(SchoolData schoolData) {

        if (roleResponses != null && roleResponses.size() > 0) {
            return roleResponses;
        }
        Utilities.ShowDialogMessage("Processing");
        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                roleResponses = RolesService.getInstance(schoolData).list(-1, -1);

                populateRolesComboBox();
                Utilities.hideDialog();

                return null;
            }

        };
        swingWorker.execute();

        return roleResponses;
    }

    public void populateRolesComboBox() {
        if (roleResponses != null) {
            for (RoleResponse response : roleResponses) {
                RolesJComboBox.addItem(response.getName());
            }
            RolesJComboBox.setSelectedItem(null);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        JFirstName = new javax.swing.JTextField();
        prefix_combo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        JLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        IsStaff = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Jusername = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        RolesJComboBox = new javax.swing.JComboBox<>();
        if(roleResponses != null){
            for(RoleResponse response: roleResponses){
                RolesJComboBox.addItem(response.getName());
            }
        }
        jLabel12 = new javax.swing.JLabel();
        JPassword1 = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        JPassword2 = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        IsTeacher = new javax.swing.JCheckBox();
        JoinDate = new org.jdesktop.swingx.JXDatePicker();
        JDateOfBirth = new org.jdesktop.swingx.JXDatePicker();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Profile Information");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("PREFIX");

        prefix_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MR", "MIS", "MRS" }));
        prefix_combo.setSelectedItem(null);
        prefix_combo.setName("prefix"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("FIRST NAME");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("LAST NAME");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("DATE OF BIRTH");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/com/scholar/desktop/ui/images/image_avatar.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("IMAGE");

        IsStaff.setBackground(new java.awt.Color(255, 255, 255));
        IsStaff.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                IsStaffStateChanged(evt);
            }
        });
        IsStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IsStaffMouseClicked(evt);
            }
        });
        IsStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsStaffActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("JOIN DATE");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("IS SAFF");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Login Credentials");

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("ROLE");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("USERNAME");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("PASSWORD");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("REPEAT PASSWORD");

        jButton2.setText("SAVE");
        jButton2.setActionCommand("save_user");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("CANCEL");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("IS TEACHER");

        IsTeacher.setBackground(new java.awt.Color(255, 255, 255));
        IsTeacher.setEnabled(false);
        IsTeacher.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                IsTeacherStateChanged(evt);
            }
        });
        IsTeacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IsTeacherMouseClicked(evt);
            }
        });
        IsTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsTeacherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(JPassword1)
                        .addComponent(Jusername)
                        .addComponent(RolesJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)))
                .addGap(850, 850, 850))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JLastName)
                                        .addComponent(JFirstName)
                                        .addComponent(prefix_combo, 0, 469, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(IsStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel15)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(IsTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JoinDate, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(JDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel10)))
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
                    .addComponent(prefix_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel15)
                            .addComponent(IsStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IsTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(JoinDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)))
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jusername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(RolesJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JDateOfBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDateOfBirthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JDateOfBirthActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            // textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            File f = fileChooser.getSelectedFile();
            String filename = f.getAbsolutePath();
            try {
                ImageIcon ii = new ImageIcon(scaleImage(120, 120, ImageIO.read(new File(f.getAbsolutePath()))));//get the image from file chooser and scale it to match JLabel size
                jLabel6.setIcon(ii);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            // JOptionPane.showMessageDialog(null, "MOVERS ");
        }

//         if (mode == MODE_OPEN) {
//            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//               // textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
//            }
//        } else if (mode == MODE_SAVE) {
//            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
//                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
//            }
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static BufferedImage scaleImage(int w, int h, BufferedImage img) throws Exception {
        BufferedImage bi;
        bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(img, 0, 0, w, h, null);
        g2d.dispose();
        return bi;
    }

    private void IsStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsStaffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IsStaffActionPerformed

    private void JoinDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoinDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JoinDateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        validateForm();
        submitForm();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void IsStaffStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_IsStaffStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_IsStaffStateChanged

    private void IsStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IsStaffMouseClicked
        // TODO add your handling code here:
        JoinDate.setEnabled(false);
        JoinDate.setDate(null);
        IsTeacher.setEnabled(false);
        IsTeacher.setSelected(false);

        if (IsStaff.isSelected() == true) {
            JoinDate.setEnabled(true);
            IsTeacher.setEnabled(true);
        }

    }//GEN-LAST:event_IsStaffMouseClicked

    private void IsTeacherStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_IsTeacherStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_IsTeacherStateChanged

    private void IsTeacherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IsTeacherMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_IsTeacherMouseClicked

    private void IsTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsTeacherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IsTeacherActionPerformed

    private void submitForm() {
        User user = getFormData();
        //todo: create a swing worker to send data to the server : and wait
        Utilities.ShowDialogMessage("Processing");
        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                UserResponse ur = UsersService.getInstance(schoolData).create(user, "LOG ID ");
                Utilities.hideDialog();
                if (ur != null) {
                    JOptionPane.showMessageDialog(null, "Record Saved Successfuly");
                }
                return null;
            }
        };
        swingWorker.execute();
    }

    public User getFormData() {
        Long joinDate = JoinDate.getDate().getTime();

        String prefix = prefix_combo.getSelectedItem().toString();
        String firstName = JFirstName.getText();
        String lastName = JLastName.getText();
        Long dob = JDateOfBirth.getDate().getTime();
        System.out.println(" DATE OF BIRTH : " + dob);

        String username = Jusername.getText();
        RoleResponse roleResponse = roleResponses.get(RolesJComboBox.getSelectedIndex());
        JOptionPane.showMessageDialog(this, "ROLE " + roleResponse.getName());

        char[] password1 = JPassword1.getPassword();
        char[] password2 = JPassword2.getPassword();

        Profile profile = getProfile(firstName, lastName, prefix, dob);
        Staff staff = getStaff(profile, joinDate);

        User user = getUser(profile, username, String.valueOf(password1), staff, roleResponse);

        return user;

    }

    public void validateForm() {

        if (IsStaff.isSelected() == true) {
            try {
                JoinDate.getDate().toString();
            } catch (NullPointerException er) {
                throw new BadRequestException("Staff Join Date  is Madantory");
            }
        }

        if (prefix_combo.getSelectedIndex() == -1) {
            throw new BadRequestException("Prefix is required ");
        }
        if (JFirstName.getText().isEmpty()) {
            throw new BadRequestException("First Name  is required ");
        }

        if (JLastName.getText().isEmpty()) {
            throw new BadRequestException("Last Name  is required ");
        }

        try {
            JDateOfBirth.getDate().toString();
        } catch (NullPointerException er) {
            throw new BadRequestException("Date of Birth is Madantory");
        }

        if (Jusername.getText().isEmpty()) {
            throw new BadRequestException("Username is Empty ");
        }

        if (RolesJComboBox.getSelectedIndex() == -1) {
            throw new BadRequestException("Role  is required ");
        }

        if (JPassword1.getText().isEmpty()) {
            throw new BadRequestException("Password  is Empty ");
        }

        if (JPassword2.getText().isEmpty()) {
            throw new BadRequestException("Repeate Password  is Empty ");
        }

        char[] password1 = JPassword1.getPassword();
        char[] password2 = JPassword2.getPassword();

        ValidatePassword(password1, password2);
    }

    public User getUser(Profile profile, String username, String password2, Staff staff, RoleResponse role) {
        //todo:missing Email in the Contact List : probably add email Address, POBOX phone number etc :
        User user = new User();
        user.setProfile(profile);
        user.setUsername(username);
        user.setPassword(password2);
        user.setStaff(staff);
        user.setProfile(profile);
        String[] roles = new String[1];
        roles[0] = role.getName();
        user.setRoles(roles);

        return user;
    }

    public Profile getProfile(String firstName, String lastName, String prefix, Long dob) {
        Profile profile = new Profile();
        profile.setFirstName(firstName);
        profile.setLastName(lastName);
        profile.setPrefix(prefix);
        profile.setDateOfBirth(dob);
        return profile;
    }

    public Staff getStaff(Profile profile, Long joinDate) {
        Staff staff = null;
        if (IsStaff.isSelected() == true) {
            staff = new Staff();
            //staff.setIsTeacher(Boolean.TRUE);
            if (IsStaff.isSelected() == true) {
                staff.setIsTeacher(true);
            }
            staff.setProfile(profile);
            staff.setJoinDate(joinDate);
        }
        return staff;
    }

    /**
     *
     */
    public void initComboBoxModel() {
        comboBoxModel = new ComboBoxModel<RoleResponse>() {
            @Override
            public void setSelectedItem(Object anItem) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object getSelectedItem() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int getSize() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public RoleResponse getElementAt(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void addListDataListener(ListDataListener l) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeListDataListener(ListDataListener l) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }

    public void ValidatePassword(char[] password1, char[] password2) throws BadRequestException {
        String passwordOne = String.valueOf(password1);
        String passwordTwo = String.valueOf(password2);

        if (!passwordOne.equals(passwordTwo)) {
            throw new BadRequestException("Password does not match repeat password ");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox IsStaff;
    private javax.swing.JCheckBox IsTeacher;
    private org.jdesktop.swingx.JXDatePicker JDateOfBirth;
    private javax.swing.JTextField JFirstName;
    private javax.swing.JTextField JLastName;
    private javax.swing.JPasswordField JPassword1;
    private javax.swing.JPasswordField JPassword2;
    private org.jdesktop.swingx.JXDatePicker JoinDate;
    private javax.swing.JTextField Jusername;
    public javax.swing.JComboBox<String> RolesJComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> prefix_combo;
    // End of variables declaration//GEN-END:variables
}
