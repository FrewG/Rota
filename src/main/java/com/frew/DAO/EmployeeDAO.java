package com.frew.DAO;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.frew.Entity.Employee;

@Repository
public class EmployeeDAO {

	private static Map<Integer, Employee> employees;

	public static Map<Integer, Employee> getEmployees() {
		return employees;
	}

	public static void setEmployees(Map<Integer, Employee> employees) {
		EmployeeDAO.employees = employees;
	}
	
}