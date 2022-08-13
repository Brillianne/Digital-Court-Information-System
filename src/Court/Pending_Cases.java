package Court;

import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Pending_Cases extends javax.swing.JInternalFrame {

    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public Pending_Cases() {
        initComponents();
        try {
            //con=re.getCon();
            conn = DatabaseConnection.connectToDb();
            st = (Statement) conn.createStatement();
            CasesTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void CasesTable() {
        try {
            String stat = "New";
            String j=Court_Main.user.getText();
            String sql1 = "select DISTINCT Case_No,Offence,Date_Reported,Narration from Cases WHERE Judge='"+j+"' AND Status='" + stat + "' ";
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            caseTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (Exception e) {
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        caseNo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        caseTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(82, 24, 24));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CLICK ON CASE NO. THEN OK TO PROCEED");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Case No.:");
        jLabel3.setName("jLabel3"); // NOI18N

        caseNo.setBackground(new java.awt.Color(255, 255, 204));
        caseNo.setName("caseNo"); // NOI18N
        caseNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseNoActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("OK");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        caseTable.setBackground(java.awt.Color.darkGray);
        caseTable.setFont(new java.awt.Font("Goudy Old Style", 1, 18)); // NOI18N
        caseTable.setForeground(new java.awt.Color(102, 255, 102));
        caseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        caseTable.setName("caseTable"); // NOI18N
        caseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caseTableMouseClicked(evt);
            }
        });
        caseTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caseTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(caseTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(caseNo, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(286, 286, 286))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caseNo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void caseNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caseNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caseNoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JOptionPane.showMessageDialog(null, "Proceed");

            View_Case1 vs = new View_Case1();
            Court_Main.jDesktopPane1.add(vs);
            vs.setVisible(true);
            this.dispose();

            
            String sql = "select * from cases where Case_No='" + caseNo.getText() + "' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            vs.case_no.setText(rs.getString("Case_No"));
            vs.txt_offence.setText(rs.getString("Offence"));
            vs.date_committed.setDate(rs.getDate("Date_Committed"));
            vs.date_Reported.setDate(rs.getDate("Date_Reported"));
            vs.jTextArea1.setText(rs.getString("Narration"));
            String sql1 = "select * from complainants where Case_No='" + caseNo.getText() + "' ";
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            rs.next();
            vs.txt_regno1.setText(rs.getString("National_Id"));
            vs.txt_fullname1.setText(rs.getString("FullName"));
            vs.txt_course1.setText(rs.getString("Age"));
            vs.jComboBox1.setSelectedItem(rs.getString("Gender"));
            vs.jTextArea2.setText(rs.getString("Address"));
             String sql2 = "select * from respondents where Case_No='" + caseNo.getText() + "' ";
            pst = conn.prepareStatement(sql2);
            rs = pst.executeQuery();
            rs.next();
            vs.txt_regno2.setText(rs.getString("National_Id"));
            vs.txt_fullname2.setText(rs.getString("FullName"));
            vs.txt_course2.setText(rs.getString("Age"));
            vs.jComboBox3.setSelectedItem(rs.getString("Gender"));
            vs.jTextArea3.setText(rs.getString("Address"));

           

        } catch (Exception e) {
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void caseTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caseTableKeyReleased
        int rw = caseTable.getSelectedRow();
        String click = (caseTable.getModel().getValueAt(rw, 0).toString());
        try {
            String sql1 = "select * from cases where Case_No='" + click + "' ";
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            rs.next();
            caseNo.setText(rs.getString(click));

        } catch (Exception e) {
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_caseTableKeyReleased

    private void caseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caseTableMouseClicked

        int rw = caseTable.getSelectedRow();
        String click = (caseTable.getModel().getValueAt(rw, 0).toString());
        try {
            String sql1 = "select * from cases where Case_No='" + click + "' ";
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            rs.next();
            caseNo.setText(rs.getString("Case_No"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_caseTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField caseNo;
    private javax.swing.JTable caseTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
