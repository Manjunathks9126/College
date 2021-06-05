package com.college.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.college.model.College;

public interface CollegeRepository extends CrudRepository<College, Long> {
	
	public List<College> findByName(String name);

}
