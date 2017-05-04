package com.frew.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frew.Entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
	public Employee findByEmail(String email);
	
}
