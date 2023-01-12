package io.getarrays.service.implementation;

import static org.springframework.data.domain.PageRequest.of;


import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import io.getarrays.domain.Employee;
import io.getarrays.repository.UserRepository;
import io.getarrays.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;

	@Override
	public Page<Employee> getUsers(String name,int page, int size) {
		log.info("Fetching users for page {} of size {} with name containing {}",page,size,name);
		Pageable pageable= PageRequest.of(page,size,Sort.by("id"));
		return userRepository.findByNameContainingAndStatus(name,"ACTIVE",pageable);
	}

}
