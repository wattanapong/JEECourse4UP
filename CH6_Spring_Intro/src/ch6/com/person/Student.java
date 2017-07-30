package ch6.com.person;

import ch6.person.*;

public class Student implements Person {
	private String fname;
	private String lname;

	public Student(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}

	@Override
	public void setFname(String fname) {
		this.fname = fname;
	}

	@Override
	public String getFname() {
		return this.fname;
	}


	@Override
	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String getLname() {
		return this.lname;
	}

	@Override
	public String getType() {
		return "Student";
	}
	

}
