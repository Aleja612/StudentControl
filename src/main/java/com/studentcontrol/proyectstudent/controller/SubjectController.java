package com.studentcontrol.proyectstudent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentcontrol.proyectstudent.entity.Student;
import com.studentcontrol.proyectstudent.entity.Subject;
import com.studentcontrol.proyectstudent.exception.StudentNotFoundException;
import com.studentcontrol.proyectstudent.repository.SubjectJpaRepository;

@RestController
public class SubjectController {
	@Autowired
	private SubjectJpaRepository subjectJpaRepository;

	@GetMapping(path="/subject/find")
	public List<Subject> findAll(){
		return subjectJpaRepository.findAll();
	}
	
	@PostMapping(path="/subject/insert")
	public String insert (@RequestBody Subject subject) {
		if(null != subject) {
			System.out.println(" "+subject.getIdSubject()+subject.getCredits());
			subjectJpaRepository.insert(subject);
			return "Creado";
		}else {
			return "no creado";
		} 
	}
	@PutMapping(path="/subject/update/{id}")
	 public String update (@RequestBody Subject subject, @PathVariable int idSubject){
		if(null != subject) {
			subjectJpaRepository.update(subject, idSubject);
			return "actualizado";
		}else {
			return "no actualizado";
		}
	}
	
	 @DeleteMapping(path="/subject/delete/{id}")
	 public String delete (@PathVariable int idSubject) {
		 Subject subject = subjectJpaRepository.findById(idSubject);
		 if(subject != null) {
			 	subjectJpaRepository.delete(idSubject);
		 		return "se elimino";
		 	}else {
		 		return "no se elimino";
		 	}
	 }
}
