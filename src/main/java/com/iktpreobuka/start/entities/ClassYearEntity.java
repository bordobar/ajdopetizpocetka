package com.iktpreobuka.start.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iktpreobuka.start.enumerations.ClassYear;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance (strategy = InheritanceType.JOINED)
public class ClassYearEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer classYearId;
	private ClassYear classYear;
	
	@JsonIgnore
	@OneToMany(mappedBy = "classYear", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<SubjectEntity> subjects = new ArrayList<>();

	public ClassYearEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassYearEntity(Integer classYearId, ClassYear classYear, List<SubjectEntity> subjects) {
		super();
		this.classYearId = classYearId;
		this.classYear = classYear;
		this.subjects = subjects;
	}

	public Integer getClassYearId() {
		return classYearId;
	}

	public void setClassYearId(Integer classYearId) {
		this.classYearId = classYearId;
	}

	public ClassYear getClassYear() {
		return classYear;
	}

	public void setClassYear(ClassYear classYear) {
		this.classYear = classYear;
	}

	public List<SubjectEntity> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectEntity> subjects) {
		this.subjects = subjects;
	}

}
