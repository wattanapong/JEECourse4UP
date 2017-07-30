package com.spring.dao;

import java.util.List;

import com.spring.model.Employees;

public interface EmployeesDao {
	public void add(Employees employees);
	public void edit(Employees employees);
	public void delete(int employeesId);
	public Employees getEmployees(int employeesId);
	public List getAllEmployees();
}
