package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fname;
	private String lname;
	private String no;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Student(String fname, String lname, String no, List<Course> courses) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.no = no;
		this.courses = courses;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
