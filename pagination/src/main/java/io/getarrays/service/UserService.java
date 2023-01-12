package io.getarrays.service;

import org.springframework.data.domain.Page;

import io.getarrays.domain.Employee;


public interface UserService {
	Page<Employee> getUsers(String name,int page,int size);

}
