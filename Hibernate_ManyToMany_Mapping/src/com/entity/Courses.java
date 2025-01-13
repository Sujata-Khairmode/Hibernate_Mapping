package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Courses {
	@Id
	private int c_id;
	private String c_name;
	
	@ManyToMany
	@JoinTable(name="stud_courses",
	joinColumns=@JoinColumn(name="c_id"))
	private  List<Student12> student;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public List<Student12> getStudent() {
		return student;
	}

	public void setStudent(List<Student12> student) {
		this.student = student;
	}

	public Courses() {
		
	}

	public Courses(int c_id, String c_name, List<Student12> student) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.student = student;
	}

	@Override
	public String toString() {
		return "Courses [c_id=" + c_id + ", c_name=" + c_name + ", student=" + student + "]";
	}
	

	

}
