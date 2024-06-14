package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Course {

	private Long id;
	private String c_name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public Course(String c_name) {
		super();
		this.c_name = c_name;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
