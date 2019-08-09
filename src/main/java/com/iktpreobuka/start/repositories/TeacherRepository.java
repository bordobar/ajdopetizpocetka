package com.iktpreobuka.start.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.start.entities.TeacherEntity;

public interface TeacherRepository extends CrudRepository<TeacherEntity, Integer> {

}
