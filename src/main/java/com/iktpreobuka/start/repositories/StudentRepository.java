package com.iktpreobuka.start.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.start.entities.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

}
