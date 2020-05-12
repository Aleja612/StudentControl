package com.studentcontrol.proyectstudent.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.studentcontrol.proyectstudent.entity.Student;

@Repository
public class StudentJdbcDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;//query -->Forma Larga
	
	public List<Student> findAll() {
		return jdbcTemplate.query("select * from student", new BeanPropertyRowMapper<Student>(Student.class));
	}
	
	/*public int insert (Student student) {
		return jdbcTemplate.update("insert into student (id,name,lastname,course) values(?,?,?,?)",
				new  Object[] {student.getId(),student.getName(),student.getLastname(),student.getCourse()});
	}*/
	
	public int insert(Student student) {
		return jdbcTemplate.update("insert into student (id,name,lastname,course) values (?,?,?,?)", student.getId(),student.getName(),student.getLastname(),student.getCourse());
		}
	
	
}
