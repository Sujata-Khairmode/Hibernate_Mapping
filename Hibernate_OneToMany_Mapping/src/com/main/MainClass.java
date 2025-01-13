package com.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Department;
import com.entity.Employee;

public class MainClass {

	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Department.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		
		Department d= new Department();
		d.setD_id(104);
		d.setD_name("claud");
		ss.persist(d);
		
		
		Employee e1= new Employee();
		e1.setDept(d);
		e1.setE_id(3);
		e1.setE_name("smita");
		ss.persist(e1);
		
		Employee e2= new Employee();
		e2.setDept(d);
		e2.setE_id(4);
		e2.setE_name("avi");
		ss.persist(e2);
		
		Employee e3= new Employee();
		
		e3.setE_id(5);
		e3.setE_name("rohit");
		e3.setDept(d);
		ss.persist(e3);
		
		List<Employee> emp= new ArrayList<>();
		emp.add(e1);
		emp.add(e2);
		emp.add(e3);
		d.setEmp(emp);
		
	
		System.out.println("entity is saved..");
		tr.commit();
		ss.close();
		
		
	}

}
