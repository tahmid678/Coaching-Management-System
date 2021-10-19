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
public class instructor_search extends javax.swing.JFrame {

    /**
     * Creates new form instructor_search
     */
    public instructor_search() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void displayIns(){
        String na=name.getText();
        String na2=apt_by.getText();
        String gen=gender.getText();
        String s=sub.getText();
        String adr=add.getText();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CoachingManagementSystem;user=sa;password=123456");
            String sql="select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where ins.instructorId = ?";
            String sql2="select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where ins.instructorAge >= ?";
            String sql3="select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where ins.instructorAge <= ?";
            String sql4="select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where ins.instructorAge = ?";
            String sql5="select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where ins.instructorAge between ? and ?";
            String sql6="select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where ins.instructorSalary >= ?";
            String sql7="select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where ins.instructorSalary <= ?";
            String sql8="select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where ins.instructorSalary = ?";
            String sql9="select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where ins.joiningDate >= ?";
            String sql10="select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where ins.joiningDate <= ?";
            String sql11="select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where ins.joiningDate between ? and ?";
            
            if(name.getText().isEmpty()&&apt_by.getText().isEmpty()&&sub.getText().isEmpty()&&age.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&gender.getText().isEmpty()&&add.getText().isEmpty()&&sal1.getText().isEmpty()&&sal2.getText().isEmpty()&&sal3.getText().isEmpty()&&date1.getText().isEmpty()&&date2.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(ins_id.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(ins_id.getText().isEmpty()&&name.getText().isEmpty()&&apt_by.getText().isEmpty()&&sub.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&gender.getText().isEmpty()&&add.getText().isEmpty()&&sal1.getText().isEmpty()&&sal2.getText().isEmpty()&&sal3.getText().isEmpty()&&date1.getText().isEmpty()&&date2.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement(sql2);
                pst.setInt(1, Integer.parseInt(age.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(ins_id.getText().isEmpty()&&name.getText().isEmpty()&&apt_by.getText().isEmpty()&&sub.getText().isEmpty()&&age.getText().isEmpty()&&age3.getText().isEmpty()&&gender.getText().isEmpty()&&add.getText().isEmpty()&&sal1.getText().isEmpty()&&sal2.getText().isEmpty()&&sal3.getText().isEmpty()&&date1.getText().isEmpty()&&date2.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement(sql3);
                pst.setInt(1, Integer.parseInt(age2.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(ins_id.getText().isEmpty()&&name.getText().isEmpty()&&apt_by.getText().isEmpty()&&sub.getText().isEmpty()&&age.getText().isEmpty()&&age2.getText().isEmpty()&&gender.getText().isEmpty()&&add.getText().isEmpty()&&sal1.getText().isEmpty()&&sal2.getText().isEmpty()&&sal3.getText().isEmpty()&&date1.getText().isEmpty()&&date2.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement(sql4);
                pst.setInt(1, Integer.parseInt(age3.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(ins_id.getText().isEmpty()&&name.getText().isEmpty()&&apt_by.getText().isEmpty()&&sub.getText().isEmpty()&&age3.getText().isEmpty()&&gender.getText().isEmpty()&&add.getText().isEmpty()&&sal1.getText().isEmpty()&&sal2.getText().isEmpty()&&sal3.getText().isEmpty()&&date1.getText().isEmpty()&&date2.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement(sql5);
                pst.setInt(1, Integer.parseInt(age.getText()));
                pst.setInt(2, Integer.parseInt(age2.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(ins_id.getText().isEmpty()&&name.getText().isEmpty()&&apt_by.getText().isEmpty()&&sub.getText().isEmpty()&&age.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&gender.getText().isEmpty()&&add.getText().isEmpty()&&sal2.getText().isEmpty()&&sal3.getText().isEmpty()&&date1.getText().isEmpty()&&date2.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement(sql6);
                pst.setInt(1, Integer.parseInt(sal1.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(ins_id.getText().isEmpty()&&name.getText().isEmpty()&&apt_by.getText().isEmpty()&&sub.getText().isEmpty()&&age.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&gender.getText().isEmpty()&&add.getText().isEmpty()&&sal1.getText().isEmpty()&&sal3.getText().isEmpty()&&date1.getText().isEmpty()&&date2.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement(sql7);
                pst.setInt(1, Integer.parseInt(sal2.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(ins_id.getText().isEmpty()&&name.getText().isEmpty()&&apt_by.getText().isEmpty()&&sub.getText().isEmpty()&&age.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&gender.getText().isEmpty()&&add.getText().isEmpty()&&sal1.getText().isEmpty()&&sal2.getText().isEmpty()&&date1.getText().isEmpty()&&date2.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement(sql8);
                pst.setInt(1, Integer.parseInt(sal3.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(ins_id.getText().isEmpty()&&name.getText().isEmpty()&&apt_by.getText().isEmpty()&&sub.getText().isEmpty()&&age.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&gender.getText().isEmpty()&&add.getText().isEmpty()&&sal1.getText().isEmpty()&&sal2.getText().isEmpty()&&sal3.getText().isEmpty()&&date2.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement(sql9);
                pst.setDate(1, Date.valueOf(date1.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(ins_id.getText().isEmpty()&&name.getText().isEmpty()&&apt_by.getText().isEmpty()&&sub.getText().isEmpty()&&age.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&gender.getText().isEmpty()&&add.getText().isEmpty()&&sal1.getText().isEmpty()&&sal2.getText().isEmpty()&&sal3.getText().isEmpty()&&date1.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement(sql10);
                pst.setDate(1, Date.valueOf(date2.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(ins_id.getText().isEmpty()&&name.getText().isEmpty()&&apt_by.getText().isEmpty()&&sub.getText().isEmpty()&&age.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&gender.getText().isEmpty()&&add.getText().isEmpty()&&sal1.getText().isEmpty()&&sal2.getText().isEmpty()&&sal3.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement(sql11);
                pst.setDate(1, Date.valueOf(date1.getText()));
                pst.setDate(2, Date.valueOf(date2.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if(ins_id.getText().isEmpty()&&apt_by.getText().isEmpty()&&sub.getText().isEmpty()&&age.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&gender.getText().isEmpty()&&add.getText().isEmpty()&&sal1.getText().isEmpty()&&sal2.getText().isEmpty()&&sal3.getText().isEmpty()&&date1.getText().isEmpty()&&date2.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement("select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where instructorFirstName like '"+na+"%'");
                //pst.setInt(1, Integer.parseInt(ins_id.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if(ins_id.getText().isEmpty()&&name.getText().isEmpty()&&sub.getText().isEmpty()&&age.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&gender.getText().isEmpty()&&add.getText().isEmpty()&&sal1.getText().isEmpty()&&sal2.getText().isEmpty()&&sal3.getText().isEmpty()&&date1.getText().isEmpty()&&date2.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement("select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where administratorFirstName like '"+na2+"%'");
                //pst.setInt(1, Integer.parseInt(ins_id.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if(ins_id.getText().isEmpty()&&name.getText().isEmpty()&&apt_by.getText().isEmpty()&&age.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&gender.getText().isEmpty()&&add.getText().isEmpty()&&sal1.getText().isEmpty()&&sal2.getText().isEmpty()&&sal3.getText().isEmpty()&&date1.getText().isEmpty()&&date2.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement("select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where instructorSubject like '"+s+"%'");
                //pst.setInt(1, Integer.parseInt(ins_id.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if(ins_id.getText().isEmpty()&&name.getText().isEmpty()&&sub.getText().isEmpty()&&age.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&add.getText().isEmpty()&&sal1.getText().isEmpty()&&sal2.getText().isEmpty()&&sal3.getText().isEmpty()&&date1.getText().isEmpty()&&date2.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement("select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where instructorGender like '"+gen+"%'");
                //pst.setInt(1, Integer.parseInt(ins_id.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if(ins_id.getText().isEmpty()&&name.getText().isEmpty()&&apt_by.getText().isEmpty()&&sub.getText().isEmpty()&&age.getText().isEmpty()&&age2.getText().isEmpty()&&age3.getText().isEmpty()&&gender.getText().isEmpty()&&sal1.getText().isEmpty()&&sal2.getText().isEmpty()&&sal3.getText().isEmpty()&&date1.getText().isEmpty()&&date2.getText().isEmpty()){
                
                PreparedStatement pst= conn.prepareStatement("select instructorId as 'Ins ID',instructorFirstName+' '+instructorLastName as Name,administratorFirstName+' '+administratorLastName as 'Appointed By',instructorSubject as Subject,instructorAge as Age,instructorGender as Gender,instructorAddress as Address,instructorSalary as Salary,instructorEmail as Email,instructorMobile as Contact,joiningDate as 'Jn.Date' FROM Administrator ad inner join Instructor ins ON ad.administratorId=ins.administratorId where instructorAddress like '"+adr+"%'");
                //pst.setInt(1, Integer.parseInt(ins_id.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            //else{
                //JOptionPane.showMessageDialog(null, "Records do not exist");
           // }
            
            
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        ins_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        apt_by = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sub = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        gender = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        add = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        sal1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        sal2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        sal3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        date1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        date2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        age2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        age3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Instructor");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ins ID", "Name", "Appointed By", "Subject", "Age", "Gender", "Address", "Salary", "Email", "Mobile", "Jn. Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ins ID");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Apt. By");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Subject");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Age");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Gender");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Address");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Salary");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("To");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Or");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Jn.Date");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("To");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("To");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Or");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel5)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel4))
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel9))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel12))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel6)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ins_id)
                                    .addComponent(name)
                                    .addComponent(apt_by)
                                    .addComponent(sub)
                                    .addComponent(gender)
                                    .addComponent(add)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(date1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sal1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sal2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sal3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(age2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(age3)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(86, 86, 86)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1074, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ins_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(apt_by, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(age2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(age3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(sal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(sal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(sal3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ins_id.setText("");
        name.setText("");
        apt_by.setText("");
        sub.setText("");
        age.setText("");
        age2.setText("");
        age3.setText("");
        gender.setText("");
        add.setText("");
        sal1.setText("");
        sal2.setText("");
        sal3.setText("");
        date1.setText("");
        date2.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        displayIns();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        instructor_info inf=new instructor_info();
        inf.setVisible(true);
        inf.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(instructor_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(instructor_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(instructor_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(instructor_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new instructor_search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField add;
    private javax.swing.JTextField age;
    private javax.swing.JTextField age2;
    private javax.swing.JTextField age3;
    private javax.swing.JTextField apt_by;
    private javax.swing.JTextField date1;
    private javax.swing.JTextField date2;
    private javax.swing.JTextField gender;
    private javax.swing.JTextField ins_id;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField sal1;
    private javax.swing.JTextField sal2;
    private javax.swing.JTextField sal3;
    private javax.swing.JTextField sub;
    // End of variables declaration//GEN-END:variables
}
