package com.prueba.people.dao;

import org.springframework.data.repository.CrudRepository;

import com.prueba.people.entity.Student;

public interface IStudentDao extends CrudRepository<Student, Long> {
	
	public Student findByRut(String rut);

}
