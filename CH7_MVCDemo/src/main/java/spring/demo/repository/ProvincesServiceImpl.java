package spring.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.demo.dao.ProvincesDao;
import spring.demo.model.Provinces;
import spring.demo.service.ProvincesService;

@Service
public class ProvincesServiceImpl implements ProvincesService {
	@Autowired
	private ProvincesDao provincesDAO;

	@Transactional
	public void add(Provinces provinces) {
		provincesDAO.add(provinces);
	}

	@Transactional
	public void edit(Provinces provinces) {
		provincesDAO.edit(provinces);
	}

	@Transactional
	public void delete(int id) {
		provincesDAO.delete(id);
	}

	@Transactional
	public Provinces getProvinces(int id) {
		return provincesDAO.getProvinces(id);
	}

	@Transactional
	public List getAllProvinces() {
		// TODO Auto-generated method stub
		return provincesDAO.getAllProvinces();
	}
	
	
}
