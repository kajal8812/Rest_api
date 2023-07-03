package com.learning.rest.webservices.restfulwebservicess.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.rest.webservices.restfulwebservicess.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

	private UserDaoService s;

	private UserRepository ur;

	public UserJpaResource(UserDaoService s, UserRepository ur) {
		this.s = s;
		this.ur = ur;
	}

	@GetMapping("/jpa/users")
	public List<UserInfo> retrieveAll() {
		return ur.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public EntityModel<UserInfo> retrieveId(@PathVariable int id) {
		Optional<UserInfo> u = ur.findById(id);

		//To get Links
		EntityModel<UserInfo> em = EntityModel.of(u.get());

		WebMvcLinkBuilder l = linkTo(methodOn(this.getClass()).retrieveAll());
		em.add(l.withRel("all-users"));
		return em;
	}

	@PostMapping("/jpa/users")
	public UserInfo createResource(@Valid @RequestBody UserInfo user) {
		return ur.save(user);
		//return null;

	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteById(@PathVariable int id) {
		ur.deleteById(id);
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsBasedOnId(@PathVariable int id) {
		Optional<UserInfo> u = ur.findById(id);

		return u.get().getPs();

	}

}
