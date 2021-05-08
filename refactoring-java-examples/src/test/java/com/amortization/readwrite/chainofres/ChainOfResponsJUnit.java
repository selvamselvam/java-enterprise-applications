/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.readwrite.chainofres;

/**
 * ChainOfResponsJUnit JUnit test  
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ChainOfResponsJUnit {
	Chain h1 = null;
	Chain h2 = null;
	
	@Before
	public void setUp() throws Exception {
		h1 = new ChainConsole();
		h2 = new ChainSystemOut();
		h1.setNext(h2);
	}

	@Test
	public void test() {
		String line = null;
		try {
			 line = h1.processRead(new ReadRequest("Enter Value"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		 assertNotNull(line);
	}

}
