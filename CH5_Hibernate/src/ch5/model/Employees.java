package ch5.model;
// Generated Mar 14, 2016 2:12:22 PM by Hibernate Tools 4.3.1.Final


import java.util.Date;

/**
 * Employees generated by hbm2java
 */
public class Employees  implements java.io.Serializable {


     private int empNo;
     private String pass;
     private Date birthDate;
     private String firstName;
     private String lastName;
     private String gender;
     private Date hireDate;

    public Employees() {
    }

	
    public Employees(int empNo, String pass) {
        this.empNo = empNo;
        this.pass = pass;
    }
    public Employees(int empNo, String pass, Date birthDate, String firstName, String lastName, String gender, Date hireDate) {
       this.empNo = empNo;
       this.pass = pass;
       this.birthDate = birthDate;
       this.firstName = firstName;
       this.lastName = lastName;
       this.gender = gender;
       this.hireDate = hireDate;
    }
   
    public int getEmpNo() {
        return this.empNo;
    }
    
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    public Date getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getHireDate() {
        return this.hireDate;
    }
    
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }




}


