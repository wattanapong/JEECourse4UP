package spring.demo.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.demo.dao.ProvincesDao;
import spring.demo.model.Provinces;

@Repository
public class ProvincesDaoImpl implements ProvincesDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Provinces provinces) {
		session.getCurrentSession().save(provinces);
	}

	@Override
	public void edit(Provinces provinces) {
		session.getCurrentSession().update(provinces);
	}

	@Override
	public void delete(int id) {
		session.getCurrentSession().delete(getProvinces(id));
	}

	@Override
	public Provinces getProvinces(int id) {
		
		return (Provinces) session.getCurrentSession().get(Provinces.class, id);
	}

	@Override
	public List getAllProvinces() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Provinces").list();
	}
}
