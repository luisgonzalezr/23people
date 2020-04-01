package com.prueba.people.dao;

import org.springframework.data.repository.CrudRepository;

import com.prueba.people.entity.Course;

public interface ICourseDao extends CrudRepository<Course, Long> {
	
	public Course findByCode(int code);

	public Course findByName(String name);

}	
	