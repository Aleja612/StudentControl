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
import com.studentcontrol.proyectstudent.exception.StudentNotFoundException;
import com.studentcontrol.proyectstudent.repository.StudentJpaRepository;

@RestController//controller-->encargado de recibir peticiones rest-->get post put delete

public class StudentController {
	@Autowired//atributo de clase
	private StudentJpaRepository studentJpaRepository; 
	
	@GetMapping(path="/students/find")
	public List<Student> findAll(){
		return studentJpaRepository.findAll();
	}
	
	@PostMapping(path="/students/insert")
	 public String insert (@RequestBody Student student){
		if(null != student) {
			System.out.println(" "+student.getId()+student.getName()+student.getLastname()+student.getCourse());
			studentJpaRepository.insert(student);
			return "Creado";
		}else {
			return "no creado";
		} 
			
		}
	 @PutMapping(path="/students/modificar/{id}")
	 public String update (@RequestBody Student student, @PathVariable int id){
		if(null != student) {
			studentJpaRepository.update(student, id);
			return "actualizado";
		}else {
			return "no actualizado";
		}
		
		}
	 
	 @DeleteMapping(path="/students/delete/{id}")
	 public String delete (@PathVariable int id) throws StudentNotFoundException{//declara que el metodo lanza una exception
		 Student student = studentJpaRepository.findById(id);
		 if(student != null) {
			 	studentJpaRepository.delete(id);
		 		return "se elimino";
		 	}else {//una vez se lanza la exception no se ejecuta mas codigo
		 		throw new StudentNotFoundException(String.format("Student whith id {} doesnt exists", id));
		 	}
			
		}
}
