package com.college.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.model.College;
import com.college.service.CollegeService;

@RestController
@RequestMapping("/api/v1")
public class CollegeController {

	@Autowired
	CollegeService service;
	
	@PostMapping("/college")
	public ResponseEntity<?> addCollege(@RequestBody College college) {
		System.out.println("college:"+college);
		service.addCollege(college);
		return ResponseEntity.ok(college);
	}
	
	@GetMapping("/college")
	public ResponseEntity<List<College>> getAllCollege(@RequestParam Map<String, String> params){
		List<College> colleges=null;
		if(params.size()>0) {
			String name=params.get("name");
			colleges=service.findByName(name);
		}else {
			colleges=service.findAll();	
		}
		return ResponseEntity.ok(colleges);
	}
	
}
