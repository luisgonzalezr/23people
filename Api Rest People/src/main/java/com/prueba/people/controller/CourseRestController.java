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

import com.prueba.people.entity.Course;
import com.prueba.people.service.ICourseService;


@RestController
public class CourseRestController {
	

	@Autowired
	private ICourseService courseService;
	
	@GetMapping("courses")
	@ResponseStatus(HttpStatus.OK)
	public List<Course> getCourses(@QueryParam("start") int start, @QueryParam("size") int size){
		if(start>0&&size>0) {
			return courseService.findAllPaginated(start-1, size);
		}
		
		//http://localhost:8040/courses?start=1&&size=1
		
		else return courseService.findAll();
		//return courseService.findAll();
	}
	
	@GetMapping("courses/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Course> getCoursesAll(){
		return courseService.findAll();
		
		//devuelve la lista completa de los cursos existentes
		
	}
	@PostMapping("courses")
	public ResponseEntity<Void> addCourse(@RequestBody Course course){
		if(courseService.findByName(course.getName())==null) { 
			courseService.save(course);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
/*		Permite crear un curso con los datos proporcionados en el
	json. Devuelve status 201 si se creó exitosamente. Si los datos son inválcodeos debe
		devolver status 400.*/
	}
	
	@PutMapping("courses/{code}")
	public ResponseEntity<?> updateCourse(@PathVariable (value="code") int code,@RequestBody Course course){
		Course courseDb=null;
		courseDb=courseService.findByCode(code); 
		
		if(courseDb!=null) { 
			courseDb.setName(course.getName());
			courseService.updateCourse(courseDb);
			return new ResponseEntity<>(courseDb, HttpStatus.OK);}
		
		else {return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);}
		
			//Actualiza un curso con el code entregado y los campos incluídos en el json.
		}
	
	
	@DeleteMapping("courses/{code}") 
	public ResponseEntity<Void> deleteCourse(@PathVariable (value="code") int code){ 
		
		Course courseDb=null;
		courseDb=courseService.findByCode(code);
		
		if(courseDb!=null) { 
			courseService.delete(courseDb);
			return new ResponseEntity<Void>(HttpStatus. OK);}
		
		else {return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);}
		
		/*Elimina un curso con el code entregado y devuelve status 200.
			Si el curso no existe devuelve status 404.*/
		
		
	}
	
}

	
	
	
	

