package com.studentcontrol.proyectstudent.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {
	@Id
	@GeneratedValue
	private int idTeacher;
	@Column
	private String nameTeacher;
	@Column
	private String lastname;
	
	//Relacion ST
	@ManyToMany
	@JoinTable(name="relation_st"
	,joinColumns=@JoinColumn(name="id_teacher")
	,inverseJoinColumns=@JoinColumn(name="id_student"))
	private List<Student> student;
	
	//Relacion TS
	@ManyToMany
	@JoinTable(name="relation_tm"
	,joinColumns=@JoinColumn(name="id_teacher")
	,inverseJoinColumns=@JoinColumn(name="id_subject"))
	private Set<Subject> subject;

	public Teacher() {
		
	}
	public Teacher(int idTeacher, String nameTeacher, String lastname, List<Student> student, Set<Subject> subject) {
		super();
		this.idTeacher = idTeacher;
		this.nameTeacher = nameTeacher;
		this.lastname = lastname;
		this.student = student;
		this.subject = subject;
	}
	public int getIdTeacher() {
		return idTeacher;
	}
	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}
	public String getNameTeacher() {
		return nameTeacher;
	}
	public void setNameTeacher(String nameTeacher) {
		this.nameTeacher = nameTeacher;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public Set<Subject> getSubject() {
		return subject;
	}
	public void setSubject(Set<Subject> subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Teacher [idTeacher=" + idTeacher + ", nameTeacher=" + nameTeacher + ", lastname=" + lastname
				+ ", student=" + student + ", subject=" + subject + "]";
	}
	
	
}
