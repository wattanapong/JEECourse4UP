package com.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.PersonDao;
import com.spring.model.Person;
import com.spring.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;
	
	@Transactional
	public void add(Person person) {
		personDao.add(person);
	}

	@Transactional
	public void edit(Person person) {
		personDao.edit(person);
	}

	@Transactional
	public void delete(int personId) {
		personDao.delete(personId);
	}

	@Transactional
	public Person getPerson(int personId) {
		return personDao.getPerson(personId);
	}

	@Transactional
	public List getAllPerson() {
		return personDao.getAllPerson();
	}

}
