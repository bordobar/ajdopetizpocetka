package com.iktpreobuka.start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.start.entities.ParentEntity;
import com.iktpreobuka.start.repositories.ParentRepository;

@RestController
@RequestMapping(path="/parents")
public class ParentController {
	@Autowired
	private ParentRepository parentRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public ParentEntity addNewParent(@RequestBody ParentEntity newParent) {
		ParentEntity parent = new ParentEntity();
		parentRepository.save(parent);
		return parent;
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.GET, path = "/all")
	public Iterable<ParentEntity> getAllParents(){
		return parentRepository.findAll();
	}


}
