package com.demo.springbootpractice.service;

import java.util.List;
import java.util.Optional;

import com.demo.springbootpractice.Entities.Courses;

public interface Service {
	public List<Courses> getCourses();
	public Optional<Courses>  getCourseById(long id);
	public Courses addCourse(Courses course);
	public Courses updateCourse(Courses course);
	public Courses  deleteById(long id);
}
