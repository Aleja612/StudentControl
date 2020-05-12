package com.studentcontrol.proyectstudent.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.studentcontrol.proyectstudent.entity.Student;

@Repository
@Transactional//Indica que todo lo que pase en la clase pasa en una transaccion--> Begin-->commit
public class StudentJpaRepository {
	@PersistenceContext
	EntityManager entityManager;
	
	public Student findById (int id) {
		return entityManager.find(Student.class, id);
	}
	
	public List<Student> findAll(){
		TypedQuery<Student> query = entityManager.createNamedQuery("findAll", Student.class);//type-->Tipado-->tipo de retorno
		return query.getResultList();//Retorna un listado 
	}
	
	public void insert(Student student) {
		//entityManager.createNativeQuery("insert into student (NAME,LASTNAME,COURSE) values (?,?,?)")
		//.setParameter(1, student.getName())
		//.setParameter(2, student.getLastname())
		//.setParameter(3, student.getCourse())
		//.executeUpdate();
		entityManager.persist(student);//envia la entidad y hace el query por debajo
		}
	public void update(Student student, int id) {
		Student updateStudent= findById(id);
		updateStudent.setName(student.getName());//primero establezco el valor de la variable que cree y luego le asigno el valor a la bd
		updateStudent.setLastname(student.getLastname());
		updateStudent.setCourse(student.getCourse());
		entityManager.persist(updateStudent);
	} 
	
	public void delete(int id) {
		Student deleteStudent= findById(id);
		entityManager.remove(deleteStudent);
	}
}
