package com.iktpreobuka.start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.start.entities.TeacherEntity;
import com.iktpreobuka.start.repositories.TeacherRepository;

@RestController
@RequestMapping(path="/teachers")
public class TeacherController {
	@Autowired
	private TeacherRepository teacherRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public TeacherEntity addNewTeacher(@RequestBody TeacherEntity newTeacher) {
		TeacherEntity student = new TeacherEntity();
		teacherRepository.save(student);
		return student;
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.GET, path = "/all")
	public Iterable<TeacherEntity> getAllTeachers(){
		return teacherRepository.findAll();
	}


}
