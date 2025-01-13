package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	private int e_id;
	private String e_name;
	@ManyToOne
	private Department dept;
	
	public Employee() {
		
	}
	
	public Employee(int e_id, String e_name, Department dept) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.dept = dept;
	}



	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", e_name=" + e_name + ", dept=" + dept + "]";
	}
	
	

}
