package spring.demo.dao;

import java.util.List;

import spring.demo.model.Zipcodes;

public interface ZipcodesDao {
	public void add(Zipcodes zipcode);
	public void edit(Zipcodes zipcode);
	public void delete(int id);
	public Zipcodes getZipcodes(int id);
	public List getAllZipcodes();
	
	public Zipcodes getZipcodesBydistrictscode(String code);
}
