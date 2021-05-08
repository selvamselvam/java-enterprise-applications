/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.observer;

/**
 * Observer pattern to display in Console 
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
public abstract class Observer {
	protected Subject subj; 
	public abstract void update();
}
