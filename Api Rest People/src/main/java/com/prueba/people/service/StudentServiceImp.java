package com.prueba.people.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.prueba.people.dao.IStudentDao;
import com.prueba.people.entity.Student;

@Service
public class StudentServiceImp implements IStudentService {
	
	@Autowired
	private IStudentDao studentDao;

	@Override
	@Transactional(readOnly=true)
	public List<Student> findAll() {
	return (List<Student>) studentDao.findAll();
	}



	@Override
	@Transactional
	public Student updateStudent(Student student) {
		return (Student) studentDao.save(student);
		
	}


	@Override
	@Transactional
	public void delete(Student student) {
	studentDao.delete(student);
	}



	@Override
	@Transactional
	public void save(Student student) {
		studentDao.save(student);
		
	}


	@Override
	@Transactional(readOnly=true)
	public Student findStudent(Student student) {
		return (Student) studentDao.findByRut(student.getRut());
	}



	@Override
	public Student findbyRut(String rut) {
		return (Student) studentDao.findByRut(rut);
		
	}



	@Override
	@Transactional(readOnly=true)
	public List<Student> findAllPaginated(int start, int size) {
		ArrayList<Student> list= (ArrayList<Student>) studentDao.findAll();
		return list.subList(start, start+size);
		
	}


















}
