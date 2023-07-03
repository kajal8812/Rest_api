package com.learning.rest.webservices.restfulwebservicess.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

@Entity(name = "userdetails")
public class UserInfo {

	public UserInfo() {
		super();
	}

	@Id
	@GeneratedValue
	private Integer id;

	//@JsonProperty("User_name") //In json response it displays as user_name
	@Size(min = 2, message = "Enter atleast 2 characters")
	private String name;
	private String location;

	//One user can have many posts
	@OneToMany(mappedBy = "u")
	@JsonIgnore
	private List<Post> ps;

	public void setPs(List<Post> ps) {
		this.ps = ps;
	}

	public List<Post> getPs() {
		return ps;
	}

	public UserInfo(Integer id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

}
