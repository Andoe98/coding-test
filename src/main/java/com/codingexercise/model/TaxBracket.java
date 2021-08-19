package com.codingexercise.model;

public class TaxBracket {
	private int threshold;
	private int cumulative;
	private double rate;
	
	public TaxBracket(int threshold, int cumulative, double rate) {
		setThreshold(threshold);
		setCumulative(cumulative);
		setRate(rate);
	}
	
	public int getThreshold() {
		return threshold;
	}
	
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	
	public int getCumulative() {
		return cumulative;
	}
	
	public void setCumulative(int cumulative) {
		this.cumulative = cumulative;
	}
	
	public double getRate() {
		return rate;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public int computeTaxableIncome(int salary) {
		return (int) Math.round(((cumulative + (salary - threshold) * rate)) / 12);
	}
}
