package jee.ch4;

import java.util.ArrayList;
import java.util.List;

import jee.ch4.model.Employee;

public class Employees {
	public List<Employee> getName(){
		ArrayList<Employee>emp =   new ArrayList<Employee>();
		emp.add(new Employee(1, "³Ñ°ÇØ²Ô"));
		emp.add(new Employee(2, "¸¹¾Å"));
		emp.add(new Employee(3, "¹Ô¾ÔÉ°Ò"));
		emp.add(new Employee(4, "¾Ø·¸Ô¾Ñ·¸ì"));
		return emp ;
	}
}

