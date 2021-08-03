package com.codingexercise.model;

public class MonthlyPayslip {
	
	Employee employee;
	String fromDate;
	String toDate;
	int grossIncome;
	int incomeTax;
	int superAnnuation;
	int netIncome;
	
	public MonthlyPayslip(Employee employee, String fromDate, String toDate, int grossIncome, int incomeTax, int superannuation, int netIncome) {
		this.employee = employee;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.grossIncome = grossIncome;
		this.incomeTax = incomeTax;
		this.superAnnuation = superannuation;
		this.netIncome = netIncome;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String getFromDate() {
		return fromDate;
	}
	
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	public String getToDate() {
		return fromDate;
	}
	
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	public int getGrossIncome() {
		return grossIncome;
	}
	
	public void setGrossIncome(int grossIncome) {
		this.grossIncome = grossIncome;
	}
	
	public int getIncomeTax() {
		return incomeTax;
	}
	
	public void setIncomeTax(int incomeTax) {
		this.incomeTax = incomeTax;
	}
	
	public int getSuperAnnuation() {
		return superAnnuation;
	}
	
	public void setSuperAnnuation(int superAnnuation) {
		this.superAnnuation = superAnnuation;
	}
	
	public int getNetIncome() {
		return netIncome;
	}
	
	public void setNetIncome(int netIncome) {
		this.netIncome = netIncome;
	}
	
}
