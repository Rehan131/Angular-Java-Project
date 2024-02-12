package com.example.ProjectPracticeAngular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectPracticeAngular.dao.MobileDao;
import com.example.ProjectPracticeAngular.entity.Mobile;

@Service
public class MobileService {
	
	@Autowired
	MobileDao md;
	
	public List<Mobile> getAllMobiles() {
		
		return md.getAllMobiles();
	}

	public List<Mobile> getBySpeed() {
		return md.getBySpeed();
	}

	public Mobile addMobile(Mobile mobile) {
		return md.addMobile(mobile);
	}

	public Mobile updateMobile(Mobile mobile) {
		return md.updateMobile(mobile);
	}

	public Mobile deleteMobile(Integer mobileid) {
		return md.deleteMobile(mobileid);
	}

	public Mobile getOneMobile(Integer mobileid) {
		return md.getOneMobile(mobileid);
	}

}
