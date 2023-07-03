package com.learning.rest.webservices.restfulwebservicess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.rest.webservices.restfulwebservicess.user.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {

}
