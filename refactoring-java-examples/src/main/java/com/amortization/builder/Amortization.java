/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.builder;

/**
 * Amortization builder pattern to build the array of Amortization from Strategy and 
 * display in Observer
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
public class Amortization {
	
	private int paymentNumber;
	double curMonthlyPaymentAmount;
	double curMonthlyInterest;
	double curBalance;
	double totalPayments;
	double  totalInterestPaid;
	
	/**
	 * @return the curMonthlyPaymentAmount
	 */
	public double getCurMonthlyPaymentAmount() {
		return curMonthlyPaymentAmount;
	}

	/**
	 * @param curMonthlyPaymentAmount the curMonthlyPaymentAmount to set
	 */
	public void setCurMonthlyPaymentAmount(double curMonthlyPaymentAmount) {
		this.curMonthlyPaymentAmount = curMonthlyPaymentAmount;
	}

	/**
	 * @return the curMonthlyInterest
	 */
	public double getCurMonthlyInterest() {
		return curMonthlyInterest;
	}

	/**
	 * @param curMonthlyInterest the curMonthlyInterest to set
	 */
	public void setCurMonthlyInterest(double curMonthlyInterest) {
		this.curMonthlyInterest = curMonthlyInterest;
	}

	/**
	 * @return the curBalance
	 */
	public double getCurBalance() {
		return curBalance;
	}

	/**
	 * @param curBalance the curBalance to set
	 */
	public void setCurBalance(double curBalance) {
		this.curBalance = curBalance;
	}

	/**
	 * @return the totalPayments
	 */
	public double getTotalPayments() {
		return totalPayments;
	}

	/**
	 * @param totalPayments the totalPayments to set
	 */
	public void setTotalPayments(double totalPayments) {
		this.totalPayments = totalPayments;
	}

	/**
	 * @return the totalInterestPaid
	 */
	public double getTotalInterestPaid() {
		return totalInterestPaid;
	}

	/**
	 * @param totalInterestPaid the totalInterestPaid to set
	 */
	public void setTotalInterestPaid(double totalInterestPaid) {
		this.totalInterestPaid = totalInterestPaid;
	}


	
	 
	// Builder Pattern from  Effective java for building the Amortization objects
	public static class Builder {
		private int paymentNumber;
		private double curMonthlyPaymentAmount;
		private double curMonthlyInterest;
		private double curBalance;
		private double totalPayments;
		private double  totalInterestPaid;
		
		public Builder(long l) {
		      this.paymentNumber = (int) l;
		 }

		 public Builder curMonthlyPaymentAmount(double value) {
			 curMonthlyPaymentAmount = value;
		      return this;
		  }
		    
		 public Builder curMonthlyInterest(double value) {
			 curMonthlyInterest = value;
		      return this;
		  }
		 
		 public Builder curBalance(double value) {
			 curBalance = value;
		      return this;
		  }
		 
		 public Builder totalPayments(double value) {
			 totalPayments = value;
		      return this;
		  }
		 
		 public Builder totalInterestPaid(double value) {
			 totalInterestPaid = value;
		      return this;
		  }
		 
		 public Amortization build() {
		      return new Amortization(this);
		    }
		 
	}
	
	private Amortization(Builder builder) {
		setPaymentNumber(builder.paymentNumber);
		curMonthlyPaymentAmount = builder.curMonthlyPaymentAmount;
		curMonthlyInterest = builder.curMonthlyInterest;
		curBalance = builder.curBalance;
		totalPayments = builder.totalPayments;
		totalInterestPaid = builder.totalInterestPaid;
	  }

	/**
	 * @return the paymentNumber
	 */
	public int getPaymentNumber() {
		return paymentNumber;
	}

	/**
	 * @param paymentNumber the paymentNumber to set
	 */
	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	
}
