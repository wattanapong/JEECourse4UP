package jee.ch4;

import java.util.ArrayList;
import java.util.List;

import jee.ch4.model.Employee;

public class Employees {
	public List<Employee> getName(){
		ArrayList<Employee>emp =   new ArrayList<Employee>();
		emp.add(new Employee(1, "�Ѱ�ز�"));
		emp.add(new Employee(2, "����"));
		emp.add(new Employee(3, "�Ծ�ɰ�"));
		emp.add(new Employee(4, "�ط�Ծѷ��"));
		return emp ;
	}
}

