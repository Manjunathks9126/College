package com.college.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@Slf4j

@NamedQueries(
		{@NamedQuery(name = "College.findByName", query = "select c from College c where c.collegeName=:name") }
		)
public class College {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long collegeId;
	private String collegeName;
	private String universityName;
	private String principalName;
	
	public College() {
		super();
	}
	
	public College(Long collegeId, String collegeName, String universityName, String principalName) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.universityName = universityName;
		this.principalName = principalName;
	}

	
	
	

}
