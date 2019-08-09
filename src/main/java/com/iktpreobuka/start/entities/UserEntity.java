package com.iktpreobuka.start.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance(strategy = InheritanceType.JOINED) 
@Table(name="User")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	private String firstName;
	private String lastName;
	private String userName;
	@Column (name ="password")
	@JsonIgnore
	private String password;
	@Column(name="email")
	private String email;
	@OneToOne(cascade =CascadeType.REFRESH,fetch =FetchType.LAZY)
	@JoinColumn(name ="role")
	private RoleEntity role;
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserEntity(String firstName, String lastName, String userName, String password, String email,
			RoleEntity role) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public RoleEntity getRole() {
		return role;
	}
	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
}
