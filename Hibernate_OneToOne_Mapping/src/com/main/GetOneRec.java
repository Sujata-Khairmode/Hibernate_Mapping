package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Laptop;
import com.entities.Stud;

public class GetOneRec {

	public static void main(String[] args) {
		Configuration cfg =new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Stud.class);
		cfg.addAnnotatedClass(Laptop.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		int l_id=1400;
		Laptop l1=ss.get(Laptop.class, l_id);
	
		System.out.println(l1);
		
		int s_id=3;
		Stud s1=ss.get(Stud.class, s_id);
		tr.commit();
		System.out.println("one record is fetched..");
		System.out.println(s1);
	}

}
