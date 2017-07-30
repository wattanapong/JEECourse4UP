package com.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.Employees;
import com.spring.service.EmployeesService;
 
@Controller
public class EmployeesController {
 
	@Autowired
	private EmployeesService employeesService;
 
	@RequestMapping("/Employees")
	public String setupForm(Map<String, Object> map){
		Employees employees = new Employees();
		map.put("employees", employees);
		map.put("employeesList", employeesService.getAllEmployees());
		//return "redirect:/edit/employees/index";
		return "employees";
	}
	
	@RequestMapping(value="/Employees.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Employees employees, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Employees employeesResult = new Employees();
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			employeesService.add(employees);
			employeesResult = employees;
			break;
		case "edit":
			employeesService.edit(employees);
			employeesResult = employees;
			break;
		case "delete":
			employeesService.delete(employees.getEmpNo());
			employeesResult = new Employees();
			break;
		case "search":
			Employees searchedEmployees = employeesService.getEmployees(employees.getEmpNo());
			employeesResult = searchedEmployees!=null ? searchedEmployees : new Employees();
			break;
		}
		map.put("employees", employeesResult);
		map.put("employeesList", employeesService.getAllEmployees());
		return "employees";
	}
	
	
}