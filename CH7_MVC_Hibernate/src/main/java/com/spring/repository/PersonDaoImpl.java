package com.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.PersonDao;
import com.spring.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Person person) {
		session.getCurrentSession().save(person);
	}

	@Override
	public void edit(Person person) {
		session.getCurrentSession().update(person);
	}

	@Override
	public void delete(int personId) {		
		session.getCurrentSession().delete(getPerson(personId));
	}

	@Override
	public Person getPerson(int personId) {
		return (Person)session.getCurrentSession().get(Person.class, personId);
	}

	@Override
	public List getAllPerson() {
		return session.getCurrentSession().createQuery("from Person").list();
	}

}
