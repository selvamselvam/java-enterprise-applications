/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.readwrite.chainofres;

import java.io.IOException;

/**
 * Chain of responsibility pattern Chain interface  
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
public interface Chain {
	public abstract void setNext(Chain nextInChain);
	public abstract void processDisplay(DisplayRequest request);
	public abstract String processRead(ReadRequest request) throws IOException;
}
