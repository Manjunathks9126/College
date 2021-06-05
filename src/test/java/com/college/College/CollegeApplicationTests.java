package com.college.College;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.college.model.College;
import com.college.respository.CollegeRepository;
import com.college.service.CollegeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollegeApplicationTests {
	
	@Autowired
	CollegeService collegeService;

	@MockBean
	CollegeRepository repo;
	
	@Test
	public void testGetAllCollege() {
	when(repo.findAll()).thenReturn(Stream.of(
		new College(new Long(1), "GAT", "VTU", "Narendra"),new College(new Long(2), "VKIT", "VTU", "Viveka")).collect(Collectors.toList()));
		assertEquals(2,collegeService.findAll().size());
	}
	
	@Test
	public void testAddCollege() {
		College c=new College(new Long(2), "KLE", "BU", "SSS");
		when(repo.save(c)).thenReturn(c);
		assertEquals(c.hashCode(), collegeService.addCollege(c).hashCode());
	}

	@Test
	public void testFindByName() {
		String name="";
		when(repo.findByName(name)).thenReturn(Stream.of(
		new College(new Long(1), "GAT", "VTU", "Narendra")).collect(Collectors.toList()));
		assertEquals(1,collegeService.findByName("").size());
	}
}
