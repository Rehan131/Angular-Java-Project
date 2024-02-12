package com.example.ProjectPracticeAngular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectPracticeAngular.entity.Mobile;
import com.example.ProjectPracticeAngular.exceptions.IdNotFoundException;
import com.example.ProjectPracticeAngular.service.MobileService;

@CrossOrigin
@RestController
public class MobileController {

	@Autowired
	MobileService ms;
	
	@GetMapping("/getAllMobiles")
	public List<Mobile> getAllMobiles() {
		return ms.getAllMobiles();
	}
	
	@GetMapping("/getBySpeed")
	public List<Mobile> getBySpeed() {
		return ms.getBySpeed();
	}
	
	@PostMapping("/addMobile")
	public Mobile addMobile(@RequestBody Mobile mobile) {
		return ms.addMobile(mobile);
	}
	
	@PutMapping("/updateMobile")
	public Mobile updateMobile(@RequestBody Mobile mobile) {
		return ms.updateMobile(mobile);
	}
	
	@DeleteMapping("/deleteMobile/{mobileid}")
	public Mobile deleteMobile(@PathVariable Integer mobileid) {
		return ms.deleteMobile(mobileid);
	}
	
	@GetMapping("/getOneMobile/{mobileid}")
	public Mobile getOneMobile(@PathVariable ("mobileid") Integer mobileid) {
		try {
		return ms.getOneMobile(mobileid);
		}catch(IdNotFoundException exception) {
			throw new IdNotFoundException("The Id you are providing is not available in DataBase");
		}
	}
}
