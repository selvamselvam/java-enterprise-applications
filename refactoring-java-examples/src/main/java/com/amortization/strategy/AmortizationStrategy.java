/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.strategy;

import java.util.ArrayList;
import java.util.List;

import com.amortization.builder.Amortization;
import com.amortization.util.Utility;

/**
 * Strategy pattern AmortizationStrategy class which implements Strategy 
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
public class AmortizationStrategy implements Strategy {

	private long monthlyPaymentAmount = 0;	// in cents
	
	private long amountBorrowed = 0;		// in cents
	private double apr = 0d;
	private int initialTermMonths = 0;
	
	private double monthlyInterest = 0d;
	
	/**
	 * helper Method to calculate the calculateMonthlyPayment
	 * @return the MonthlyPayment
	 */
	private long calculateMonthlyPayment() {
		// M = P * (J / (1 - (Math.pow(1/(1 + J), N))));
		//
		// Where:
		// P = Principal
		// I = Interest
		// J = Monthly Interest in decimal form:  I / (12 * 100)
		// N = Number of months of loan
		// M = Monthly Payment Amount
		// 
		
		// calculate J
		monthlyInterest = apr / Utility.MONTHLY_INTEREST_DIVISOR;
		
		// this is 1 / (1 + J)
		double tmp = Math.pow(1d + monthlyInterest, -1);
		
		// this is Math.pow(1/(1 + J), N)
		tmp = Math.pow(tmp, initialTermMonths);
		
		// this is 1 / (1 - (Math.pow(1/(1 + J), N))))
		tmp = Math.pow(1d - tmp, -1);

		// M = P * (J / (1 - (Math.pow(1/(1 + J), N))));
		double rc = amountBorrowed * monthlyInterest * tmp;
		
		return Math.round(rc);
	}
	
	/**
	 *  Method to calculate the AmortizationStrategy
	 * @param amount amount to use Amortization
	 * @param interestRate interest rate to use Amortization
	 * @param years years use Amortization
	 * @return the MonthlyPayment
	 * @throws IllegalArgumentException when the argument not valid
	 */
	@Override
	public List<Amortization> execute(double amount, double interestRate, int years) throws IllegalArgumentException {

		if ((Utility.isValidBorrowAmount(amount) == false) ||
				(Utility.isValidAPRValue(interestRate) == false) ||
				(Utility.isValidTerm(years) == false)) {
			throw new IllegalArgumentException();
		}
		amountBorrowed = Math.round(amount * 100);
		apr = interestRate;
		initialTermMonths = years * 12;
		
		monthlyPaymentAmount = calculateMonthlyPayment();
		
		
		// the following shouldn't happen with the available valid ranges
		// for borrow amount, apr, and term; however, without range validation,
		// monthlyPaymentAmount as calculated by calculateMonthlyPayment()
		// may yield incorrect values with extreme input values
		if (monthlyPaymentAmount > amountBorrowed) {
			throw new IllegalArgumentException();
		}
		
		
		List<Amortization> list = new ArrayList<Amortization>();
		// 
		// To create the amortization table, create a loop in your program and follow these steps:
		// 1.      Calculate H = P x J, this is your current monthly interest
		// 2.      Calculate C = M - H, this is your monthly payment minus your monthly interest, so it is the amount of principal you pay for that month
		// 3.      Calculate Q = P - C, this is the new balance of your principal of your loan.
		// 4.      Set P equal to Q and go back to Step 1: You thusly loop around until the value Q (and hence P) goes to zero.
		// 
		long balance = amountBorrowed;
		int paymentNumber = 0;
		long totalPayments = 0;
		long totalInterestPaid = 0;
		
		Amortization amo = new Amortization.Builder(paymentNumber++)
								.curMonthlyPaymentAmount(0d)
								.curMonthlyInterest(0d)
								.curBalance(((double) amountBorrowed) / 100d)
								.totalPayments(((double) totalPayments) / 100d)
								.totalInterestPaid(((double) totalInterestPaid) / 100d)
								.build();
		list.add(amo);
		
		final int maxNumberOfPayments = initialTermMonths + 1;
		while ((balance > 0) && (paymentNumber <= maxNumberOfPayments)) {
			// Calculate H = P x J, this is your current monthly interest
			long curMonthlyInterest = Math.round(((double) balance) * monthlyInterest);

			// the amount required to payoff the loan
			long curPayoffAmount = balance + curMonthlyInterest;
			
			// the amount to payoff the remaining balance may be less than the calculated monthlyPaymentAmount
			long curMonthlyPaymentAmount = Math.min(monthlyPaymentAmount, curPayoffAmount);
			
			// it's possible that the calculated monthlyPaymentAmount is 0,
			// or the monthly payment only covers the interest payment - i.e. no principal
			// so the last payment needs to payoff the loan
			if ((paymentNumber == maxNumberOfPayments) &&
					((curMonthlyPaymentAmount == 0) || (curMonthlyPaymentAmount == curMonthlyInterest))) {
				curMonthlyPaymentAmount = curPayoffAmount;
			}
			
			// Calculate C = M - H, this is your monthly payment minus your monthly interest,
			// so it is the amount of principal you pay for that month
			long curMonthlyPrincipalPaid = curMonthlyPaymentAmount - curMonthlyInterest;
			
			// Calculate Q = P - C, this is the new balance of your principal of your loan.
			long curBalance = balance - curMonthlyPrincipalPaid;
			
			totalPayments += curMonthlyPaymentAmount;
			totalInterestPaid += curMonthlyInterest;
			
			list.add(new Amortization.Builder(paymentNumber++)
				.curMonthlyPaymentAmount(((double) curMonthlyPaymentAmount) / 100d)
				.curMonthlyInterest(((double) curMonthlyInterest) / 100d)
				.curBalance(((double) curBalance) / 100d)
				.totalPayments(((double) totalPayments) / 100d)
				.totalInterestPaid(((double) totalInterestPaid) / 100d)
				.build());
			
			// Set P equal to Q and go back to Step 1: You thusly loop around until the value Q (and hence P) goes to zero.
			balance = curBalance;
		}
				
		return list;
	}

}
