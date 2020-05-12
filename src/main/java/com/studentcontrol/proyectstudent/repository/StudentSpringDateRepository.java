package com.studentcontrol.proyectstudent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentcontrol.proyectstudent.entity.Student;

public interface StudentSpringDateRepository extends JpaRepository<Student,Integer>{

}
