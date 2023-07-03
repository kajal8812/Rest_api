package com.learning.rest.webservices.restfulwebservicess.versioning;

public class PersonV2 {

	private Name name;

	/*public PersonV2(Name name) {
		super();
		this.name = name;
	}*/

	public PersonV2(Name name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}
}
