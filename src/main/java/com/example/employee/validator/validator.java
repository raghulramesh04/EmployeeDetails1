package com.example.employee.validator;

import com.example.employee.dto.EmployeeDTO;

public class validator {
	
	public static void validateEmployee(EmployeeDTO employee) throws Exception{
		if(!(validateEmail(employee.getEmail()))) {
			throw new Exception("InvalidEmail");
		}
		else if(!(validatePhoneNo(employee.getPhoneNumber()))){
			throw new Exception("InvalidPhoneNumber");
		}
	}

	public static boolean validatePhoneNo(String phoneNumber) {
		
		if(phoneNumber.matches("^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$")){
			return true;
		}else {
			return false;
		}
	}

	public static boolean validateEmail(String email) {
		if(email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
				"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			return true;
		}else {
			return false;
		}
	}
	
}
