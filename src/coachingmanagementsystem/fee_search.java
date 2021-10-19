/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coachingmanagementsystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Tahmid
 */
public class fee_search extends javax.swing.JFrame {

    /**
     * Creates new form fee_search
     */
    public fee_search() {
        initComponents();
    }
    
    public void disp_fees(){
        String name1=name.getText();
        String pem=p_method.getText();
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CoachingManagementSystem;user=sa;password=123456");
            String sql="select ad.administratorId as 'Admin ID',f.studentId as 'Student ID',s.studentFirstName+' '+s.studentLastName as Name,transactionMethod as 'Payment Method',paymentTime as 'Payment Date',totalAmount as 'Amount' FROM Administrator ad inner join Fees f ON ad.administratorId=f.administratorId inner join Students s ON s.studentId=f.studentId where f.administratorId= ?";
            String sql2="select ad.administratorId as 'Admin ID',f.studentId as 'Student ID',s.studentFirstName+' '+s.studentLastName as Name,transactionMethod as 'Payment Method',paymentTime as 'Payment Date',totalAmount as 'Amount' FROM Administrator ad inner join Fees f ON ad.administratorId=f.administratorId inner join Students s ON s.studentId=f.studentId where f.studentId= ?";
            String sql3="select ad.administratorId as 'Admin ID',f.studentId as 'Student ID',s.studentFirstName+' '+s.studentLastName as Name,transactionMethod as 'Payment Method',paymentTime as 'Payment Date',totalAmount as 'Amount' FROM Administrator ad inner join Fees f ON ad.administratorId=f.administratorId inner join Students s ON s.studentId=f.studentId where f.paymentTime>= ?";
            String sql4="select ad.administratorId as 'Admin ID',f.studentId as 'Student ID',s.studentFirstName+' '+s.studentLastName as Name,transactionMethod as 'Payment Method',paymentTime as 'Payment Date',totalAmount as 'Amount' FROM Administrator ad inner join Fees f ON ad.administratorId=f.administratorId inner join Students s ON s.studentId=f.studentId where f.paymentTime<= ?";
            String sql5="select ad.administratorId as 'Admin ID',f.studentId as 'Student ID',s.studentFirstName+' '+s.studentLastName as Name,transactionMethod as 'Payment Method',paymentTime as 'Payment Date',totalAmount as 'Amount' FROM Administrator ad inner join Fees f ON ad.administratorId=f.administratorId inner join Students s ON s.studentId=f.studentId where f.paymentTime between ? and ?";
            String sql6="select ad.administratorId as 'Admin ID',f.studentId as 'Student ID',s.studentFirstName+' '+s.studentLastName as Name,transactionMethod as 'Payment Method',paymentTime as 'Payment Date',totalAmount as 'Amount' FROM Administrator ad inner join Fees f ON ad.administratorId=f.administratorId inner join Students s ON s.studentId=f.studentId where f.totalAmount >= ?";
            String sql7="select ad.administratorId as 'Admin ID',f.studentId as 'Student ID',s.studentFirstName+' '+s.studentLastName as Name,transactionMethod as 'Payment Method',paymentTime as 'Payment Date',totalAmount as 'Amount' FROM Administrator ad inner join Fees f ON ad.administratorId=f.administratorId inner join Students s ON s.studentId=f.studentId where f.totalAmount <= ?";
            String sql8="select ad.administratorId as 'Admin ID',f.studentId as 'Student ID',s.studentFirstName+' '+s.studentLastName as Name,transactionMethod as 'Payment Method',paymentTime as 'Payment Date',totalAmount as 'Amount' FROM Administrator ad inner join Fees f ON ad.administratorId=f.administratorId inner join Students s ON s.studentId=f.studentId where f.totalAmount between ? and ?";
            
            if(s_id.getText().isEmpty()&&name.getText().isEmpty()&&p_method.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()&&a1.getText().isEmpty()&&a2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(a_id.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&name.getText().isEmpty()&&p_method.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()&&a1.getText().isEmpty()&&a2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql2);
                pst.setInt(1, Integer.parseInt(s_id.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&p_method.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()&&a1.getText().isEmpty()&&a2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement("select ad.administratorId as 'Admin ID',f.studentId as 'Student ID',s.studentFirstName+' '+s.studentLastName as Name,transactionMethod as 'Payment Method',paymentTime as 'Payment Date',totalAmount as 'Amount' FROM Administrator ad inner join Fees f ON ad.administratorId=f.administratorId inner join Students s ON s.studentId=f.studentId where s.studentFirstName like '"+name1+"%'");
                //pst.setInt(1, Integer.parseInt(s_id.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&name.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()&&a1.getText().isEmpty()&&a2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement("select ad.administratorId as 'Admin ID',f.studentId as 'Student ID',s.studentFirstName+' '+s.studentLastName as Name,transactionMethod as 'Payment Method',paymentTime as 'Payment Date',totalAmount as 'Amount' FROM Administrator ad inner join Fees f ON ad.administratorId=f.administratorId inner join Students s ON s.studentId=f.studentId where f.transactionMethod like '"+pem+"%'");
                //pst.setInt(1, Integer.parseInt(s_id.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&s_id.getText().isEmpty()&&name.getText().isEmpty()&&p_method.getText().isEmpty()&&d2.getText().isEmpty()&&a1.getText().isEmpty()&&a2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql3);
                pst.setDate(1, Date.valueOf(d1.getText().trim()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&s_id.getText().isEmpty()&&name.getText().isEmpty()&&p_method.getText().isEmpty()&&d1.getText().isEmpty()&&a1.getText().isEmpty()&&a2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql4);
                pst.setDate(1, Date.valueOf(d2.getText().trim()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&s_id.getText().isEmpty()&&name.getText().isEmpty()&&p_method.getText().isEmpty()&&a1.getText().isEmpty()&&a2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql5);
                pst.setDate(1, Date.valueOf(d1.getText().trim()));
                pst.setDate(2, Date.valueOf(d2.getText().trim()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&s_id.getText().isEmpty()&&name.getText().isEmpty()&&p_method.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()&&a2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql6);
                pst.setInt(1, Integer.parseInt(a1.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&s_id.getText().isEmpty()&&name.getText().isEmpty()&&p_method.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()&&a1.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql7);
                pst.setInt(1, Integer.parseInt(a2.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&s_id.getText().isEmpty()&&name.getText().isEmpty()&&p_method.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql8);
                pst.setInt(1, Integer.parseInt(a1.getText()));
                pst.setInt(2, Integer.parseInt(a2.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        a_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        s_id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        p_method = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        d1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        d2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        a1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        a2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fee Information");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Admin ID");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Student ID");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Payment Method");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Payment Date");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("To");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Amount");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("To");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("CLEAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Admin ID", "Student ID", "Name", "Payment Method", "Payment Date", "Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(a_id)
                                    .addComponent(s_id)
                                    .addComponent(name)
                                    .addComponent(p_method, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(a1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                        .addComponent(d1, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(d2, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                        .addComponent(a2)))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(a_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(s_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(p_method, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        disp_fees();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        a_id.setText("");
        s_id.setText("");
        name.setText("");
        p_method.setText("");
        d1.setText("");
        d2.setText("");
        a1.setText("");
        a2.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Fee f=new Fee();
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fee_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fee_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fee_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fee_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fee_search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a1;
    private javax.swing.JTextField a2;
    private javax.swing.JTextField a_id;
    private javax.swing.JTextField d1;
    private javax.swing.JTextField d2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField p_method;
    private javax.swing.JTextField s_id;
    // End of variables declaration//GEN-END:variables
}
