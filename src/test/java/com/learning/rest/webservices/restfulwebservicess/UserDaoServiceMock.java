package com.learning.rest.webservices.restfulwebservicess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.learning.rest.webservices.restfulwebservicess.user.UserDaoService;
import com.learning.rest.webservices.restfulwebservicess.user.UserInfo;
import com.learning.rest.webservices.restfulwebservicess.user.UserResource;

class UserDaoServiceMock {

	/*	@Mock
	private	UserDaoService u ;
		
		@InjectMocks
		private UserResource ur;*/

	@Test
	void postTest() {
		//fail("Not yet implemented");
		UserDaoService u = mock(UserDaoService.class);
		//UserResource u1 = new UserResource(u);
		UserInfo et = new UserInfo(6, "nick", "jublie hills");
		UserResource u1 = new UserResource(u);
		when(u1.createResource(et)).thenReturn(et);
		assertEquals(6, et.getId());
	}

	/*@Test
	void deleteTest() {
		//fail("Not yet implemented");
		//UserDaoService u = mock(UserDaoService.class);
		//UserResource u1 = new UserResource(u);
		//UserInfo et = new UserInfo(6, "nick", "jublie hills");
		//UserResource u1 = new UserResource(u);
		when(u1.createResource(et)).thenReturn(et);
		assertEquals(6, et.getId());
	}*/

}
