package com.example.ProjectPracticeAngular.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ProjectPracticeAngular.entity.User;

@Repository
public class UserDao {

	@Autowired
	SessionFactory sf;
	
	@SuppressWarnings("finally")
	public boolean addUser(User user) {
			Session session =sf.openSession();
			Transaction tr = session.beginTransaction();
		try {
			
		//	tr=session.beginTransaction();
			session.save(user);
			return true;
		}catch(Exception e) {
			if(tr!=null) {
				tr.rollback();
			}	
			return false;
	}finally {
		tr.commit();
		session.close();
		return true;
	
	}
  }

	public User getUser(User user) {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.and(Restrictions.eq("email", user.getEmail()),Restrictions.eq("password", user.getPassword())));
		return (User) criteria.uniqueResult();
	}
}
