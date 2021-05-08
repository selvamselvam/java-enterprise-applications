/*
 * 
 * Copyright notice
 * 
 */
package com.amortization;

import java.io.IOException;
import java.util.List;

import com.amortization.builder.Amortization;
import com.amortization.observer.ConsoleObserver;
import com.amortization.observer.Subject;
import com.amortization.readwrite.chainofres.Chain;
import com.amortization.readwrite.chainofres.ChainConsole;
import com.amortization.readwrite.chainofres.ChainSystemOut;
import com.amortization.readwrite.chainofres.ReadRequest;
import com.amortization.strategy.AmortizationStrategy;
import com.amortization.strategy.AmortizationStrategyNew;
import com.amortization.strategy.Context;
import com.amortization.util.Utility;

/**
 * AmortizationScheduleEngine uses to invoke all the AmortizationSchedule activities. *
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
public class AmortizationScheduleEngine {
	
	public static void main(String[] args) {
		String[] userPrompts = {
				"Please enter the amount you would like to borrow: ",
				"Please enter the annual percentage rate used to repay the loan: ",
				"Please enter the term, in years, over which the loan is repaid: "
		};
		
		UserPromptsType[] types = { UserPromptsType.AMOUNT, UserPromptsType.ANNUALPER,UserPromptsType.TERMSYEARS};
		
		String line = "";
		double amount = 0;  
		double apr = 0; 
		int years = 0;

		// Initialize chain-of-responsibility pattern giving more than one object a chance to handle
		// the request. It uses Console and SystemOut
		Chain h1 = new ChainConsole();
		Chain h2 = new ChainSystemOut();
		h1.setNext(h2);
		
		
		
		for (int i = 0; i< userPrompts.length; ) {
			String userPrompt = userPrompts[i];
			UserPromptsType type = types[i];
			boolean isValidValue = true;
			
			try {
				line = h1.processRead(new ReadRequest(userPrompt));
				
				switch(type){
				case AMOUNT:
					amount = Double.parseDouble(line);
					if( Utility.isValidValue(UserPromptsType.AMOUNT, amount) == false)
						isValidValue = false;
					break;
				case ANNUALPER:
					apr = Double.parseDouble(line);
					if( Utility.isValidValue(UserPromptsType.ANNUALPER, apr) == false)
						isValidValue = false;
					break;
				case TERMSYEARS:
					years = (int) Double.parseDouble(line);
					if( Utility.isValidValue(UserPromptsType.TERMSYEARS, years) == false)
						isValidValue = false;
					break;
				}
				
			} catch (IOException e) {
				Utility.PrintString("An IOException was encountered. Terminating program.\n");
				isValidValue = false;
			}catch (NumberFormatException e){
				Utility.PrintString("An invalid value was entered.\n");
				isValidValue = false;
			}
			
			if (isValidValue) {
				i++;
			} else {
				Utility.PrintString("An invalid value was entered.\n");
			}
			
		}
		
		// Initialize Strategy pattern which can change the algorithm 
		Context context = new Context(new AmortizationStrategy());
		//Context context = new Context(new AmortizationStrategyNew());
        List<Amortization> list  =  context.executeStrategy(amount , apr,(int) years);
	      

        // Initialize Observer for displaying the output.
        Subject sub = new Subject();
        new ConsoleObserver( sub );
        sub.setState( list );
			 
			 
	}

}
