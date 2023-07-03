package com.learning.rest.webservices.restfulwebservicess.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	//uri versioning
	@GetMapping("/v1/person")
	public PersonV1 getData() {
		return new PersonV1("Allensssssss");
	}

	//uri versioning
	@GetMapping("/v2/person")
	public PersonV2 getDataForV2() {
		return new PersonV2(new Name("John", "David"));
	}

	//requestparam versioning
	//localhost:8091/person?version=1   && amazon
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getDataForV1RequestParm() {
		return new PersonV1("Allen");
	}

	//requestparam versioning
	//localhost:8091/person?version=2 && amazon
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getDataForV2RequestParm() {
		return new PersonV2(new Name("John", "David"));
	}

	//header versioning
	//localhost:8091/person/header and enter key and value as x-api-version and 1   && microsoft
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getDataForV1RequestParmHeader() {
		return new PersonV1("Allens");
	}

	//header versioning
	//localhost:8091/person/header and enter key and value as x-api-version and 2   && microsoft
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getDataForV2RequestParmHeader() {
		return new PersonV2(new Name("John", "David"));
	}

}
