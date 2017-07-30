package spring.demo.service;

import java.util.List;

import spring.demo.model.Amphures;

public interface AmphuresService {
	public void add(Amphures amphures);
	public void edit(Amphures amphures);
	public void delete(int id);
	public Amphures getAmphures(int id);
	public List getAllAmphures();
	public List getAllAmphures(int id);

}
