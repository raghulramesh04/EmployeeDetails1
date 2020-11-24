package com.example.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employees")
public class EmployeeEntity {
	@Id
	@Column(name="EMPLOYEE_ID")
	private String employeeId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PHONE_NUMBER")
	private String PhoneNumber;
	@Column(name="DESIGNATION")
	private String designation;
	@Column(name="UNIT")
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
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
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
	

}
