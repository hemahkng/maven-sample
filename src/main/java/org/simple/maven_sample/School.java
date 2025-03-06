package org.simple.maven_sample;

import jakarta.persistence.*;

@Entity
@Table(name = "schools")
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private Long code;
	private String location;
	private String state;
	private String country;

	// Default constructor is required by JPA
	public School() {}

	// Constructor to quickly create a School object
	public School(String name, Long code, String location, String state, String country) {
		this.name = name;
		this.code = code;
		this.location = location;
		this.state = state;
		this.country = country;
	}

	// Getters and Setters for the fields
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
