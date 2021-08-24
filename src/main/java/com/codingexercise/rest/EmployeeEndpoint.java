package com.codingexercise.rest;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingexercise.model.Employee;
import com.codingexercise.service.EmployeeService;

@Validated
@RestController
@RequestMapping("/employee")
public class EmployeeEndpoint {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "payslip", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> payslip(@RequestBody @NotEmpty(message = "Request cannot be empty list")  List<@Valid Employee> employees) {
		return ok().body(
				new ApiResponse(
					employees.stream().map(e -> employeeService.calculateMonthlyPayslip(e)),
					null
				)
			);
		
	}
	
	@GetMapping(value = "test")
	public String test() {
		String testing = "testing";
		return testing;
	}

}
