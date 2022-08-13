package Court;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Search_Case1 extends javax.swing.JInternalFrame {

    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String p_name;
    int i_no = 0;

    public Search_Case1() {
        initComponents();

        try {
            //con=re.getCon();

            conn = DatabaseConnection.connectToDb();
            st = (Statement) conn.createStatement();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        UpdateTable();

    }

    private void UpdateTable() {
        try {
            String sql = "SELECT * FROM cases";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_case_details.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(Search_Case1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        pupil_details = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_case_details = new javax.swing.JTable();

        jButton1.setText("jButton1");
        jButton1.setName("jButton1"); // NOI18N

        setBackground(new java.awt.Color(0, 0, 0));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        pupil_details.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pupil_details.setName("pupil_details"); // NOI18N

        jPanel10.setBackground(new java.awt.Color(82, 24, 24));
        jPanel10.setName("jPanel10"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tekton Pro Ext", 1, 14)); // NOI18N
        jLabel2.setText("Search By Case No:");
        jLabel2.setName("jLabel2"); // NOI18N

        search.setName("search"); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(443, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
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
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        pupil_detailsLayout.setVerticalGroup(
            pupil_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pupil_detailsLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1287, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pupil_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pupil_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        try {

            String sql = "select * from cases where Case_No like '" + search.getText() + "%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_case_details.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception ex) {
            Logger.getLogger(Search_Case1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchKeyReleased

    private void table_case_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_case_detailsMouseClicked
      
    }//GEN-LAST:event_table_case_detailsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pupil_details;
    private javax.swing.JTextField search;
    private javax.swing.JTable table_case_details;
    // End of variables declaration//GEN-END:variables

}
