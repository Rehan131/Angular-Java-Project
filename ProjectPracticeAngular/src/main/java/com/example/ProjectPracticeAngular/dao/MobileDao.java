package com.example.ProjectPracticeAngular.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ProjectPracticeAngular.entity.Mobile;
import com.example.ProjectPracticeAngular.sorting.MobileSorting;

@Repository
public class MobileDao {

	@Autowired
	SessionFactory sf;
	
	public List<Mobile> getAllMobiles() {
		
		Session session =sf.openSession();
		Criteria criteria=session.createCriteria(Mobile.class);
		try {
			List<Mobile> list =criteria.list();
			return list;
		}finally {
			session.close();
		}		
	}

	public List<Mobile> getBySpeed() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Mobile.class);
		List<Mobile> list=criteria.list();
		Collections.sort(list, new MobileSorting());
		session.close();
		return list;
	}

	public Mobile addMobile(Mobile mobile) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(mobile);
		tr.commit();
		session.close();
		return mobile;
		
	}

	public Mobile updateMobile(Mobile mobile) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.update(mobile);
		tr.commit();
		session.close();
		return mobile;
		
	}

	public Mobile deleteMobile(Integer mobileid) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Mobile mobile=session.get(Mobile.class, mobileid);
		session.delete(mobile);
		tr.commit();
		session.close();
		return mobile;
	}

	public Mobile getOneMobile(Integer mobileid) {
		Session session =sf.openSession();
		Mobile mobile=session.get(Mobile.class, mobileid);
		session.close();
		return mobile;
	}

}
