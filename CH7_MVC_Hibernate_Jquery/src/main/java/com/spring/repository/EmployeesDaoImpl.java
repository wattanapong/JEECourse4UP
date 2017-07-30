package com.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.EmployeesDao;
import com.spring.model.Employees;

@Repository
public class EmployeesDaoImpl implements EmployeesDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Employees employees) {
		session.getCurrentSession().save(employees);
	}

	@Override
	public void edit(Employees employees) {
		session.getCurrentSession().update(employees);
	}

	@Override
	public void delete(int employeesId) {		
		session.getCurrentSession().delete(getEmployees(employeesId));
	}

	@Override
	public Employees getEmployees(int employeesId) {
		return (Employees)session.getCurrentSession().get(Employees.class, employeesId);
	}

	@Override
	public List getAllEmployees() {
		return session.getCurrentSession().createQuery("from Employees").list();
	}

}
