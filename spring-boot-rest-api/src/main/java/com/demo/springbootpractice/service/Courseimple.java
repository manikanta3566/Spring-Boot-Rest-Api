package com.demo.springbootpractice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.springbootpractice.Entities.Courses;
import com.demo.springbootpractice.daoservice.CourseDao;

@Component
public class Courseimple implements Service {
//	List<Courses> list=new ArrayList<>();
//	
	@Autowired
	CourseDao coursedao;

	public Courseimple() {
//		
//		list.add(new Courses(1001,"java full stack","learn java in 100steps"));
//		list.add(new Courses(1002,"python full stack","learn python in 100steps"));

	}

	// to get all courses
	@Override
	public List<Courses> getCourses() {
		return coursedao.findAll();

	}

	// to get single course by id
	@Override
	public Optional<Courses> getCourseById(long id) {
//		Courses c = null;
//		for (Courses courses : list) {
//			if (courses.getId() == id) {
//				c = courses;
//				break;
//			}
//		}
//		return c;
		return coursedao.findById(id);
		

	}

	// to add a new course
	@Override
	public Courses addCourse(Courses course) {
		return coursedao.save(course);

	}

	// to update a existing course
	@Override
	public Courses updateCourse(Courses course) {

		return coursedao.save(course);
	}

	// to delete course by id
	@Override
	public Courses deleteById(long id) {

//		for (Courses courses : list) {
//			if (courses.getId() == id) {
//				list.remove(courses);
//				break;
//			}
//
//		}
//		return list;
		Courses c = coursedao.getById(id);
		coursedao.delete(c);
		return c;

	}

}
