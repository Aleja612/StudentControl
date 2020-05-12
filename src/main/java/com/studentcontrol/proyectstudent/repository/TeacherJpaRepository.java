package com.studentcontrol.proyectstudent.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.studentcontrol.proyectstudent.entity.Teacher;

@Repository
@Transactional
public class TeacherJpaRepository {
	@PersistenceContext
	EntityManager entityManager;
	
	public Teacher findById (int idTeacher) {
		return entityManager.find(Teacher.class, idTeacher);
		}
	
	public List<Teacher> findAll(){
		TypedQuery<Teacher> query = entityManager.createNamedQuery("findAll",Teacher.class);
		return query.getResultList();
	}
	
	public void insert(Teacher teacher) {
		entityManager.persist(teacher);//persist envia la entidad y hace el query por debajo
	}
	
	public void update(Teacher teacher, int idTeacher) {
		Teacher updateTeacher = findById(idTeacher);
		updateTeacher.setNameTeacher(teacher.getNameTeacher());
		updateTeacher.setLastname(teacher.getLastname());
		entityManager.persist(updateTeacher);
	}
	
	public void delete(int idTeacher) {
		Teacher deleteTeacher= findById(idTeacher);
		entityManager.remove(deleteTeacher);
	}
}
