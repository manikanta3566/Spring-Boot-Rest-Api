package com.demo.springbootpractice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootpractice.Entities.Courses;
import com.demo.springbootpractice.service.Service;

@RestController

public class Controller {
	
	@Autowired
	private Service service;
	
//to get all courses
@GetMapping("/courses")
public ResponseEntity<List<Courses>> getCourses(){
	List<Courses> c=this.service.getCourses();
	try {
		return ResponseEntity.of(Optional.of(c));
	}
	catch(Exception e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}

//to get single course by id
@GetMapping("/courses/{id}")
public ResponseEntity<Optional<Courses>>  getCourseById(@PathVariable String id) {
	Optional<Courses> c=this.service.getCourseById(Long.parseLong(id));
	System.out.println(c);
	if(c.isEmpty()){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}else {
	return ResponseEntity.of(Optional.of(c));
	}
}

//to add a new course
@PostMapping("/courses")
public ResponseEntity<Courses> addCourse(@RequestBody Courses course) {
Courses c=this.service.addCourse(course);
try {
	return ResponseEntity.of(Optional.of(c));
}
catch (Exception e) {
	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}
}

//to update a existing course
@PutMapping("/courses")
public ResponseEntity<Courses> updateCourse(@RequestBody Courses course) {
	Courses c=this.service.updateCourse(course);
	try {
		return ResponseEntity.of(Optional.of(c));
	}catch (Exception e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}

//to delete course by id
@DeleteMapping("/courses/{id}")
public ResponseEntity<HttpStatus>  deleteById(@PathVariable String id) {
	try { 
	this.service.deleteById(Long.parseLong(id));
	return new ResponseEntity<HttpStatus>(HttpStatus.OK);
}
	catch(Exception e) {
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}
}


	

}
