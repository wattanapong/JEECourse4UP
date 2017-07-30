package spring.demo.dao;

import java.util.List;

import spring.demo.model.Provinces;

public interface ProvincesDao {
	public void add(Provinces provinces);
	public void edit(Provinces provinces);
	public void delete(int id);
	public Provinces getProvinces(int id);
	public List getAllProvinces();

}
