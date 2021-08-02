package com.codingexercise.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.codingexercise.model.Employee;
import com.codingexercise.model.MonthlyPayslip;

public class EmployeeServiceTests {
	
	private Employee employee = new Employee (	
			"Monica",
			"Tan",
			60050,
			2,
			0.09
		);
	
	private MonthlyPayslip monthlyPayslip = new MonthlyPayslip (
			employee,
			"01 March",
			"31 March",
			5004,
			922,
			450,
			4082
		);
	
	EmployeeService employeeService = new EmployeeService();
	
	
	
	@Test
	void testTaxableIncome() {
		int result = employeeService.calculateTaxableIncome(employee.getAnnualSalary());
		
		int expected = 922;
		
		assertThat(result).isEqualTo(expected);
	}

	@Test
	void testGetMonthlyPaySlip() {
		MonthlyPayslip result = employeeService.getMonthlyPaySlip(employee);
		
		assertThat(result).usingRecursiveComparison().isEqualTo(monthlyPayslip);
			
	}
	
}
