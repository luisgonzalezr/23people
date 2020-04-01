package com.prueba.people.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.people.dao.ICourseDao;
import com.prueba.people.entity.Course;

@Service
public class CourseServiceImp implements ICourseService {
	
	@Autowired
	private ICourseDao courseDao;

	@Override
	@Transactional(readOnly=true)
	public List<Course> findAll() {
	return (List<Course>) courseDao.findAll();
	}



	@Override
	@Transactional
	public Course updateCourse(Course course) {
		return (Course) courseDao.save(course);
		
	}


	@Override
	@Transactional
	public void delete(Course course) {
	courseDao.delete(course);
	}



	@Override
	@Transactional
	public void save(Course course) {
		courseDao.save(course);
		
	}


	@Override
	@Transactional(readOnly=true)
	public Course findCourse(Course course) {
		return (Course) courseDao.findByCode(course.getCode());
	}



	@Override
	public Course findByCode(int code) {
		return (Course) courseDao.findByCode(code);
		
	}



	@Override
	@Transactional(readOnly=true)
	public List<Course> findAllPaginated(int start, int size) {
		ArrayList<Course> list= (ArrayList<Course>) courseDao.findAll();
		return list.subList(start, start+size);
		
	}



	@Override
	public Course findByName(String name) {
		return (Course) courseDao.findByName(name);
	}





















}
