/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.observer;

import java.util.List;

import com.amortization.builder.Amortization;
import com.amortization.util.Utility;

/**
 * Observer pattern to display in Console 
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
public class ConsoleObserver extends Observer {

	@Override
	public void update() {
		String formatString = "%1$-20s%2$-20s%3$-20s%4$s,%5$s,%6$s\n";
		Utility.PrintString(formatString,
				"PaymentNumber", "PaymentAmount", "PaymentInterest",
				"CurrentBalance", "TotalPayments", "TotalInterestPaid");
		
		// output is in dollars
		formatString = "%1$-20d%2$-20.2f%3$-20.2f%4$.2f,%5$.2f,%6$.2f\n";
				
		List<Amortization> list = subj.getState();
		
		for(Amortization amo : list){
			
		// output is in dollars
			Utility.PrintString(formatString, amo.getPaymentNumber(),
				amo.getCurMonthlyPaymentAmount(),
				amo.getCurMonthlyInterest(),
				amo.getCurBalance(),
				amo.getTotalPayments(),
				amo.getTotalInterestPaid());
		}

	}
	
	/**
	 * Set the Subject to ConsoleObserver
	 */
	public ConsoleObserver( Subject s ) {
		subj = s;
		subj.attach( this );
	}
}
