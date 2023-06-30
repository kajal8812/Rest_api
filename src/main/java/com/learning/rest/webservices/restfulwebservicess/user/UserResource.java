package com.learning.rest.webservices.restfulwebservicess.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	private UserDaoService s;

	public UserResource(UserDaoService s) {
		this.s = s;

	}

	@GetMapping("/users")
	public List<UserInfo> retrieveAll() {
		return s.findAll();
	}

	@GetMapping("/users/{id}")
	public UserInfo retrieveId(@PathVariable int id) {
		return s.retreieveId(id);
	}

	@PostMapping("/users")
	public UserInfo createResource(@RequestBody UserInfo user) {
		return s.save(user);
		//return null;

	}
}
