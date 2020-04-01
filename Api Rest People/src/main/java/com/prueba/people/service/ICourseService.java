package com.prueba.people.service;

import java.util.List;
import com.prueba.people.entity.Course;

public interface ICourseService {
	
	public List<Course> findAll();
	
	public void save (Course course);
	
	public Course updateCourse(Course course);
	
	public void delete(Course course);

	public Course findCourse(Course course);
	
	public Course findByCode(int code);
	
	public Course findByName(String name);

	public List<Course> findAllPaginated(int start, int size);

	
	
}
