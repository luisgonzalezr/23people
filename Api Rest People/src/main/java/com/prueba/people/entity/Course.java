package com.prueba.people.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="courses")
public class Course implements Serializable {
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "course", referencedColumnName = "code")
	private List<Student> student = new ArrayList<>();
	
	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column (length=4)
	@Id
	private int code;
	
	
	@Column (name="name", unique=true)
	private String name;

	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private static final long serialVersionUID=1L;

	
	

}
