package com.codingexercise.rest;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingexercise.model.Employee;
import com.codingexercise.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeEndpoint {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "payslip", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> payslip(@RequestBody List<Employee> employees) {
		return ok().body(new ApiResponse(employeeService.getAllMonthlyPayslip(employees),null));
		
	}
	
}
