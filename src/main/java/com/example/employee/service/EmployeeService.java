package com.example.employee.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.entity.EmployeeEntity;
import com.example.employee.repository.EmployeeRepository;
@Service
public class EmployeeService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<EmployeeDTO> getEmployees() {
		logger.info("Employees Details Request ");
		List<EmployeeDTO> employeeDTO=null;
		List<EmployeeEntity> entity= employeeRepository.findAll(); 
		if(!(entity.isEmpty())) {
			employeeDTO= EmployeeDTO.valueOf(entity);
		}
		return employeeDTO;
	}

	public void addEmployee(EmployeeDTO employeeDTO) throws Exception{
		logger.info("Adding new Employee {}", employeeDTO);
		String Id= employeeDTO.getEmployeeId();
		if(employeeRepository.findById(Id).isPresent()) {
			throw new Exception("EmployeeAlreadyPresent");
		}else {
		EmployeeEntity entity= employeeDTO.createEntity();
		employeeRepository.save(entity);
		}
	}

	public void updatePhoneNumber(String phoneNumber, String Id) {
		logger.info("Request to Update PhoneNumber{}", Id);
		Optional<EmployeeEntity> entity= employeeRepository.findById(Id);
		if(entity.isPresent()) {
			EmployeeEntity employee= entity.get();
			employee.setPhoneNumber(phoneNumber);
			employeeRepository.save(employee);
		}
	}

	public void deleteEmployee(String employeeId) throws Exception {
		if(employeeRepository.findById(employeeId).isPresent()) {
			employeeRepository.deleteById(employeeId);
		}else {
			throw new Exception("DataUnavailable");
		}
		
	}

}
