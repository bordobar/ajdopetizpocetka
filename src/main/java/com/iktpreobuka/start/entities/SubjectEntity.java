package com.iktpreobuka.start.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SubjectEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer subjectId;
	private String name;
	private Integer weekFund;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "classYear")
	private ClassYearEntity classYear;
	
	@JsonIgnore
	@OneToMany(mappedBy = "grade", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<GradingEntity> grades = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<TeachingEntity> teachings = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<TeacherEntity> teachers = new ArrayList<>();

	public SubjectEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubjectEntity(Integer subjectId, String name, Integer weekFund, ClassYearEntity classYear,
			List<GradingEntity> grades, List<TeachingEntity> teachings, List<TeacherEntity> teachers) {
		super();
		this.subjectId = subjectId;
		this.name = name;
		this.weekFund = weekFund;
		this.classYear = classYear;
		this.grades = grades;
		this.teachings = teachings;
		this.teachers = teachers;
	}

	public Integer getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getWeekFund() {
		return weekFund;
	}


	public void setWeekFund(Integer weekFund) {
		this.weekFund = weekFund;
	}


	public ClassYearEntity getClassYear() {
		return classYear;
	}


	public void setClassYear(ClassYearEntity classYear) {
		this.classYear = classYear;
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

	public List<TeacherEntity> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<TeacherEntity> teachers) {
		this.teachers = teachers;
	}
	
	
}
