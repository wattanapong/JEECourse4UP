package spring.demo.service;

import java.util.List;

import spring.demo.model.Geography;

public interface GeographyService {
	public void add(Geography geography);
	public void edit(Geography geography);
	public void delete(int id);
	public Geography getGeography(int id);
	public List getAllGeography();

}
