package com.iktpreobuka.start.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.start.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{

}
