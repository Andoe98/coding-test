package com.codingexercise.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class Employee {
	
	@NotEmpty(message = "First name must not be empty")
	private String firstName;
	
	@NotEmpty(message = "Last name must not be empty")
	private String lastName;
	
	@Positive(message = "Annual salary must be greater than 0")
	private int annualSalary;
	
	@Min(value = 0, message = "Payment month must be between 0 and 11")
	@Max(value = 11, message = "Payment month must be between 0 and 11")
	private int paymentMonth;
	
	@Min(value = 0, message = "Super rate must be between 0 and 0.5")
	@DecimalMax(value = "0.5", message = "Super rate must be between 0 and 0.5")
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
		this.annualSalary = annualSalary;
	}
	
	public int getPaymentMonth() {
		return paymentMonth;
	}
	
	public void setPaymentMonth(int paymentMonth) {
		this.paymentMonth = paymentMonth;
	}
	
	public double getSuperRate() {
		return superRate;
	}
	
	public void setSuperRate(double superRate) {
		this.superRate = superRate;
	}
	
}
