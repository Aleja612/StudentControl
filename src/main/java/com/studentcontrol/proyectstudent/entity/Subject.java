package com.studentcontrol.proyectstudent.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Subject {
	@Id
	@GeneratedValue
	private int idSubject;
	private String nameSubject;
	private String credits;
	
	//relacion
	@ManyToMany
	@JoinTable(name="relation_sm"
	,joinColumns=@JoinColumn(name="id_subject")
	,inverseJoinColumns=@JoinColumn(name="id_student"))
	private List<Student> student;

	public Subject() {
		
	}
	public Subject(int idSubject, String nameSubject, String credits, List<Student> student) {
		super();
		this.idSubject = idSubject;
		this.nameSubject = nameSubject;
		this.credits = credits;
		this.student = student;
	}
	public int getIdSubject() {
		return idSubject;
	}
	public void setIdSubject(int idSubject) {
		this.idSubject = idSubject;
	}
	public String getNameSubject() {
		return nameSubject;
	}
	public void setNameSubject(String nameSubject) {
		this.nameSubject = nameSubject;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Subject [idSubject=" + idSubject + ", nameSubject=" + nameSubject + ", credits=" + credits
				+ ", student=" + student + "]";
	}
	
}
