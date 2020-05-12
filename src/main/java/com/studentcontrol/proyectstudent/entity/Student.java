package com.studentcontrol.proyectstudent.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;



@Entity//crea una tabla con los campos
@NamedQuery(name="findAll", query="from Student s")//query de hql 
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//el autoincrement
	private int id;
	@Column(length = 20)
	private String name;
	@Column(nullable = false)
	private String lastname;
	private String course;

	
	
	public Student() {

	}

	public Student(int id, String name, String lastname, String course) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setIdStudent(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String curse) {
		this.course = curse;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastname=" + lastname + ", course=" + course
				+ "]";
	}
}
