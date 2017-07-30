package spring.demo.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.demo.dao.ZipcodesDao;
import spring.demo.model.Zipcodes;

@Repository
public class ZipcodesDaoImpl implements ZipcodesDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Zipcodes zipcode) {
		session.getCurrentSession().save(zipcode);
	}

	@Override
	public void edit(Zipcodes zipcode) {
		session.getCurrentSession().update(zipcode);
	}

	@Override
	public void delete(int id) {
		session.getCurrentSession().delete(getZipcodes(id));
	}

	@Override
	public Zipcodes getZipcodes(int id) {
		
		return (Zipcodes) session.getCurrentSession().get(Zipcodes.class, id);
	}

	@Override
	public List getAllZipcodes() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Zipcodes").list();
	}
}
