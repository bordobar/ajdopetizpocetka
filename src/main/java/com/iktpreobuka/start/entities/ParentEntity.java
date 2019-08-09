package com.iktpreobuka.start.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@PrimaryKeyJoinColumn(name = "parent_id")
public class ParentEntity extends UserEntity{
	

	@ManyToMany(fetch =FetchType.LAZY,cascade =CascadeType.REFRESH)
	@JoinTable(name ="Parent_Child",joinColumns =
	{@JoinColumn(name ="parent_id",nullable =false,updatable =false)},
	inverseJoinColumns ={@JoinColumn(name ="student_id",
	nullable =false,updatable =false)})
	private Set<StudentEntity>children =new HashSet<StudentEntity>();

	public ParentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ParentEntity(String firstName, String lastName, String userName, String password, String email,
			RoleEntity role) {
		super(firstName, lastName, userName, password, email, role);
		// TODO Auto-generated constructor stub
	}


	public ParentEntity(Set<StudentEntity> children) {
		super();
		this.children = children;
	}


	public Set<StudentEntity> getChildren() {
		return children;
	}

	public void setChildren(Set<StudentEntity> children) {
		this.children = children;
	}
	
	
}
