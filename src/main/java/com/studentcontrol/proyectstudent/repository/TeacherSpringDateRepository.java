package com.studentcontrol.proyectstudent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentcontrol.proyectstudent.entity.Teacher;

public interface TeacherSpringDateRepository extends JpaRepository<Teacher,Integer> {

}
