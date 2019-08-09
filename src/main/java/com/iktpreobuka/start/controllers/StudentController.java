package com.iktpreobuka.start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.start.entities.StudentEntity;
import com.iktpreobuka.start.repositories.StudentRepository;

@RestController
@RequestMapping(path="/students")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public StudentEntity addNewStudent(@RequestBody StudentEntity newStudent) {
		StudentEntity student = new StudentEntity();
		studentRepository.save(student);
		return student;
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.GET, path = "/all")
	public Iterable<StudentEntity> getAllStudents(){
		return studentRepository.findAll();
	}

}
