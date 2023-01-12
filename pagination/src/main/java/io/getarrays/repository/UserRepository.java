package io.getarrays.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.getarrays.domain.Employee;


@Repository
public interface UserRepository extends JpaRepository<Employee, Long> {
	Page<Employee> findByNameContainingAndStatus(String name,String status,Pageable pageable);



}
