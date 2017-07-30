package spring.demo.service;

import java.util.List;

import spring.demo.model.Provinces;

public interface ProvincesService {
	public void add(Provinces provinces);
	public void edit(Provinces provinces);
	public void delete(int id);
	public Provinces getProvinces(int id);
	public List getAllProvinces();

}
