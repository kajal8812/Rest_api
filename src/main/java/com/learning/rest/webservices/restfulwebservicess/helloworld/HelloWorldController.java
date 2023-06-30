package com.learning.rest.webservices.restfulwebservicess.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello")
	public String helloWorld() {
		return "hiii";
	}

	@GetMapping(path = "/hellobean")
	public HelloWorldBean helloWorldbean() {
		return new HelloWorldBean("hello");
	}

	@GetMapping(path = "/hellobean/path-variable/{name}")
	public HelloWorldBean helloWorldbeanPathVar(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello, %s", name));
	}

}
