package com.demo.springbootpractice.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Courses {
	@Id
	private long id;
	private String name;
	private String description;
	
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courses(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	

}
