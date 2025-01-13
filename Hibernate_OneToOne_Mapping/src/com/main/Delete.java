package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Laptop;
import com.entities.Stud;

public class Delete {

	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Stud.class);
		cfg.addAnnotatedClass(Laptop.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		int s_id=2;
		Stud s1=ss.get(Stud.class, s_id);
		ss.remove(s1);
		int l_id=1300;
		Laptop l1=ss.get(Laptop.class,l_id);
		ss.remove(l1);
		tr.commit();
		ss.close();
		System.out.println("deleted..");
		
	}

}
