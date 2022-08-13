package Court;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Assign_Case extends javax.swing.JInternalFrame {

    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String p_name;
    int i_no = 0;

    public Assign_Case() {
        initComponents();

        try {
            //con=re.getCon();

            conn = DatabaseConnection.connectToDb();
            st = (Statement) conn.createStatement();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        UpdateTable();
        UpdateJudgeCombo();

    }

    private void UpdateTable() {
        try {
            String j="Unassigned";
            String sql = "SELECT * FROM cases WHERE Judge='"+j+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_case_details.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(Assign_Case.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void UpdateJudgeCombo() {
        try {
            String j="Judge";
            String sql = "SELECT Name FROM users where AccountType='"+j+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                cmb_Judge.addItem(rs.getString("Name"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Assign_Case.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        pupil_details = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txt_caseNo = new javax.swing.JTextField();
        cmb_Judge = new javax.swing.JComboBox<>();
        jButton17 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_case_details = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");
        jButton1.setName("jButton1"); // NOI18N

        setBackground(new java.awt.Color(0, 0, 0));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        pupil_details.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pupil_details.setName("pupil_details"); // NOI18N

        jPanel10.setBackground(new java.awt.Color(82, 24, 24));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel10.setName("jPanel10"); // NOI18N

        jLabel46.setFont(new java.awt.Font("Tekton Pro Ext", 1, 14)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Click Case Details Then Select Judge To Assign Case");
        jLabel46.setName("jLabel46"); // NOI18N

        jLabel50.setText("Case No.:");
        jLabel50.setName("jLabel50"); // NOI18N

        txt_caseNo.setEditable(false);
        txt_caseNo.setName("txt_caseNo"); // NOI18N

        cmb_Judge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose Action--" }));
        cmb_Judge.setName("cmb_Judge"); // NOI18N

        jButton17.setText("OK");
        jButton17.setName("jButton17"); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(18, 18, 18)
                        .addComponent(txt_caseNo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_Judge, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(jButton17)
                        .addGap(64, 64, 64))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txt_caseNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_Judge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        table_case_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_case_details.setName("table_case_details"); // NOI18N
        table_case_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_case_detailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_case_details);

        javax.swing.GroupLayout pupil_detailsLayout = new javax.swing.GroupLayout(pupil_details);
        pupil_details.setLayout(pupil_detailsLayout);
        pupil_detailsLayout.setHorizontalGroup(
            pupil_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pupil_detailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pupil_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pupil_detailsLayout.setVerticalGroup(
            pupil_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pupil_detailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(82, 24, 24));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tekton Pro Ext", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Assign Judge");
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pupil_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(9, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(427, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(88, Short.MAX_VALUE)
                    .addComponent(pupil_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
       if(cmb_Judge.getSelectedIndex()==0){
           JOptionPane.showMessageDialog(null, "Please Assign Judge");
       }
        try {
            String sql2 = "UPDATE cases SET Judge=? WHERE Case_No=?";
            pst = conn.prepareStatement(sql2);

            pst.setString(1, cmb_Judge.getSelectedItem().toString());
            pst.setString(2, txt_caseNo.getText().toUpperCase());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Case Successfully Updated");
            UpdateTable();
            cmb_Judge.setSelectedIndex(0);
            txt_caseNo.setText(null);
        } catch (SQLException ex) {
            Logger.getLogger(Assign_Case.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void table_case_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_case_detailsMouseClicked
        int rw = table_case_details.getSelectedRow();
        String click = (table_case_details.getModel().getValueAt(rw, 1).toString());
        try {

            String sql = "select * from cases where Case_No='" + click + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String bknum = rs.getString("Case_No");
              
                txt_caseNo.setText(bknum);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_table_case_detailsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmb_Judge;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton17;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pupil_details;
    private javax.swing.JTable table_case_details;
    private javax.swing.JTextField txt_caseNo;
    // End of variables declaration//GEN-END:variables

}
