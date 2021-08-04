package com.codingexercise.model;

public class Employee {
	
	private String firstName;
	private String lastName;
	private int annualSalary;
	private int paymentMonth;
	private double superRate;

	public Employee(String firstName, String lastName, int annualSalary, int paymentMonth, double superRate) {
		setFirstName(firstName);
		setLastName(lastName);
		setAnnualSalary(annualSalary);
		setPaymentMonth(paymentMonth);
		setSuperRate(superRate);
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
	
	public int getAnnualSalary() {
		return annualSalary;
	}
	
	public void setAnnualSalary(int annualSalary) {
		if (annualSalary > 0)
			this.annualSalary = annualSalary;
	}
	
	public int getPaymentMonth() {
		return paymentMonth;
	}
	
	public void setPaymentMonth(int paymentMonth) {
		if (paymentMonth >= 0 && paymentMonth < 12)
			this.paymentMonth = paymentMonth;
	}
	
	public double getSuperRate() {
		return superRate;
	}
	
	public void setSuperRate(double superRate) {
		if (superRate >= 0 && superRate <= 0.5)
			this.superRate = superRate;
	}
	
}
