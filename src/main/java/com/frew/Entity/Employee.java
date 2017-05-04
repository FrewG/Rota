package com.frew.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;	
	
	public Employee(Long id) {
		this.id = id;
	}
	
	@Column(name = "fullName")
    private String fullName;
	
	@Column(name = "email", nullable = false, unique = true)
    private String email;
	
	@Column(name = "worksOn")
    private String worksOn;
	
	
	public Employee(Long id, String fullName, String email, String worksOn) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.worksOn = worksOn;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public String getWorksOn() {
		return worksOn;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setWorksOn(String worksOn) {
		this.worksOn = worksOn;
	}
	
}
