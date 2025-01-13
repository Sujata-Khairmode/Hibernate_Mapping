package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Laptop;
import com.entities.Stud;

public class Update {

	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Stud.class);
		cfg.addAnnotatedClass(Laptop.class);
		
		SessionFactory sf= cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		
		int l_id=1200;
		Laptop l1=ss.get(Laptop.class, l_id);
		l1.setL_name("HP");
		ss.merge(l1);
		
		int s_id=5;
		Stud s1=ss.get(Stud.class, s_id);
		s1.setS_name("smita");
		ss.merge(s1);
		
		System.out.println("updated");
		tr.commit();
		ss.close();
	}

}
