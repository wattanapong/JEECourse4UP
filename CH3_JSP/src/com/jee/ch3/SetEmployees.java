package com.jee.ch3;
import java.util.ArrayList;

public class SetEmployees {
	private ArrayList<Employee> emplist = new ArrayList<Employee>();
		public SetEmployees(){
			
			
			Employee emp = new Employee();
			emp.setEmp_no(1);
			emp.setFirst_name("พันธกานต์");
			emp.setLast_name("ต๊ะลิสังวาลย์");
			emplist.add(emp);
			
			emp = new Employee();
			emp.setEmp_no(2);
			emp.setFirst_name("ทศพล ");
			emp.setLast_name("วงศ์วี");
			emplist.add(emp);
			
			emp = new Employee();
			emp.setEmp_no(4);
			emp.setFirst_name("ยธนพล");
			emp.setLast_name("สุขแจ่ม");
			emplist.add(emp);
			
			emp = new Employee();
			emp.setEmp_no(3);
			emp.setFirst_name("วพุทธิพัทธ์ ");
			emp.setLast_name("มีอ่วม");
			emplist.add(emp);
			
			for (Employee employee : emplist) {
				
			}
		}
	public ArrayList<Employee> getEmployees(){
		return emplist;
	}
		
}
