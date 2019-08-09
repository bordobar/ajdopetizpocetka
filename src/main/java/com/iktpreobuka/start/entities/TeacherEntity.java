package com.iktpreobuka.start.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@PrimaryKeyJoinColumn(name = "teacher_id")
public class TeacherEntity extends UserEntity{
	
	@JsonIgnore
	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<TeachingEntity> teachings = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "grade", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<GradingEntity> grades = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "subject")
	private SubjectEntity subject;
	
	public TeacherEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public TeacherEntity(String firstName, String lastName, String userName, String password, String email,
			RoleEntity role) {
		super(firstName, lastName, userName, password, email, role);
		// TODO Auto-generated constructor stub
	}



	public TeacherEntity(List<TeachingEntity> teachings, List<GradingEntity> grades, SubjectEntity subject) {
		super();
		this.teachings = teachings;
		this.grades = grades;
		this.subject = subject;
	}



	public List<TeachingEntity> getTeachings() {
		return teachings;
	}

	public void setTeachings(List<TeachingEntity> teachings) {
		this.teachings = teachings;
	}

	public List<GradingEntity> getGrades() {
		return grades;
	}

	public void setGrades(List<GradingEntity> grades) {
		this.grades = grades;
	}

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}
	
	
}
