package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	// for autonumber
	private int studentId;

	@Column
	private String login;

	@Column
	private String password;

	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private int yearLevel;

	public Student() {
	}

	public Student(int studentId,String login,String password, String firstname, String lastname, int yearLevel) {
		super();
		this.studentId = studentId;
		this.login = login;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.yearLevel = yearLevel;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getYearLevel() {
		return yearLevel;
	}

	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}

}
