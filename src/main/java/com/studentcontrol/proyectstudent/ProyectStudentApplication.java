package com.studentcontrol.proyectstudent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentcontrol.proyectstudent.entity.Student;
import com.studentcontrol.proyectstudent.repository.StudentSpringDateRepository;
//ResponseEntityExceptionHandler
//@ControllerAdvice
//ResponseEntity
@SpringBootApplication

public class ProyectStudentApplication /*implements CommandLineRunner*/ {//nos permite que la aplicacion ejecute el metodo run
	
	//private final Logger logger = LoggerFactory.getLogger(this.getClass());//
	//@Autowired
	//StudentJdbcDao studentJdbcDao;
	//@Autowired //por cada inyeccion una anotacion
	//StudentSpringDateRepository studentSpringDateRepository;
	//StudentJpaRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectStudentApplication.class, args);
		
	}

	//@Override
	//public void run(String... args) throws Exception {//no es statico -main no statico-se pueden inyectar dependencias-usar metodos o atributos de clase
		// TODO Auto-generated method stub
		//logger.info("Hola Mundo");
		//Student student = studentRepository.findById(2);
		//logger.info("El estudiante es: "+student);
		//logger.info("All Students {}",studentSpringDateRepository.findAll());
		//studentSpringDateRepository.deleteById(1);
		//logger.info("insert new student {}",studentSpringDateRepository.save(new Student(4,"Jose","Nieto","German")));
	//}

}
