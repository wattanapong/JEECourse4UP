package spring.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.demo.dao.GeographyDao;
import spring.demo.model.Geography;
import spring.demo.service.GeographyService;

@Service
public class GeographyServiceImpl implements GeographyService {
	@Autowired
	private GeographyDao geographyDAO;

	@Transactional
	public void add(Geography geography) {
		geographyDAO.add(geography);
	}

	@Transactional
	public void edit(Geography geography) {
		geographyDAO.edit(geography);
	}

	@Transactional
	public void delete(int id) {
		geographyDAO.delete(id);
	}

	@Transactional
	public Geography getGeography(int id) {
		return geographyDAO.getGeography(id);
	}

	@Transactional
	public List getAllGeography() {
		// TODO Auto-generated method stub
		return geographyDAO.getAllGeography();
	}
	
	
}
