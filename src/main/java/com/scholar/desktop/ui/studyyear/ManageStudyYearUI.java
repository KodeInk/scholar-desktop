/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.studyyear;

import java.awt.Color;
import java.util.List;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import main.java.com.scholar.desktop.engine.caller.api.v1.studyyear.response.StudyYearResponse;
import main.java.com.scholar.desktop.helper.Utilities;
import main.java.com.scholar.desktop.services.studyyear.StudyYearService;
import main.java.com.scholar.desktop.ui.helper.SimpleHeaderRenderer;

/**
 *
 * @author mover 3/14/2018
 */
public class ManageStudyYearUI extends javax.swing.JPanel {

    /**
     * Creates new form ManageStudyYear
     */
    private static final String[] COLUMN_HEADERS = {"ID", "THEME", "START DATE", "END DATE", "# CURRICULUM", "STATUS", "DATE CREATED", "AUTHOR"};

    SchoolData schoolData = null;
    public DefaultTableModel tableModel;
    List<StudyYearResponse> list = null;
    private static ManageStudyYearUI instance;

    private Integer page;
    private Integer offset;
    private Integer limit;
    private String search = null;

    public ManageStudyYearUI(SchoolData schoolData) {
        this.schoolData = schoolData;

        if (tableModel == null) {
            tableModel = new DefaultTableModel(COLUMN_HEADERS, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }

            };

        }

        initComponents();
        searchbox.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        jTable1.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());
        initData();
        Utilities.hideColumn(0, jTable1);
    }

    public static ManageStudyYearUI getInstance(SchoolData schoolData) {
        if (instance == null) {
            instance = new ManageStudyYearUI(schoolData);
        }
        return instance;
    }

    public final void initData() {

        if (list != null) {
            populateJTable(list);
        }

        offset = Utilities.default_offset;
        limit = Utilities.default_limit;
        fetchData(offset, limit);
        page = 1;
        pageCounter.setText(page.toString());
    }

    protected void fetchData() {
        if (search != null) {
            fetchData(search, offset, limit);
        } else {
            fetchData(offset, limit);
        }
    }

    protected void fetchData(String search, Integer offset, Integer limit) {
        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                disableNextPrevLabels();
                jLabel1.setText("Processing....");
                List<StudyYearResponse> crs = StudyYearService.getInstance(schoolData).search(search, offset, limit, "LOG_ID");
                populateJTable(crs);
                repaint();
                jLabel1.setText("MANAGE STUDY PERIOD");
                enableNextPrevLabels();
                return null;
            }
        };
        swingWorker.execute();
    }

    public final void fetchData(Integer offset, Integer limit) {

        if (list != null) {
            populateJTable(list);
        }

        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                disableNextPrevLabels();
                jLabel1.setText("Processing....");
                list = StudyYearService.getInstance(schoolData).list(offset, limit);
                populateJTable(list);
                jLabel1.setText("MANAGE STUDY PERIOD");
                enableNextPrevLabels();
                return null;
            }
        };
        swingWorker.execute();

    }

    public void populateJTable(List<StudyYearResponse> list) {
        if (list != null) {

            Utilities.removeRowsFromDefaultModel(tableModel);

            list.stream().map((response) -> {
                Integer id = response.getId();
                String theme = response.getTheme().toUpperCase();
                String start_date = Utilities.getFullDateString(response.getStart_date()).toUpperCase();
                String end_date = Utilities.getFullDateString(response.getEnd_date()).toUpperCase();
                String status = response.getStatus().toUpperCase();
                String DateCreated = Utilities.getFullDateString(response.getDate_created()).toUpperCase();
                //new Date(response.getDate_created()).toString().toUpperCase();
                String author = response.getAuthor().toUpperCase();
                Integer numberOfCurriculum = (response.getCurricula() != null ? response.getCurricula().size() : 0);
                Object[] data = {id, theme, start_date, end_date, numberOfCurriculum, status, DateCreated, author};
                return data;
            }).forEachOrdered((data) -> {
                tableModel.addRow(data);
            });
        }

        tableModel.fireTableDataChanged();

    }

    protected void enableNextPrevLabels() {
        searchbox.setEnabled(true);
        nextLabel.setEnabled(true);
        prevLabel.setEnabled(true);
        searchButton.setEnabled(true);
    }

    protected void disableNextPrevLabels() {
        searchbox.setEnabled(false);
        searchButton.setEnabled(false);
        nextLabel.setEnabled(false);
        prevLabel.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this start_date. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        prevLabel = new javax.swing.JLabel();
        pageCounter = new javax.swing.JLabel();
        nextLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        jSplitPane1.setDividerLocation(570);
        jSplitPane1.setDividerSize(2);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("MANAGE STUDY PERIOD");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/com/scholar/desktop/ui/images/list.png"))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/com/scholar/desktop/ui/images/detail.png"))); // NOI18N

        searchbox.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        searchbox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        searchbox.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 5));
        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });

        jLabel8.setText("SEARCH:");

        searchButton.setBackground(new java.awt.Color(255, 255, 255));
        searchButton.setText("GO");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(287, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(searchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(searchbox, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTable1.setModel(tableModel);
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(255, 204, 153));
        jTable1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        prevLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prevLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/com/scholar/desktop/ui/images/prev.png"))); // NOI18N
        prevLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prevLabelMouseClicked(evt);
            }
        });

        pageCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageCounter.setText("123");

        nextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nextLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/com/scholar/desktop/ui/images/next.png"))); // NOI18N
        nextLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(682, Short.MAX_VALUE)
                .addComponent(prevLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pageCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextLabel)
                .addGap(13, 13, 13))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(prevLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pageCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(nextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane1.setTopComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
        searchQuery();
    }//GEN-LAST:event_searchboxActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        searchQuery();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void prevLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevLabelMouseClicked
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_prevLabelMouseClicked

    private void nextLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextLabelMouseClicked
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_nextLabelMouseClicked

    public void searchQuery() {
        // TODO add your handling code here:
        if (!searchbox.getText().isEmpty()) {

            offset = Utilities.default_offset;
            limit = Utilities.default_limit;
            page = 1;
            pageCounter.setText(page.toString());

            search = searchbox.getText();

            fetchData();

        } else {
            search = null;
            jLabel1.setText("Processing....");
            initData();
        }
        jLabel1.setText("Manage Classes");
    }

    Integer rowselect = 0;
    Integer mouseClick = 0;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        Integer row = jTable1.getSelectedRow();
        String value = jTable1.getModel().getValueAt(row, 0).toString();

        if (Objects.equals(rowselect, row)) {
            mouseClick++;
            //selectClassStreamsList
        } else {
            mouseClick = 1;
        }

        if (mouseClick % 2 == 0) {
            list.forEach(response -> {
                if (response.getId() == Integer.parseInt(value)) {
                    StudyYearUI.getInstance(schoolData).edit(response);
                }
            });
        }

        rowselect = row;
    }//GEN-LAST:event_jTable1MouseClicked

    protected void next() {
        offset = offset + limit;
        if (search != null) {
            fetchData();
        } else {
            fetchData();
        }

        page++;
        pageCounter.setText(page.toString());
    }

    protected void prev() {
        offset = offset - limit;
        if (offset >= 0) {
            if (search != null) {
                fetchData();
            } else {
                fetchData();
            }

            page--;
            pageCounter.setText(page.toString());
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nextLabel;
    private javax.swing.JLabel pageCounter;
    private javax.swing.JLabel prevLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchbox;
    // End of variables declaration//GEN-END:variables
}
