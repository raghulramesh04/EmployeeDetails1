package com.example.employee.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.employee.entity.EmployeeEntity;


public class EmployeeDTO {
	
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String designation;
	private String unit;
	
	
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public static List<EmployeeDTO> valueOf(List<EmployeeEntity> entity) {
		List<EmployeeDTO> employeeDTOList= new ArrayList<EmployeeDTO>();
		for(EmployeeEntity employee: entity) {
			EmployeeDTO employeeDTO= new EmployeeDTO();
			employeeDTO.setEmployeeId(employee.getEmployeeId());
			employeeDTO.setFirstName(employee.getFirstName());
			employeeDTO.setLastName(employee.getLastName());
			employeeDTO.setEmail(employee.getEmail());
			employeeDTO.setPhoneNumber(employee.getPhoneNumber());
			employeeDTO.setDesignation(employee.getDesignation());
			employeeDTO.setUnit(employee.getUnit());
			employeeDTOList.add(employeeDTO);
		}
		return employeeDTOList;
	}
	public EmployeeEntity createEntity() {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmployeeId(this.employeeId);
		entity.setFirstName(this.firstName);
		entity.setLastName(this.lastName);
		entity.setEmail(this.email);
		entity.setPhoneNumber(this.phoneNumber);
		entity.setDesignation(this.designation);
		entity.setUnit(this.unit);
		return entity;
	}
	
	
	

}
