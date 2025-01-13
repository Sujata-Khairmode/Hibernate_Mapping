package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Laptop;
import com.entities.Stud;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class FetchAllRecord {
 
	 public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Stud.class);
		cfg.addAnnotatedClass(Laptop.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		 
		CriteriaBuilder hcb1=ss.getCriteriaBuilder();
		CriteriaQuery<Object>cq1=hcb1.createQuery();
		Root<Laptop>root1=cq1.from(Laptop.class);
		cq1.select(root1);
		Query query1=ss.createQuery(cq1);
		List<Laptop>list1=query1.getResultList();
		for (Laptop laptop : list1) {
			System.out.println(laptop);
		}
		
		
		
		CriteriaBuilder hcb=ss.getCriteriaBuilder();
		CriteriaQuery<Object>cq=hcb.createQuery();
		Root<Stud> root=cq.from(Stud.class);
		cq.select(root);
		Query query=ss.createQuery(cq);
		List<Stud>list=query.getResultList();
		for (Stud stud : list) {
			System.out.println(stud);
		}

		
		
	 }
}
