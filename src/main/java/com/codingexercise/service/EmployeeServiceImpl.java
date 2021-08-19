package com.codingexercise.service;

import java.util.Calendar;
import java.util.Locale;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.codingexercise.model.Employee;
import com.codingexercise.model.MonthlyPayslip;
import com.codingexercise.model.TaxBracket;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	//Tax bracket must be added in descending order
	private final static TaxBracket[] taxBracket = {
			new TaxBracket(180000, 54232, 0.45),
			new TaxBracket(87000, 19822, 0.37),
			new TaxBracket(37000, 3572, 0.325),
			new TaxBracket(18200, 0, 0.19)
	};
	
	
	@Override
	public MonthlyPayslip calculateMonthlyPayslip(Employee employee) {
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
		
		TaxBracket bracket = Stream.of(taxBracket).filter(t -> t.getThreshold() < salary).findFirst().orElse(null);
		
		if (bracket == null) return 0;
		return bracket.computeTaxableIncome(salary);
	}
	
}
