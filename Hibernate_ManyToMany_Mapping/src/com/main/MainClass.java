package com.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Courses;
import com.entity.Student12;

public class MainClass {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student12.class);
		cfg.addAnnotatedClass(Courses.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Courses c = new Courses();
		c.setC_id(201);
		c.setC_name("java full stack");
		ss.persist(c);
		
		Courses c1 = new Courses();
		c1.setC_id(202);
		c1.setC_name("python");
		ss.persist(c1);
		
		Courses c2 = new Courses();
		c2.setC_id(203);
		c2.setC_name(".Net");
		ss.persist(c2);
		
		Courses c3 = new Courses();
		c3.setC_id(204);
		c3.setC_name("android");
		ss.persist(c3);

		Student12 s = new Student12();
		s.setS_id(2);
		s.setName("avi");
		
		Student12 s1 = new Student12();
		s1.setS_id(3);
		s1.setName("pavi");
	
		Student12 s2 = new Student12();
		s2.setS_id(4);
		s2.setName("Ragu");
		
		Student12 s3 = new Student12();
		s3.setS_id(5);
		s3.setName("swara");
		
		List<Student12> list= new ArrayList<Student12>();
		list.add(s);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		c.setStudent(list);
		c1.setStudent(list);
		c2.setStudent(list);
		c3.setStudent(list);
		ss.persist(c);
		ss.persist(c1);
		ss.persist(c2);
		ss.persist(c3);
		
		List<Courses> list1= new ArrayList<Courses>();
		list1.add(c);
		list1.add(c3);
		list1.add(c2);
		list1.add(c1);
		c.setStudent(list);
		c1.setStudent(list);
		c2.setStudent(list);
		c3.setStudent(list);
		
		ss.persist(s);
		ss.persist(s1);
		ss.persist(s2);
		ss.persist(s3);
		tr.commit();
		ss.close();
	}

}
