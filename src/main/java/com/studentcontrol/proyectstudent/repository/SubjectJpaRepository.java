package com.studentcontrol.proyectstudent.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.studentcontrol.proyectstudent.entity.Subject;

@Repository
@Transactional
public class SubjectJpaRepository {
	@PersistenceContext
	EntityManager entityManager;
	
	public Subject findById (int idSubject) {
		return entityManager.find(Subject.class, idSubject);
	}
	public List<Subject> findAll(){
		TypedQuery<Subject> query = entityManager.createNamedQuery("findAll",Subject.class);
		return query.getResultList();
	}
	
	public void insert(Subject subject) {
		entityManager.persist(subject);//persist envia la entidad y hace el query por debajo
	}
	
	public void update(Subject subject, int idSubject) {
		Subject updateSubject= findById(idSubject);
		updateSubject.setNameSubject(subject.getNameSubject());
		updateSubject.setCredits(subject.getCredits());
		//updateSubject.setStudent(subject.getStudent());
		entityManager.persist(updateSubject);
	}
	
	public void delete(int idSubject) {
		Subject deleteSubject= findById(idSubject);
		entityManager.remove(deleteSubject);
	}
}
