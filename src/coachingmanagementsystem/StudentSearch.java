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
public class StudentSearch extends javax.swing.JFrame {

    /**
     * Creates new form StudentSearch
     */
    public StudentSearch() {
        initComponents();
    }
    
    public void disp_info(){
        String name1=f_name.getText();
        String name2=l_name.getText();
        String add=ad.getText();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CoachingManagementSystem;user=sa;password=123456");
            String sql = "select ad.administratorId,sd.instructorId as 'Ins.ID',studentFirstName+' '+studentLastName as Name,administratorFirstName+' '+administratorLastName as 'Ad.By',studentAge as Age,studentAddress as Address,admissionDate as 'Ad.Date' FROM Students sd inner join Administrator ad ON sd.administratorId=ad.administratorId inner join Instructor ins ON ins.instructorId=sd.instructorId where sd.administratorId= ?";
            String sql2 = "select ad.administratorId,sd.instructorId as 'Ins.ID',studentFirstName+' '+studentLastName as Name,administratorFirstName+' '+administratorLastName as 'Ad.By',studentAge as Age,studentAddress as Address,admissionDate as 'Ad.Date' FROM Students sd inner join Administrator ad ON sd.administratorId=ad.administratorId inner join Instructor ins ON ins.instructorId=sd.instructorId where sd.instructorId= ?";
            
            String sql3 = "select ad.administratorId,sd.instructorId as 'Ins.ID',studentFirstName+' '+studentLastName as Name,administratorFirstName+' '+administratorLastName as 'Ad.By',studentAge as Age,studentAddress as Address,admissionDate as 'Ad.Date' FROM Students sd inner join Administrator ad ON sd.administratorId=ad.administratorId inner join Instructor ins ON ins.instructorId=sd.instructorId where sd.studentAge >= ?";
            String sql4 = "select ad.administratorId,sd.instructorId as 'Ins.ID',studentFirstName+' '+studentLastName as Name,administratorFirstName+' '+administratorLastName as 'Ad.By',studentAge as Age,studentAddress as Address,admissionDate as 'Ad.Date' FROM Students sd inner join Administrator ad ON sd.administratorId=ad.administratorId inner join Instructor ins ON ins.instructorId=sd.instructorId where sd.studentAge <= ?";
            String sql5 = "select ad.administratorId,sd.instructorId as 'Ins.ID',studentFirstName+' '+studentLastName as Name,administratorFirstName+' '+administratorLastName as 'Ad.By',studentAge as Age,studentAddress as Address,admissionDate as 'Ad.Date' FROM Students sd inner join Administrator ad ON sd.administratorId=ad.administratorId inner join Instructor ins ON ins.instructorId=sd.instructorId where sd.studentAge between ? and ?";
            String sql6 = "select ad.administratorId,sd.instructorId as 'Ins.ID',studentFirstName+' '+studentLastName as Name,administratorFirstName+' '+administratorLastName as 'Ad.By',studentAge as Age,studentAddress as Address,admissionDate as 'Ad.Date' FROM Students sd inner join Administrator ad ON sd.administratorId=ad.administratorId inner join Instructor ins ON ins.instructorId=sd.instructorId where sd.studentAge = ?";
            String sql7 = "select ad.administratorId,sd.instructorId as 'Ins.ID',studentFirstName+' '+studentLastName as Name,administratorFirstName+' '+administratorLastName as 'Ad.By',studentAge as Age,studentAddress as Address,admissionDate as 'Ad.Date' FROM Students sd inner join Administrator ad ON sd.administratorId=ad.administratorId inner join Instructor ins ON ins.instructorId=sd.instructorId where sd.admissionDate >= ?";
            String sql8 = "select ad.administratorId,sd.instructorId as 'Ins.ID',studentFirstName+' '+studentLastName as Name,administratorFirstName+' '+administratorLastName as 'Ad.By',studentAge as Age,studentAddress as Address,admissionDate as 'Ad.Date' FROM Students sd inner join Administrator ad ON sd.administratorId=ad.administratorId inner join Instructor ins ON ins.instructorId=sd.instructorId where sd.admissionDate <= ?";
            String sql9 = "select ad.administratorId,sd.instructorId as 'Ins.ID',studentFirstName+' '+studentLastName as Name,administratorFirstName+' '+administratorLastName as 'Ad.By',studentAge as Age,studentAddress as Address,admissionDate as 'Ad.Date' FROM Students sd inner join Administrator ad ON sd.administratorId=ad.administratorId inner join Instructor ins ON ins.instructorId=sd.instructorId where sd.admissionDate between ? and ?";
            
            if(i_id.getText().isEmpty()&&f_name.getText().isEmpty()&&l_name.getText().isEmpty()&&age1.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&ad.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(a_id.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&f_name.getText().isEmpty()&&l_name.getText().isEmpty()&&age1.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&ad.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql2);
                pst.setInt(1, Integer.parseInt(i_id.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&i_id.getText().isEmpty()&&l_name.getText().isEmpty()&&age1.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&ad.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement("select ad.administratorId,sd.instructorId as 'Ins.ID',studentFirstName+' '+studentLastName as Name,administratorFirstName+' '+administratorLastName as 'Ad.By',studentAge as Age,studentAddress as Address,admissionDate as 'Ad.Date' FROM Students sd inner join Administrator ad ON sd.administratorId=ad.administratorId inner join Instructor ins ON ins.instructorId=sd.instructorId where sd.studentFirstName like '"+name1+"%'");
                //pst.setString(1, p_method.getText());
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&i_id.getText().isEmpty()&&f_name.getText().isEmpty()&&age1.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&ad.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement("select ad.administratorId,sd.instructorId as 'Ins.ID',studentFirstName+' '+studentLastName as Name,administratorFirstName+' '+administratorLastName as 'Ad.By',studentAge as Age,studentAddress as Address,admissionDate as 'Ad.Date' FROM Students sd inner join Administrator ad ON sd.administratorId=ad.administratorId inner join Instructor ins ON ins.instructorId=sd.instructorId where sd.studentLastName like '"+name2+"%'");
                //pst.setString(1, p_method.getText());
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&i_id.getText().isEmpty()&&f_name.getText().isEmpty()&&l_name.getText().isEmpty()&&age1.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement("select ad.administratorId,sd.instructorId as 'Ins.ID',studentFirstName+' '+studentLastName as Name,administratorFirstName+' '+administratorLastName as 'Ad.By',studentAge as Age,studentAddress as Address,admissionDate as 'Ad.Date' FROM Students sd inner join Administrator ad ON sd.administratorId=ad.administratorId inner join Instructor ins ON ins.instructorId=sd.instructorId where sd.studentAddress like '"+add+"%'");
                //pst.setString(1, p_method.getText());
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&i_id.getText().isEmpty()&&f_name.getText().isEmpty()&&l_name.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql3);
                pst.setInt(1, Integer.parseInt(age1.getText().trim()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&i_id.getText().isEmpty()&&f_name.getText().isEmpty()&&l_name.getText().isEmpty()&&age1.getText().isEmpty()&&age3.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql4);
                pst.setInt(1, Integer.parseInt(age2.getText().trim()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&i_id.getText().isEmpty()&&f_name.getText().isEmpty()&&l_name.getText().isEmpty()&&age3.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql5);
                pst.setInt(1, Integer.parseInt(age1.getText().trim()));
                pst.setInt(2, Integer.parseInt(age2.getText().trim()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&i_id.getText().isEmpty()&&f_name.getText().isEmpty()&&l_name.getText().isEmpty()&&age1.getText().isEmpty()&&age2.getText().isEmpty()&&d1.getText().isEmpty()&&d2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql6);
                pst.setInt(1, Integer.parseInt(age3.getText().trim()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&i_id.getText().isEmpty()&&f_name.getText().isEmpty()&&l_name.getText().isEmpty()&&age1.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&d2.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql7);
                pst.setDate(1, Date.valueOf(d1.getText().trim()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&i_id.getText().isEmpty()&&f_name.getText().isEmpty()&&l_name.getText().isEmpty()&&age1.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&d1.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql8);
                pst.setDate(1, Date.valueOf(d2.getText().trim()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&i_id.getText().isEmpty()&&f_name.getText().isEmpty()&&l_name.getText().isEmpty()&&age1.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql9);
                pst.setDate(1, Date.valueOf(d1.getText().trim()));
                pst.setDate(2, Date.valueOf(d2.getText().trim()));
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
        a_id = new javax.swing.JTextField();
        i_id = new javax.swing.JTextField();
        f_name = new javax.swing.JTextField();
        l_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        age1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        age2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        age3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        d1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        d2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Information");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Age");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Admin Id");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ins. Id");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("To");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Or");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Address");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ad. Date");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("To");

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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ad. ID", "Ins. ID", "Name", "Apt. By", "Age", "Address", "Ad. Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(i_id, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a_id, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(f_name, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(age1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(age2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(age3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(d2)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(207, 207, 207)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(a_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(i_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(f_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(age1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(age2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(age3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        disp_info();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        a_id.setText("");
        i_id.setText("");
        f_name.setText("");
        l_name.setText("");
        age1.setText("");
        age2.setText("");
        age3.setText("");
        ad.setText("");
        d1.setText("");
        d2.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        StudentInfo st=new StudentInfo();
        st.setVisible(true);
        st.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(StudentSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentSearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a_id;
    private javax.swing.JTextField ad;
    private javax.swing.JTextField age1;
    private javax.swing.JTextField age2;
    private javax.swing.JTextField age3;
    private javax.swing.JTextField d1;
    private javax.swing.JTextField d2;
    private javax.swing.JTextField f_name;
    private javax.swing.JTextField i_id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField l_name;
    // End of variables declaration//GEN-END:variables
}
