package com.learning.rest.webservices.restfulwebservicess.user;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	static List<UserInfo> list = new ArrayList<UserInfo>();
	static int c = 0;

	static {
		list.add(new UserInfo(++c, "Allen", "London"));
		list.add(new UserInfo(++c, "Smith", "Canada"));
		list.add(new UserInfo(++c, "Jones", "Switzerland"));
	}

	public List findAll() {
		return list;
	}

	public UserInfo retreieveId(int id) {

		Predicate<? super UserInfo> predicate = user -> user.getId().equals(id);
		return list.stream().filter(predicate).findFirst().get();

	}

	public UserInfo save(UserInfo u) {

		u.setId(++c);
		list.add(u);
		return u;

	}

	public void deleteById(int id) {

		Predicate<? super UserInfo> predicate = user -> user.getId().equals(id);
		//return list.stream().filter(predicate).findFirst().get();
		list.removeIf(predicate);
	}

}
