/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coachingmanagementsystem;

/**
 *
 * @author Tahmid
 */
public class ins_table {
    
    private int a_id;
    private String f_name,l_name,ins_sub,ins_age,ins_gender,ins_address,ins_salary,ins_email,ins_mobile;

    public ins_table(int a_id, String f_name, String l_name, String ins_sub, String ins_age, String ins_gender, String ins_address, String ins_salary, String ins_email, String ins_mobile) {
        this.a_id = a_id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.ins_sub = ins_sub;
        this.ins_age = ins_age;
        this.ins_gender = ins_gender;
        this.ins_address = ins_address;
        this.ins_salary = ins_salary;
        this.ins_email = ins_email;
        this.ins_mobile = ins_mobile;
    }

    public int getA_id() {
        return a_id;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getIns_sub() {
        return ins_sub;
    }

    public String getIns_age() {
        return ins_age;
    }

    public String getIns_gender() {
        return ins_gender;
    }

    public String getIns_address() {
        return ins_address;
    }

    public String getIns_salary() {
        return ins_salary;
    }

    public String getIns_email() {
        return ins_email;
    }

    public String getIns_mobile() {
        return ins_mobile;
    }
              
    
}
