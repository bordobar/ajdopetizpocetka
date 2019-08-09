package com.iktpreobuka.start.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@PrimaryKeyJoinColumn(name = "student_id")
public class StudentEntity extends UserEntity {
	
	
	@ManyToMany(fetch =FetchType.LAZY,cascade =CascadeType.REFRESH)
	@JoinTable(name ="Parent_Child",joinColumns =
	{@JoinColumn(name ="student_id",nullable =false,updatable =false)},
	inverseJoinColumns ={@JoinColumn(name ="parent_id",nullable =false,
	updatable =false)})
	private Set<ParentEntity>parents =new HashSet<ParentEntity>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<GradingEntity> grades = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<TeachingEntity> teachings = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "classEntity")
	private ClassEntity classEntity;
	
	
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudentEntity(String firstName, String lastName, String userName, String password, String email,
			RoleEntity role) {
		super(firstName, lastName, userName, password, email, role);
		// TODO Auto-generated constructor stub
	}

	public StudentEntity(Set<ParentEntity> parents, List<GradingEntity> grades, List<TeachingEntity> teachings,
			ClassEntity classEntity) {
		super();
		this.parents = parents;
		this.grades = grades;
		this.teachings = teachings;
		this.classEntity = classEntity;
	}


	public Set<ParentEntity> getParents() {
		return parents;
	}

	public void setParents(Set<ParentEntity> parents) {
		this.parents = parents;
	}

	public List<GradingEntity> getGrades() {
		return grades;
	}

	public void setGrades(List<GradingEntity> grades) {
		this.grades = grades;
	}

	public List<TeachingEntity> getTeachings() {
		return teachings;
	}

	public void setTeachings(List<TeachingEntity> teachings) {
		this.teachings = teachings;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}
	
}
