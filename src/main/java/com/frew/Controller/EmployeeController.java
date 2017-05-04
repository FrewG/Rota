package com.frew.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frew.Entity.Employee;
import com.frew.Service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)		
	@ResponseBody
	public Object index(){ 
		return employeeService.findAll();
	}
	
	  @RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)	  
	  @ResponseBody
	  public String create(@RequestBody Employee employee) {
		  String employeeId = "";
	    try {	    
	    	employeeService.save(employee);
	    	employeeId = String.valueOf(employee.getId());
	    }
	    catch (Exception ex) {
	      return "Error creating the employee: " + ex.toString();
	    }
	    return "Employee succesfully created with id = " + employeeId;
	  }
	  
		@RequestMapping("/delete/{id}")
		  @ResponseBody
		  public String delete(@PathVariable long id) {
		    try {
		    	Employee employee = employeeService.findById(id);
		    	employeeService.delete(employee);
		    }
		    catch (Exception ex) {
		      return "Error deleting the employee:" + ex.toString();
		    }
		    return "Employee succesfully deleted!";
		  }
		
		@RequestMapping("/getByEmail")
		  @ResponseBody
		  public String getByEmail(String email) {
		    String employeeId = "";
		    try {
		    	Employee employee = employeeService.findByEmail(email);
		        employeeId = String.valueOf(employee.getId());
		    }
		    catch (Exception ex) {
		      return "Employee not found";
		    }
		    return "The employee id is: " + employeeId;
		  }
		
		@RequestMapping("/update/{id}")
		  @ResponseBody
		  public String updateEmployee(@RequestBody Employee employee,@PathVariable Long id) {
			try {
		    	employee.setId(id);
		    	employeeService.save(employee);
		    }
		    catch (Exception ex) {
		      return "Error updating the employee: " + ex.toString();
		    }
		    return "Employee succesfully updated!";
		  }

	}
