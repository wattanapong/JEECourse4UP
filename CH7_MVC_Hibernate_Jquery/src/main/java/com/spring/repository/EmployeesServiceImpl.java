package com.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.EmployeesDao;
import com.spring.model.Employees;
import com.spring.service.EmployeesService;
@Service
public class EmployeesServiceImpl implements EmployeesService {
	@Autowired
	private EmployeesDao employeesDao;
	
	@Transactional
	public void add(Employees employees) {
		employeesDao.add(employees);
	}

	@Transactional
	public void edit(Employees employees) {
		employeesDao.edit(employees);
	}

	@Transactional
	public void delete(int employeesId) {
		employeesDao.delete(employeesId);
	}

	@Transactional
	public Employees getEmployees(int employeesId) {
		return employeesDao.getEmployees(employeesId);
	}

	@Transactional
	public List getAllEmployees() {
		return employeesDao.getAllEmployees();
	}

}
