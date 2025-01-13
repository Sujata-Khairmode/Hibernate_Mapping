package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Laptop;
import com.entities.Stud;

public class InsertMainClass {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Stud.class);
		cfg.addAnnotatedClass(Laptop.class);
		
		SessionFactory sf= cfg.buildSessionFactory();
		Session ss= sf.openSession();
		Transaction tr= ss.beginTransaction();
		
		Laptop l= new Laptop();
		l.setL_id(1700);
		l.setL_name("asus");
		ss.persist(l);
		
		Stud s = new Stud();
		s.setS_id(6);
		s.setS_name("sujata");
		s.setLaptop(l);
		ss.persist(s);
		System.out.println("inserted");
		tr.commit();
		ss.close();
		

	}

}
