package spring.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.demo.dao.DistrictsDao;
import spring.demo.model.Districts;
import spring.demo.service.DistrictsService;

@Service
public class DistrictsServiceImpl implements DistrictsService {
	@Autowired
	private DistrictsDao districtsDAO;

	@Transactional
	public void add(Districts districts) {
		districtsDAO.add(districts);
	}

	@Transactional
	public void edit(Districts districts) {
		districtsDAO.edit(districts);
	}

	@Transactional
	public void delete(int id) {
		districtsDAO.delete(id);
	}

	@Transactional
	public Districts getDistricts(int id) {
		return districtsDAO.getDistricts(id);
	}

	@Transactional
	public List getAllDistricts() {
		// TODO Auto-generated method stub
		return districtsDAO.getAllDistricts();
	}
	
	@Transactional
	public List getAllDistricts(int id) {
		return districtsDAO.getAllDistricts(id);
	}
	
	@Transactional
	public Districts getDistrictsByCode(String code) {
		// TODO Auto-generated method stub
		return districtsDAO.getDistrictsByCode(code);
	}

	@Transactional
	public Districts getDistrictsByName(String name) {
		// TODO Auto-generated method stub
		return districtsDAO.getDistrictsByName(name);
	}

	@Transactional
	public Districts getDistrictsByAmphureId(int id) {
		// TODO Auto-generated method stub
		return districtsDAO.getDistrictsByAmphureId(id);
	}
	
	@Transactional
	public Districts getDistrictsByAttributes(List<Map<String, String>> attributes) {
		return districtsDAO.getDistrictsByAttributes(attributes);
	}

	@Transactional
	public List getDistrictsAllByAttributes(List<Map<String, String>> attributes) {
		return districtsDAO.getDistrictsAllByAttributes(attributes);
	}


	
	
}
