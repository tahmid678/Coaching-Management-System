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
public class salary_search extends javax.swing.JFrame {

    /**
     * Creates new form salary_search
     */
    public salary_search() {
        initComponents();
    }
    
    public void disp_salary(){
        String pem=p_method.getText();
        String name1=a_name.getText();
        String name2=i_name.getText();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CoachingManagementSystem;user=sa;password=123456");
            String sql = "select ad.administratorId,administratorFirstName,sal.instructorId,instructorFirstName,paymentMethod,paymentTime,salaryAmount FROM Administrator ad inner join Salary sal ON ad.administratorId=sal.administratorId inner join Instructor ins ON ins.instructorId=sal.instructorId where sal.administratorId= ?";
            String sql2 = "select ad.administratorId,administratorFirstName,sal.instructorId,instructorFirstName,paymentMethod,paymentTime,salaryAmount FROM Administrator ad inner join Salary sal ON ad.administratorId=sal.administratorId inner join Instructor ins ON ins.instructorId=sal.instructorId where sal.instructorId= ?";
            String sql3 = "select ad.administratorId,administratorFirstName,sal.instructorId,instructorFirstName,paymentMethod,paymentTime,salaryAmount FROM Administrator ad inner join Salary sal ON ad.administratorId=sal.administratorId inner join Instructor ins ON ins.instructorId=sal.instructorId where salaryAmount between ? and ?";
            String sql4 = "select ad.administratorId,administratorFirstName,sal.instructorId,instructorFirstName,paymentMethod,paymentTime,salaryAmount FROM Administrator ad inner join Salary sal ON ad.administratorId=sal.administratorId inner join Instructor ins ON ins.instructorId=sal.instructorId where salaryAmount >= ?";
            String sql5 = "select ad.administratorId,administratorFirstName,sal.instructorId,instructorFirstName,paymentMethod,paymentTime,salaryAmount FROM Administrator ad inner join Salary sal ON ad.administratorId=sal.administratorId inner join Instructor ins ON ins.instructorId=sal.instructorId where salaryAmount <= ?";
            String sql6 = "select ad.administratorId,administratorFirstName,sal.instructorId,instructorFirstName,paymentMethod,paymentTime,salaryAmount FROM Administrator ad inner join Salary sal ON ad.administratorId=sal.administratorId inner join Instructor ins ON ins.instructorId=sal.instructorId where paymentTime >= ?";
            String sql7 = "select ad.administratorId,administratorFirstName,sal.instructorId,instructorFirstName,paymentMethod,paymentTime,salaryAmount FROM Administrator ad inner join Salary sal ON ad.administratorId=sal.administratorId inner join Instructor ins ON ins.instructorId=sal.instructorId where paymentTime <= ?";
            String sql8 = "select ad.administratorId,administratorFirstName,sal.instructorId,instructorFirstName,paymentMethod,paymentTime,salaryAmount FROM Administrator ad inner join Salary sal ON ad.administratorId=sal.administratorId inner join Instructor ins ON ins.instructorId=sal.instructorId where paymentTime  between ? and ?";
            String sql9 = "select ad.administratorId,administratorFirstName,sal.instructorId,instructorFirstName,paymentMethod,paymentTime,salaryAmount FROM Administrator ad inner join Salary sal ON ad.administratorId=sal.administratorId inner join Instructor ins ON ins.instructorId=sal.instructorId where salaryAmount = ?";
            String sql0 = "select ad.administratorId,administratorFirstName,sal.instructorId,instructorFirstName,paymentMethod,paymentTime,salaryAmount FROM Administrator ad inner join Salary sal ON ad.administratorId=sal.administratorId inner join Instructor ins ON ins.instructorId=sal.instructorId where paymentTime = ?";

            if(a_name.getText().isEmpty()&&I_id.getText().isEmpty()&&i_name.getText().isEmpty()&&p_method.getText().isEmpty()&&p_time.getText().isEmpty()&&p_time2.getText().isEmpty()&&p_time3.getText().isEmpty()&&amount1.getText().isEmpty()&&amount2.getText().isEmpty()&&amount3.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(a_id.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&a_name.getText().isEmpty()&&i_name.getText().isEmpty()&&p_method.getText().isEmpty()&&p_time.getText().isEmpty()&&p_time2.getText().isEmpty()&&p_time3.getText().isEmpty()&&amount1.getText().isEmpty()&&amount2.getText().isEmpty()&&amount3.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql2);
                pst.setInt(1, Integer.parseInt(I_id.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&a_name.getText().isEmpty()&&I_id.getText().isEmpty()&&i_name.getText().isEmpty()&&p_method.getText().isEmpty()&&p_time.getText().isEmpty()&&p_time2.getText().isEmpty()&&p_time3.getText().isEmpty()&&amount1.getText().isEmpty()&&amount2.getText().isEmpty()){
              PreparedStatement pst= conn.prepareStatement(sql9);
              pst.setInt(1, Integer.parseInt(amount3.getText().trim()));
              ResultSet rs = pst.executeQuery();
              jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&a_name.getText().isEmpty()&&I_id.getText().isEmpty()&&i_name.getText().isEmpty()&&p_method.getText().isEmpty()&&p_time.getText().isEmpty()&&p_time2.getText().isEmpty()&&p_time3.getText().isEmpty()&&amount2.getText().isEmpty()&&amount3.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql4);
                pst.setInt(1, Integer.parseInt(amount1.getText().trim()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
             else if(a_id.getText().isEmpty()&&a_name.getText().isEmpty()&&I_id.getText().isEmpty()&&i_name.getText().isEmpty()&&p_method.getText().isEmpty()&&p_time.getText().isEmpty()&&p_time2.getText().isEmpty()&&p_time3.getText().isEmpty()&&amount1.getText().isEmpty()&&amount3.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql5);
                pst.setInt(1, Integer.parseInt(amount2.getText().trim()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&a_name.getText().isEmpty()&&I_id.getText().isEmpty()&&i_name.getText().isEmpty()&&p_method.getText().isEmpty()&&p_time.getText().isEmpty()&&p_time2.getText().isEmpty()&&p_time3.getText().isEmpty()&&amount3.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql3);
                pst.setInt(1, Integer.parseInt(amount1.getText()));
                pst.setInt(2, Integer.parseInt(amount2.getText()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
             else if(a_id.getText().isEmpty()&&a_name.getText().isEmpty()&&I_id.getText().isEmpty()&&i_name.getText().isEmpty()&&p_method.getText().isEmpty()&&p_time2.getText().isEmpty()&&p_time3.getText().isEmpty()&&amount1.getText().isEmpty()&&amount2.getText().isEmpty()&&amount3.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql6);
                pst.setDate(1, Date.valueOf(p_time.getText().trim()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&a_name.getText().isEmpty()&&I_id.getText().isEmpty()&&i_name.getText().isEmpty()&&p_method.getText().isEmpty()&&p_time.getText().isEmpty()&&p_time3.getText().isEmpty()&&amount1.getText().isEmpty()&&amount2.getText().isEmpty()&&amount3.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql7);
                pst.setDate(1, Date.valueOf(p_time2.getText().trim()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&a_name.getText().isEmpty()&&I_id.getText().isEmpty()&&i_name.getText().isEmpty()&&p_method.getText().isEmpty()&&p_time.getText().isEmpty()&&p_time2.getText().isEmpty()&&amount1.getText().isEmpty()&&amount2.getText().isEmpty()&&amount3.getText().isEmpty()){
            PreparedStatement pst= conn.prepareStatement(sql0);
            pst.setDate(1, Date.valueOf(p_time3.getText().trim()));
            ResultSet rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&a_name.getText().isEmpty()&&I_id.getText().isEmpty()&&i_name.getText().isEmpty()&&p_method.getText().isEmpty()&&p_time3.getText().isEmpty()&&amount1.getText().isEmpty()&&amount2.getText().isEmpty()&&amount3.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement(sql8);
                pst.setDate(1, Date.valueOf(p_time.getText().trim()));
                pst.setDate(2, Date.valueOf(p_time2.getText().trim()));
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&a_name.getText().isEmpty()&&I_id.getText().isEmpty()&&i_name.getText().isEmpty()&&p_time.getText().isEmpty()&&p_time2.getText().isEmpty()&&p_time3.getText().isEmpty()&&amount1.getText().isEmpty()&&amount2.getText().isEmpty()&&amount3.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement("select ad.administratorId,administratorFirstName,sal.instructorId,instructorFirstName,paymentMethod,paymentTime,salaryAmount FROM Administrator ad inner join Salary sal ON ad.administratorId=sal.administratorId inner join Instructor ins ON ins.instructorId=sal.instructorId where paymentMethod  like '"+pem+"%'");
                //pst.setString(1, p_method.getText());
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&I_id.getText().isEmpty()&&i_name.getText().isEmpty()&&p_method.getText().isEmpty()&&p_time.getText().isEmpty()&&p_time2.getText().isEmpty()&&p_time3.getText().isEmpty()&&amount1.getText().isEmpty()&&amount2.getText().isEmpty()&&amount3.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement("select ad.administratorId,administratorFirstName,sal.instructorId,instructorFirstName,paymentMethod,paymentTime,salaryAmount FROM Administrator ad inner join Salary sal ON ad.administratorId=sal.administratorId inner join Instructor ins ON ins.instructorId=sal.instructorId where administratorFirstName  like '"+name1+"%'");
                //pst.setString(1, p_method.getText());
                ResultSet rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if(a_id.getText().isEmpty()&&a_name.getText().isEmpty()&&I_id.getText().isEmpty()&&p_method.getText().isEmpty()&&p_time.getText().isEmpty()&&p_time2.getText().isEmpty()&&p_time3.getText().isEmpty()&&amount1.getText().isEmpty()&&amount2.getText().isEmpty()&&amount3.getText().isEmpty()){
                PreparedStatement pst= conn.prepareStatement("select ad.administratorId,administratorFirstName,sal.instructorId,instructorFirstName,paymentMethod,paymentTime,salaryAmount FROM Administrator ad inner join Salary sal ON ad.administratorId=sal.administratorId inner join Instructor ins ON ins.instructorId=sal.instructorId where instructorFirstName  like '"+name2+"%'");
                //pst.setString(1, p_method.getText());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        a_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        a_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        I_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        i_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        p_method = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        p_time = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        p_time2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        amount1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        amount2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        p_time3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        amount3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Admin Id", "Admin Name", "Instructor Id", "Instructor Name", "Payment Method", "Payment Time", "Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Salary Information");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Admin Id");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Admin Name");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Instructor Id");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Instructor Name");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Payment Method");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Payment Time");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("To");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Amount");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("To");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Or");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Or");

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("CLEAR");
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
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(i_name, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(p_method, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(amount1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                                .addComponent(p_time, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(p_time2)
                                                .addComponent(amount2)))
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(p_time3)
                                    .addComponent(amount3, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(a_id, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(I_id, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(a_name, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a_id, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a_name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(I_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(i_name)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(p_method, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(p_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(amount2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(amount3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(amount1)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(p_time2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(p_time3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        disp_salary();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        a_id.setText("");
        a_name.setText("");
        I_id.setText("");
        i_name.setText("");
        p_method.setText("");
        p_time.setText("");
        p_time2.setText("");
        p_time3.setText("");
        amount1.setText("");
        amount2.setText("");
        amount3.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Salary sal=new Salary();
        sal.setVisible(true);
        sal.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(salary_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(salary_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(salary_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(salary_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new salary_search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField I_id;
    private javax.swing.JTextField a_id;
    private javax.swing.JTextField a_name;
    private javax.swing.JTextField amount1;
    private javax.swing.JTextField amount2;
    private javax.swing.JTextField amount3;
    private javax.swing.JTextField i_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField p_method;
    private javax.swing.JTextField p_time;
    private javax.swing.JTextField p_time2;
    private javax.swing.JTextField p_time3;
    // End of variables declaration//GEN-END:variables
}
