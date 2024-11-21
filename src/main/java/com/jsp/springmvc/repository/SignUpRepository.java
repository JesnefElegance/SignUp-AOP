package com.jsp.springmvc.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.jsp.springmvc.model.SignUp;

@Repository
public class SignUpRepository {

	public String signUp(SignUp s) {
		Session session = new Configuration().configure()
											 .addAnnotatedClass(SignUp.class)
											 .buildSessionFactory()
											 .openSession();
		Transaction trans = session.beginTransaction();
		
		session.save(s);
		
		trans.commit();
		session.close();
		
		return "Data Saved Successfully";
	}
}
