package com.codingexercise.service;

import org.springframework.stereotype.Service;

import com.codingexercise.model.Employee;
import com.codingexercise.model.MonthlyPayslip;

//@Component
@Service
public interface EmployeeService {
	
	public MonthlyPayslip calculateMonthlyPayslip(Employee employee); 
	
}
