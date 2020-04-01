package com.prueba.people.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String rut;
	
	private String name;
	private String lastName;
	private int age;
	
	@Column(name="course")
	private long course;
	
	public Student() {
		
	}
	
	

	public String getRut() {
		return rut;
	}



	public void setRut(String rut) {
		this.rut = rut;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public long getCourse() {
		return course;
	}



	public void setCourse(long course) {
		this.course = course;
	}



	private static final long serialVersionUID = 1L;
}