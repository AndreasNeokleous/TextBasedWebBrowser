/**
 * BrowserViewTest.java
 */
package com.andreasneokleous;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.andreasneokleous.BrowserView;

/**
 * This is the Test Class for the BrowserView.java
 * 
 * @author Andreas Neokleous
 *
 */
public class BrowserViewTest {

	@Test
	public void testSetGetAddress(){
		BrowserView view = new BrowserView();
		view.setAddress("test");
		assertEquals("test",view.getAddress());
	}
	
	@Test
	public void testSetGetLink(){
		BrowserView view = new BrowserView();
		view.setLink("test");
		assertEquals("test",view.getLink());
	}
}
