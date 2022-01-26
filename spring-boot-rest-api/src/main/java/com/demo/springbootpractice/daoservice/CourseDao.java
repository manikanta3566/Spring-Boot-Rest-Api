package com.demo.springbootpractice.daoservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springbootpractice.Entities.Courses;

public interface CourseDao extends JpaRepository<Courses,Long>{

}
