package com.studentcontrol.proyectstudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.studentcontrol.proyectstudent.entity.Teacher;
import com.studentcontrol.proyectstudent.repository.TeacherJpaRepository;

@RestController
public class TeacherController {
	@Autowired
	private TeacherJpaRepository teacherJpaRepository;
	
	@GetMapping(path="/teacher/insert")
	public String insert (@RequestBody Teacher teacher) {
		if(null != teacher) {
			System.out.println(" "+teacher.getIdTeacher()+teacher.getLastname());
			teacherJpaRepository.insert(teacher);
			return "Creado";
		}else {
			return "no creado";
		} 
	}
	@PutMapping(path="/teacher/update/{id}")
	 public String update (@RequestBody Teacher teacher, @PathVariable int idTeacher){
		if(null != teacher) {
			teacherJpaRepository.update(teacher, idTeacher);
			return "actualizado";
		}else {
			return "no actualizado";
		}
	}
	
	 @DeleteMapping(path="/teacher/delete/{id}")
	 public String delete (@PathVariable int idTeacher) {
		 Teacher teacher = teacherJpaRepository.findById(idTeacher);
		 if(teacher != null) {
			 	teacherJpaRepository.delete(idTeacher);
		 		return "se elimino";
		 	}else {
		 		return "no se elimino";
		 	}
	 }
}
