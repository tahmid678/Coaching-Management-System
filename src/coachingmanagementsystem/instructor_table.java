/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coachingmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tahmid
 */
public class instructor_table extends javax.swing.JFrame {

    /**
     * Creates new form instructor_table
     */
    public instructor_table() {
        initComponents();
    }
    
    public ArrayList<ins_table> instructorList(){
        ArrayList<ins_table> ins_list = new ArrayList();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=CoachingManagementSystem;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query1="SELECT * FROM Instructor";
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(query1);
            
            while(rs.next()){
                ins_table user = new ins_table(rs.getInt("administratorId"),rs.getString("instructorFirstName"),rs.getString("instructorLastName"),rs.getString("instructorSubject"),rs.getString("instructorAge"),rs.getString("instructorGender"),rs.getString("instructorAddress"),rs.getString("instructorSalary"),rs.getString("instructorEmail"),rs.getString("instructorMobile"));
                ins_list.add(user);
            }
         }
         catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
         return ins_list;
    }
    
    public void show_instructor(){
        ArrayList<ins_table> list = instructorList();
        DefaultTableModel model = (DefaultTableModel)ins_jTable.getModel();
        Object[] row = new Object[10];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getA_id();
            row[1]=list.get(i).getF_name();
            row[2]=list.get(i).getL_name();
            row[3]=list.get(i).getIns_sub();
            row[4]=list.get(i).getIns_age();
            row[5]=list.get(i).getIns_gender();
            row[6]=list.get(i).getIns_address();
            row[7]=list.get(i).getIns_salary();
            row[8]=list.get(i).getIns_email();
            row[9]=list.get(i).getIns_mobile();
            model.addRow(row);
        }
    }
    
    

    public Connection connection;
            
    public void connectDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=CoachingManagementSystem;selectMethod=cursor", "sa", "123456");

        

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT instructorFirstName FROM Instructor");
            
            
            while (resultSet.next()) {
                
                System.out.println("Instructor NAME:" + 
                        resultSet.getString("instructorFirstName"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ins_jTable = new javax.swing.JTable();
        show_ins_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ins_jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admin Id", "First Name", "Last Name", "Subject", "Age", "Gender", "Address", "Salary", "Email", "Mobile"
            }
        ));
        jScrollPane1.setViewportView(ins_jTable);

        show_ins_btn.setText("Show ");
        show_ins_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_ins_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Instructor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(show_ins_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(103, 103, 103)
                .addComponent(show_ins_btn)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void show_ins_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_ins_btnActionPerformed
        // TODO add your handling code here:
            DefaultTableModel model = (DefaultTableModel)ins_jTable.getModel();
            model.setRowCount(0);
            show_instructor();
    }//GEN-LAST:event_show_ins_btnActionPerformed

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
            java.util.logging.Logger.getLogger(instructor_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(instructor_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(instructor_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(instructor_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new instructor_table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ins_jTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton show_ins_btn;
    // End of variables declaration//GEN-END:variables
}
