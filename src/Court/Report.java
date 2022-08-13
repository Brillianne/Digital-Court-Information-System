package Court;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Report extends javax.swing.JInternalFrame {

    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String username = "korom";
    int i_no = 0;

    public Report() {
        initComponents();

        try {

            conn = DatabaseConnection.connectToDb();
            st = (Statement) conn.createStatement();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        UpdateTable();
        
    }

    private void UpdateTable() {
        try {
            String sql2 = "SELECT * FROM cases ";
            pst = conn.prepareStatement(sql2);
            rs = pst.executeQuery();
            case_info_table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createReport() throws SQLException {
        try {
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document(PageSize.A4);

            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("Report.pdf"));

            doc.open();

            com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance("cofarms2.png");

            img.scaleAbsolute(70, 70);
            img.setAlignment(Image.ALIGN_CENTER);
            doc.add(img);

            Paragraph p;
            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
            //String date1 = ((JTextField) Court_Main.txt_dated.getDateEditor().getUiComponent()).getText();
            // Paragraph p;
            p = new Paragraph("REPUBLIC OF KENYA", FontFactory.getFont(FontFactory.TIMES_BOLD, 12));
            p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            doc.add(p);
            p = new Paragraph("THE JUDICIARY", FontFactory.getFont(FontFactory.TIMES_BOLD, 18));
            p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            doc.add(p);
            p = new Paragraph("DIGITAL COURT INVENTORY SYSTEM \n P.O. Box 19-20400 Nairobi", FontFactory.getFont(FontFactory.TIMES_BOLD, 12));
            p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            doc.add(p);
            //p = new Paragraph(((JTextField) txt_dated.getDateEditor().getUiComponent()).getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 12));
            // p.setAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
            //doc.add(p);

            //doc.addTitle(head);
            p = new com.itextpdf.text.Paragraph("RECORD OF CASES", FontFactory.getFont(FontFactory.TIMES_BOLD, 14, Font.BOLD, BaseColor.RED));
            p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            doc.add(p);

            doc.add(new com.itextpdf.text.Paragraph("=========================================================================="));

            p = new Paragraph("Ministry.....III...................     Dept./Branch....JUDICIARY..............     Unit....NETWORKS...........\n\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 12));
            p.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            doc.add(p);

            //p = new Paragraph("Being Inventory Issued Between Date: " + ((JTextField) date_from_Report.getDateEditor().getUiComponent()).getText() + "       To: " + ((JTextField) date_to_Report.getDateEditor().getUiComponent()).getText() + "\n\n", FontFactory.getFont(FontFactory.COURIER, 12));
            //p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            //doc.add(p);
            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10);
            table.setSpacingAfter(10);
            //table.setWidths(new int[]{3, 6, 3});
            PdfPCell hd = new PdfPCell(new com.itextpdf.text.Paragraph("Case Details"));
            hd.setColspan(7);
            hd.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
            hd.setBackgroundColor(BaseColor.BLUE);
            hd.setFixedHeight(20);
            table.addCell(hd);

            table.addCell("Case No");
            table.addCell("Offence");
            table.addCell("Date Committed");
            table.addCell("Date Reported");
            table.addCell("Narration");
            table.addCell("Judge");
            table.addCell("Charges");

            PdfPTable table1 = new PdfPTable(6);
            table1.setWidthPercentage(100);
            table1.setSpacingBefore(10);
            table1.setSpacingAfter(10);
            //table.setWidths(new int[]{3, 6, 3});
            PdfPCell hd1 = new PdfPCell(new com.itextpdf.text.Paragraph("Complainant Details"));
            hd1.setColspan(6);
            hd1.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
            hd1.setBackgroundColor(BaseColor.BLUE);
            hd1.setFixedHeight(20);
            table1.addCell(hd1);

            table1.addCell("Case No");
            table1.addCell("National Id");
            table1.addCell("FuLL Name");
            table1.addCell("Age");
            table1.addCell("Gender");
            table1.addCell("Address");
            
            
            PdfPTable table2 = new PdfPTable(6);
            table2.setWidthPercentage(100);
            table2.setSpacingBefore(10);
            table2.setSpacingAfter(10);
            //table.setWidths(new int[]{3, 6, 3});
            PdfPCell hd2 = new PdfPCell(new com.itextpdf.text.Paragraph("Respondent/Accused Details"));
            hd2.setColspan(6);
            hd2.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
            hd2.setBackgroundColor(BaseColor.BLUE);
            hd2.setFixedHeight(20);
            table2.addCell(hd2);

            table2.addCell("Case No");
            table2.addCell("National Id");
            table2.addCell("FuLL Name");
            table2.addCell("Age");
            table2.addCell("Gender");
            table2.addCell("Address");
            

            String sql1 = "select a.case_no,a.offence,a.date_committed,a.date_reported,a.narration,a.Judge,a.charges,b.national_id,b.FullName,b.Age,b.Gender,b.Address,c.national_id,c.FullName,c.Age,c.Gender,c.Address from Cases AS a JOIN complainants AS b JOIN respondents as c ON a.case_no=b.case_no=c.case_no where a.Status='" + cmb_year.getSelectedItem().toString() + "'";
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getString("a.case_no"));

                table.addCell(rs.getString("a.case_no"));
                table.addCell(rs.getString("a.Offence"));
                table.addCell(rs.getDate("a.Date_Committed").toString());
                table.addCell(rs.getDate("a.Date_Reported").toString());
                table.addCell(rs.getString("a.Narration"));
                table.addCell(rs.getString("a.Judge"));
                table.addCell(rs.getString("a.Charges"));

                table1.addCell(rs.getString("a.case_no"));
                table1.addCell(rs.getString("b.National_Id"));
                table1.addCell(rs.getString("b.FullName"));
                table1.addCell(rs.getString("b.Age"));
                table1.addCell(rs.getString("b.Gender"));
                table1.addCell(rs.getString("b.Address"));
                
                table2.addCell(rs.getString("a.case_no"));
                table2.addCell(rs.getString("c.National_Id"));
                table2.addCell(rs.getString("c.FullName"));
                table2.addCell(rs.getString("c.Age"));
                table2.addCell(rs.getString("c.Gender"));
                table2.addCell(rs.getString("c.Address"));

            }
            doc.add(table);
            doc.add(table1);
            doc.add(table2);

            JOptionPane.showMessageDialog(null, "Report Saved");
            openReport();

            doc.close();
        } catch (DocumentException | IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void openReport() {
       
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "  + "Report.pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        scrollPane2 = new java.awt.ScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        case_info_table = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cmb_year = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        jButton1.setText("jButton1");
        jButton1.setName("jButton1"); // NOI18N

        setBackground(new java.awt.Color(0, 0, 0));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setName("jPanel3"); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        jPanel4.setName("jPanel4"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("REPORTS");
        jLabel10.setName("jLabel10"); // NOI18N

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel7.setName("jPanel7"); // NOI18N

        jPanel11.setBackground(new java.awt.Color(82, 24, 24));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        jPanel11.setName("jPanel11"); // NOI18N

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "All Cases", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 153, 0))); // NOI18N
        jPanel12.setName("jPanel12"); // NOI18N

        scrollPane2.setName("scrollPane2"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        case_info_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        case_info_table.setName("case_info_table"); // NOI18N
        jScrollPane2.setViewportView(case_info_table);

        scrollPane2.add(jScrollPane2);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FILTER parameters", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 153, 0))); // NOI18N
        jPanel13.setName("jPanel13"); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel14.setText("Status:");
        jLabel14.setName("jLabel14"); // NOI18N

        cmb_year.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Case Status-", "New", "Pending", "Done" }));
        cmb_year.setName("cmb_year"); // NOI18N
        cmb_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_yearActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Printer.png"))); // NOI18N
        jButton3.setText("PRINT");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(341, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(326, 326, 326))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel14)
                .addGap(38, 38, 38)
                .addComponent(cmb_year, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmb_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(22, 22, 22))
        );

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("CASE RECORDS");
        jLabel12.setName("jLabel12"); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CASE RECORDS", jPanel7);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (cmb_year.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "SELECT ALL FIELDS");
        } else {
            try {
                createReport();
            } catch (SQLException ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cmb_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_yearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable case_info_table;
    private javax.swing.JComboBox cmb_year;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.ScrollPane scrollPane2;
    // End of variables declaration//GEN-END:variables

}
