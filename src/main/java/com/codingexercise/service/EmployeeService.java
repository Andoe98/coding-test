package com.codingexercise.service;

import java.util.Calendar;
import java.util.Locale;

import com.codingexercise.model.Employee;
import com.codingexercise.model.MonthlyPayslip;

public class EmployeeService {	
	public MonthlyPayslip getMonthlyPaySlip(Employee employee) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, employee.getPaymentMonth());
		String fromDate = "01 " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		String toDate = calendar.getActualMaximum(Calendar.DATE) + " " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		int grossIncome = employee.getAnnualSalary() / 12;
		int incomeTax = calculateTaxableIncome(employee.getAnnualSalary());
		int superannuation = (int) (grossIncome * employee.getSuperRate());
		int netIncome = grossIncome - incomeTax;
		
		return new MonthlyPayslip(employee, fromDate, toDate, grossIncome, incomeTax,
				superannuation, netIncome);
	}

	public int calculateTaxableIncome(int salary) {
		
		int incomeTax = 0;
		
		if (salary < 18200) {
			incomeTax = 0;
		}
		else if (salary > 18200 && salary < 37001) {
			incomeTax = (int) Math.round(((salary - 18200) * 0.19) / 12);
		}
		else if (salary > 37000 && salary < 87001) {
			incomeTax = (int) Math.round(((3572 + (salary - 37000) * 0.325)) / 12);
		}
		else if (salary > 87000 && salary < 180001) {
			incomeTax = (int) Math.round(((19822 + (salary - 87000) * 0.37)) / 12);
		} 
		else {
			incomeTax = (int) Math.round(((54232 + (salary - 180000) * 0.45)) / 12);
		}
		
		
		return incomeTax;
		
	
	}
}
