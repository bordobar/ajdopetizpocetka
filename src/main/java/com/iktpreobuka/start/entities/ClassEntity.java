package com.iktpreobuka.start.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iktpreobuka.start.enumerations.ClassYear;
import com.iktpreobuka.start.enumerations.EClass;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClassEntity extends ClassYearEntity{
	private EClass eclass;
	
	@JsonIgnore
	@OneToMany(mappedBy = "classEntity", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<TeachingEntity> teachings = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "classEntity", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<StudentEntity> students = new ArrayList<>();

	public ClassEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassEntity(Integer classYearId, ClassYear classYear, List<SubjectEntity> subjects) {
		super(classYearId, classYear, subjects);
		// TODO Auto-generated constructor stub
	}

	public ClassEntity(EClass eclass, List<TeachingEntity> teachings, List<StudentEntity> students) {
		super();
		this.eclass = eclass;
		this.teachings = teachings;
		this.students = students;
	}

	public EClass getEclass() {
		return eclass;
	}

	public void setEclass(EClass eclass) {
		this.eclass = eclass;
	}

	public List<TeachingEntity> getTeachings() {
		return teachings;
	}

	public void setTeachings(List<TeachingEntity> teachings) {
		this.teachings = teachings;
	}

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}
	
	
}
