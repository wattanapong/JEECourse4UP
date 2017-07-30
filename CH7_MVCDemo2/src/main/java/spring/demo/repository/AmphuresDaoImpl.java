package spring.demo.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.demo.dao.AmphuresDao;
import spring.demo.model.Amphures;

@Repository
public class AmphuresDaoImpl implements AmphuresDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Amphures amphures) {
		session.getCurrentSession().save(amphures);
	}

	@Override
	public void edit(Amphures amphures) {
		session.getCurrentSession().update(amphures);
	}

	@Override
	public void delete(int id) {
		session.getCurrentSession().delete(getAmphures(id));
	}

	@Override
	public Amphures getAmphures(int id) {
		
		return (Amphures) session.getCurrentSession().get(Amphures.class, id);
	}

	@Override
	public List getAllAmphures() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Amphures").list();
	}
	
	@Override
	public List getAllAmphures(int id) {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Amphures where PROVINCE_ID = '"+id+"' ").list();
	}
}
