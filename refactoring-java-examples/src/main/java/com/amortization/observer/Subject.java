/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.observer;

import java.util.List;

import com.amortization.builder.Amortization;

/**
 * Observer pattern Subject  
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
public class Subject {
	private Observer[] observers = new Observer[9];
	  private int totalObs = 0;
	  //private int state;
	  List<Amortization> state; 
	  public void attach( Observer o ) {
	    observers[totalObs++] = o;
	  }

	  public List<Amortization> getState() {
	    return state;
	  }
	  
	  public void setState( List<Amortization> in ) {
	    state = in;
	    notifySubject();
	  }

	  public void notifySubject() {
	    for (int i=0; i < totalObs; i++) {
	      observers[i].update();
	    }
	  }
}
