package com.prueba.people.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.people.RutVerificador;
import com.prueba.people.entity.Student;
import com.prueba.people.service.IStudentService;

@RestController
public class StudentRestController {

	@Autowired
	private IStudentService studentService;
	
	@GetMapping("/students")
	@ResponseStatus(HttpStatus.OK)
	public List<Student> getCourses(@QueryParam("start") int start, @QueryParam("size") int size){
		if(start>0&&size>0) {
			return studentService.findAllPaginated(start-1, size);
		}
		
		else return studentService.findAll();
		//return courseService.findAll();
	}
	
	@GetMapping("/students/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Student> getStudentsAll(){
		return studentService.findAll();
		
		//devuelve la lista completa de los cursos existentes
		
	}
	@PostMapping("/students")
	public ResponseEntity<Void> addStudent(@RequestBody Student student){
		/*Se comprueba que el rut sea valido y que la edad sea+18, si es así se crea el estudiante.
		 sino, envía un mensaje de error. */
		if(studentService.findStudent(student)==null) { 
		 Student nuevo= student;
		   Boolean age= false;
		   if(student.getAge()>=18) age=true;
		   
		 	String rutFormat = student.getRut().replace(".", "");
		 	
		 	 	if(age&&RutVerificador.validar(rutFormat)) {
		 	nuevo.setAge(student.getAge());
		 	nuevo.setRut(rutFormat);
		 	  studentService.updateStudent(nuevo);
		 	}
		 	else return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		
		
		
			studentService.save(student);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
/*		Permite crear un curso con los datos proporcionados en el
	json. Devuelve status 201 si se creó exitosamente. Si los datos son inválidos debe
		devolver status 400.*/
	}
	
	@PutMapping("/students/{rut}")
	public ResponseEntity<?> updateStudent(@PathVariable (value="rut") String rut,@RequestBody Student student){
		Student studentDb=null;
		rut = rut.replace(".", "");
	     //rut = rut.replace("-", "");
		studentDb=studentService.findbyRut(rut); 
		 
		
		if(studentDb!=null) { 
			if(student.getAge()>=18) {studentDb.setAge(student.getAge());}
			else {return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);}
			
			if(!(student.getName().equals(null))||student.getName().equals("")) {
				studentDb.setName(student.getName());}
			

			if(!(student.getName().equals(null))||student.getName().equals("")) {
				studentDb.setLastName(student.getLastName());
			}
			
			studentDb.setCourse(student.getCourse());
			
			
			
			studentService.updateStudent(studentDb);
			return new ResponseEntity<>(studentDb, HttpStatus.OK);}
		
		else {return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);}
		
			//Actualiza un curso con el rut entregado y los campos incluídos en el json.
		}
	
	
	@DeleteMapping("/students/{rut}") 
	public ResponseEntity<Void> deleteStudent(@PathVariable (value="rut") String rut){ 
		
		Student studentDb=null;
		studentDb=studentService.findbyRut(rut);
		
		if(studentDb!=null) { 
			studentService.delete(studentDb);
			return new ResponseEntity<Void>(HttpStatus. OK);}
		
		else {return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);}
		
		/*Elimina un curso con el rut entregado y devuelve status 200.
			Si el curso no existe devuelve status 404.*/
		
		
	}

}
	
	
	

