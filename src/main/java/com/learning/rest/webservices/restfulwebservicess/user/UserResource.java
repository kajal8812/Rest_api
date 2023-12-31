package com.learning.rest.webservices.restfulwebservicess.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

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
	public EntityModel<UserInfo> retrieveId(@PathVariable int id) {
		UserInfo u = s.retreieveId(id);

		EntityModel<UserInfo> em = EntityModel.of(u);

		WebMvcLinkBuilder l = linkTo(methodOn(this.getClass()).retrieveAll());
		em.add(l.withRel("all-users"));
		return em;
	}

	@PostMapping("/users")
	public UserInfo createResource(@Valid @RequestBody UserInfo user) {
		return s.save(user);
		//return null;

	}

	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable int id) {
		s.deleteById(id);
	}

}
