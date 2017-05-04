package com.frew.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.frew.Entity.Employee;
import com.frew.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	public Object findAll(){
        return employeeRepository.findAll();
    }
	
	public Employee findById(Long id) {
		return employeeRepository.findOne(id);
	}
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void delete(Employee employee){
		employeeRepository.delete(employee);
		return;
	}
	
	public Employee findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
