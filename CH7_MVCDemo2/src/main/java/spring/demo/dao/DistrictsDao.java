package spring.demo.dao;

import java.util.List;
import java.util.Map;

import spring.demo.model.Districts;

public interface DistrictsDao {
	public void add(Districts districts);
	public void edit(Districts districts);
	public void delete(int id);
	public Districts getDistricts(int id);
	public List getAllDistricts();
	public Districts getDistrictsByCode(String code);
	public Districts getDistrictsByName(String name);
	public Districts getDistrictsByAmphureId(int id);
	
	public Districts getDistrictsByAttributes(List<Map<String, String>> attributes);
	public List getDistrictsAllByAttributes(List<Map<String, String>>attributes);
	List getAllDistricts(int id);
	

}
