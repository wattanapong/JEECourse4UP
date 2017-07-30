package com.spring.dao;

import java.util.List;

import com.spring.model.Person;

public interface PersonDao {
	public void add(Person person);
	public void edit(Person person);
	public void delete(int personId);
	public Person getPerson(int personId);
	public List getAllPerson();
}
