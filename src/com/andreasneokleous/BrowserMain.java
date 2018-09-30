/**
 * BrowserMain.java
 */
package com.andreasneokleous;

/**
 * The Main Method that runs the application
 * @author Andreas Neokleous
 *
 */
public class BrowserMain {
	public static void main(String[] args) {

		BrowserView appView = new BrowserView();
		
		BrowserModel appModel = new BrowserModel();
		
		@SuppressWarnings("unused")
		BrowserController appController = new BrowserController(appModel,appView);
		
		appView.setVisible(true);
	}

}
