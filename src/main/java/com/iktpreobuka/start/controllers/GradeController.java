package com.iktpreobuka.start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.start.entities.GradeEntity;
import com.iktpreobuka.start.repositories.GradeRepository;

@RestController
@RequestMapping(path = "/grades")
public class GradeController {
	@Autowired
	private GradeRepository gradeRepository;
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.GET, path = "/all")
	public Iterable<GradeEntity> getAllGrades(){
		return gradeRepository.findAll();
	}


}
