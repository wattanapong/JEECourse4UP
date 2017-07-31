package com.jee.ch3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SetEmployees {
	private ArrayList<Employee> emplist = new ArrayList<Employee>();
		public SetEmployees(){

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/employees", "jspuser", "jsp2017");
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM employees LIMIT 0,1000");
				while(rs.next()){
					Employee emp = new Employee();
					emp.setEmp_no( Integer.parseInt( rs.getString("emp_no")) );
					emp.setBirth_date( rs.getString("birth_date"));
					emp.setFirst_name( rs.getString("first_name") );
					emp.setLast_name( rs.getString("last_name") );
					emp.setGender(rs.getString("gender") );
					emp.setHire_date( rs.getString("hire_date") );
					emplist.add(emp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	public ArrayList<Employee> getEmployees(){
		return emplist;
	}
		
}
