package com.jee.ch3;
import java.util.ArrayList;

public class SetEmployees {
	private ArrayList<Employee> emplist = new ArrayList<Employee>();
		public SetEmployees(){
			
			
			Employee emp = new Employee();
			emp.setEmp_no(1);
			emp.setFirst_name("�ѹ��ҹ��");
			emp.setLast_name("������ѧ�����");
			emplist.add(emp);
			
			emp = new Employee();
			emp.setEmp_no(2);
			emp.setFirst_name("�Ⱦ� ");
			emp.setLast_name("ǧ����");
			emplist.add(emp);
			
			emp = new Employee();
			emp.setEmp_no(4);
			emp.setFirst_name("¸���");
			emp.setLast_name("�آ���");
			emplist.add(emp);
			
			emp = new Employee();
			emp.setEmp_no(3);
			emp.setFirst_name("Ǿط�Ծѷ�� ");
			emp.setLast_name("������");
			emplist.add(emp);
			
			for (Employee employee : emplist) {
				
			}
		}
	public ArrayList<Employee> getEmployees(){
		return emplist;
	}
		
}
