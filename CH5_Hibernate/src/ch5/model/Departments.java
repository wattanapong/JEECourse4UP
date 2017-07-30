package ch5.model;
// Generated Mar 14, 2016 2:12:22 PM by Hibernate Tools 4.3.1.Final


import java.util.HashSet;
import java.util.Set;

/**
 * Departments generated by hbm2java
 */
public class Departments  implements java.io.Serializable {


     private String deptNo;
     private String deptName;
     private Set deptEmps = new HashSet(0);
     private Set deptManagers = new HashSet(0);

    public Departments() {
    }

	
    public Departments(String deptNo, String deptName) {
        this.deptNo = deptNo;
        this.deptName = deptName;
    }
    public Departments(String deptNo, String deptName, Set deptEmps, Set deptManagers) {
       this.deptNo = deptNo;
       this.deptName = deptName;
       this.deptEmps = deptEmps;
       this.deptManagers = deptManagers;
    }
   
    public String getDeptNo() {
        return this.deptNo;
    }
    
    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }
    public String getDeptName() {
        return this.deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public Set getDeptEmps() {
        return this.deptEmps;
    }
    
    public void setDeptEmps(Set deptEmps) {
        this.deptEmps = deptEmps;
    }
    public Set getDeptManagers() {
        return this.deptManagers;
    }
    
    public void setDeptManagers(Set deptManagers) {
        this.deptManagers = deptManagers;
    }




}


