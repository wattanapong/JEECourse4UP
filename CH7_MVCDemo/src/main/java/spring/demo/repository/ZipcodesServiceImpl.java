package spring.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.demo.dao.ZipcodesDao;
import spring.demo.model.Zipcodes;
import spring.demo.service.ZipcodesService;

@Service
public class ZipcodesServiceImpl implements ZipcodesService {
	@Autowired
	private ZipcodesDao zipcodeDAO;

	@Transactional
	public void add(Zipcodes zipcode) {
		zipcodeDAO.add(zipcode);
	}

	@Transactional
	public void edit(Zipcodes zipcode) {
		zipcodeDAO.edit(zipcode);
	}

	@Transactional
	public void delete(int id) {
		zipcodeDAO.delete(id);
	}

	@Transactional
	public Zipcodes getZipcodes(int id) {
		return zipcodeDAO.getZipcodes(id);
	}

	@Transactional
	public List getAllZipcodes() {
		// TODO Auto-generated method stub
		return zipcodeDAO.getAllZipcodes();
	}
	
	
}
