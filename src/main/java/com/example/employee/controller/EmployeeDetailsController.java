package com.example.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping(value="/")
public class EmployeeDetailsController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	Environment environmnet;
	
	@GetMapping(value="/employees")
	public List<EmployeeDTO> getEmployees(){
		logger.info("Employees Details Request ");
		return employeeService.getEmployees();
	}
	
	
	@PostMapping(value="/addemployee")
	public String addEmployee(@RequestBody EmployeeDTO employeeDTO ) throws Exception {
		try {
		logger.info("Adding new Employee {}", employeeDTO);
		employeeService.addEmployee(employeeDTO);
		return environmnet.getProperty("EmployeeAddedSuccessfully");
		}
		catch(Exception e) {
			return environmnet.getProperty(e.getMessage());
		}
	}
	
	@PutMapping(value="/updatePhoneNo/{employeeId}/{phoneNumber}")
	public String updatePhoneNumber(@PathVariable String phoneNumber, @PathVariable String employeeId) {
		try {
		logger.info("Request to Update PhoneNumber{}", phoneNumber);
		employeeService.updatePhoneNumber(phoneNumber, employeeId);
		return environmnet.getProperty("PhoneNumberUpdated");
		}catch(Exception e) {
			return environmnet.getProperty(e.getMessage());
		}
	}
	@DeleteMapping(value="/delete/{employeeId}")
	public String deleteEmployee(@PathVariable String employeeId) {
		try {
		logger.info("Request to delete Employee{}", employeeId);
		employeeService.deleteEmployee(employeeId);
			return environmnet.getProperty("DeletionSuccessful");
		}
		catch(Exception e){
			return environmnet.getProperty(e.getMessage());
		}
	}

}
