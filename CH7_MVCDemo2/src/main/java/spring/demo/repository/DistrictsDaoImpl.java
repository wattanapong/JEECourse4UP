package spring.demo.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.demo.dao.DistrictsDao;
import spring.demo.model.Districts;

@Repository
public class DistrictsDaoImpl implements DistrictsDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Districts districts) {
		session.getCurrentSession().save(districts);
	}

	@Override
	public void edit(Districts districts) {
		session.getCurrentSession().update(districts);
	}

	@Override
	public void delete(int id) {
		session.getCurrentSession().delete(getDistricts(id));
	}

	@Override
	public Districts getDistricts(int id) {
		
		return (Districts) session.getCurrentSession().get(Districts.class, id);
	}

	@Override
	public List getAllDistricts() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Districts").list();
	}
	
	@Override
	public List getAllDistricts(int id) {
		return session.getCurrentSession().createQuery("from Districts where AMPHUR_ID = '"+id+"' ").list();
	}
	
	@Override
	public Districts getDistrictsByCode(String code) {
		Query query = session.getCurrentSession().createQuery("from Districts D where D.districtCode = '"+code+"' ");
        query.setMaxResults(1);
        return (Districts)query.uniqueResult();
	}

	@Override
	public Districts getDistrictsByName(String name) {
		return  (Districts) session.getCurrentSession().createQuery("from Districts D where D.districtName = '"+name+"' ").uniqueResult();
	}

	@Override
	public Districts getDistrictsByAmphureId(int id) {
		return  (Districts) session.getCurrentSession().createQuery("from Districts D where D.amphures = "+id).uniqueResult();
	}
	

	@Override
	public Districts getDistrictsByAttributes(List<Map<String, String>> attributes) {
		String criteria = getDistrictCriteria(attributes);
		return (Districts) session.getCurrentSession().createQuery("from Districts D WHERE "+criteria ).uniqueResult();
	}

	@Override
	public List getDistrictsAllByAttributes(List<Map<String, String>> attributes) {
		String criteria = getDistrictCriteria(attributes);
		return session.getCurrentSession().createQuery("from Districts D WHERE "+criteria ).list();
	}
	
	private String getDistrictCriteria(List<Map<String, String>> attributes) {
		String criteria = "";
		for (Map<String, String> map : attributes) {
			for (String key : map.keySet()) {
				if (criteria != "" ) criteria += " AND ";
				criteria += key + " = '"+ map.get(key)+"' ";
			}
		}
		
		return criteria;
	}

	

}
