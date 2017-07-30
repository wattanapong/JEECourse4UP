package spring.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.demo.dao.AmphuresDao;
import spring.demo.model.Amphures;
import spring.demo.service.AmphuresService;

@Service
public class AmphuresServiceImpl implements AmphuresService {
	@Autowired
	private AmphuresDao amphuresDAO;

	@Transactional
	public void add(Amphures amphures) {
		amphuresDAO.add(amphures);
	}

	@Transactional
	public void edit(Amphures amphures) {
		amphuresDAO.edit(amphures);
	}

	@Transactional
	public void delete(int id) {
		amphuresDAO.delete(id);
	}

	@Transactional
	public Amphures getAmphures(int id) {
		return amphuresDAO.getAmphures(id);
	}

	@Transactional
	public List getAllAmphures() {
		// TODO Auto-generated method stub
		return amphuresDAO.getAllAmphures();
	}
	
	@Transactional
	public List getAllAmphures(int id) {
		return amphuresDAO.getAllAmphures(id);
	}
	
	
}
