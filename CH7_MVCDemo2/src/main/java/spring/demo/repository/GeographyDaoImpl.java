package spring.demo.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.demo.dao.GeographyDao;
import spring.demo.model.Geography;

@Repository
public class GeographyDaoImpl implements GeographyDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Geography geography) {
		session.getCurrentSession().save(geography);
	}

	@Override
	public void edit(Geography geography) {
		session.getCurrentSession().update(geography);
	}

	@Override
	public void delete(int id) {
		session.getCurrentSession().delete(getGeography(id));
	}

	@Override
	public Geography getGeography(int id) {
		
		return (Geography) session.getCurrentSession().get(Geography.class, id);
	}

	@Override
	public List getAllGeography() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Geography").list();
	}
}
