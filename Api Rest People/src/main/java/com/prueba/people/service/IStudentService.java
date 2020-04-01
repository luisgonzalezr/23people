package com.prueba.people.service;

import java.util.List;
import com.prueba.people.entity.Student;

public interface IStudentService {
	
	public List<Student> findAll();
	
	public void save (Student student);
	
	public Student updateStudent(Student student);
	
	void delete(Student student);


	public Student findStudent(Student student);
	public Student findbyRut(String rut);

	public List<Student> findAllPaginated(int start, int size);


}
