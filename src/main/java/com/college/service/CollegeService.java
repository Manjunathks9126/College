package com.college.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.College;
import com.college.respository.CollegeRepository;

@Service
public class CollegeService {
	@Autowired
	CollegeRepository collegeRepository;

	@Autowired
	EntityManager manager;
	public College addCollege(College college) {
		
		College c=collegeRepository.save(college);
		System.out.println("returned value:"+c);
		return c;
	}
	
	public List<College> findAll(){
		List<College> colleges=(List<College>) collegeRepository.findAll();
		
		//collegeRepository.findAll().forEach(colleges::add);
		System.out.println("data from db:"+colleges);
		return colleges;
	}
	
	public List<College> findByName(String name){
		List<College> colleges=collegeRepository.findByName(name);
		System.out.println("data from db:"+colleges);
		return colleges;
	}
}
