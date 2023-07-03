package com.learning.rest.webservices.restfulwebservicess.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filter")
	public MappingJacksonValue filtering() {
		Filter f = new Filter("v1", "v2", "v3");
		MappingJacksonValue m = new MappingJacksonValue(f);
		SimpleBeanPropertyFilter s = SimpleBeanPropertyFilter.filterOutAllExcept("f1", "f3");
		FilterProvider fp = new SimpleFilterProvider().addFilter("SomeFilter", s);

		m.setFilters(fp);
		return m;
	}

	@GetMapping("/filter_list")
	public List<Filter> filteringAsList() {
		return Arrays.asList(new Filter("v1", "v2", "v3"), new Filter("v4", "v5", "v6"));
	}

}
