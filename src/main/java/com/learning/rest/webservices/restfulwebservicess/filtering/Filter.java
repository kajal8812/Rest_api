package com.learning.rest.webservices.restfulwebservicess.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeFilter")
public class Filter {

	private String f1;

	//@JsonIgnore
	private String f2;
	private String f3;

	public Filter(String f1, String f2, String f3) {
		super();
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
	}

	public String getF1() {
		return f1;
	}

	public String getF2() {
		return f2;
	}

	public String getF3() {
		return f3;
	}

	@Override
	public String toString() {
		return "Filter [f1=" + f1 + ", f2=" + f2 + ", f3=" + f3 + "]";
	}

}
