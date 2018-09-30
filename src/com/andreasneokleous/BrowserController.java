/**
 * BrowserController.java
 */
package com.andreasneokleous;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * 
 * This is the Controller. It interprets the user input, notifying the Model
 * and/or View to change as needed.
 * 
 * @author Andreas Neokleous
 *
 */
public class BrowserController {

	private BrowserModel appModel;
	private BrowserView appView;

	public BrowserController(BrowserModel model, BrowserView view) {
		super();
		this.appModel = model;
		this.appView = view;

		/**
		 * Notifying the View, when a Button is clicked, to execute the
		 * actionPerformed method of to appropriate button, that is located in
		 * the following inner classes.
		 */
		this.appView.addressBarButtonListener(new AddressListener());
		this.appView.linksButtonListener(new LinksListener());
		this.appView.browseButtonListener(new BrowseListener());
	}

	/**
	 * When the "Done" button is clicked, to the right of the Address Bar, the
	 * following class is executed.
	 */
	private class AddressListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String addressString = appView.getAddress();
			try {
				/**
				 * Checking if the address typed in the Address Bar, comes from
				 * a Local Web Server. If so, the appropriate BrowserModel object is
				 * created, with the help of the appropriate constructor.
				 */
				if (addressString.startsWith("http://localhost/")) {
					URL addressURL = new URL(addressString);
					appModel = new BrowserModel(addressURL);
					appView.setDisplay(appModel.builder(appModel));
				} else {
					/**
					 * Else, the address typed must come from a local file.
					 * After checking that the file exists and the address typed
					 * is not a directory the appropriate BrowserModel object is
					 * created.
					 */
					File htmlFile = new File(addressString);
					if (htmlFile.exists() && !htmlFile.isDirectory()) {
						appModel = new BrowserModel(htmlFile);
						appView.setDisplay(appModel.builder(appModel));
					}
				}
			} catch (MalformedURLException e1) {
				System.out.println("Wrong URL address");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * When the "Go" button is clicked, the following class is executed.
	 */
	private class LinksListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (appModel != null) {
				int linkNumber = 0;
				String linkString = appView.getLink();
				try {
					// Checking if the data typed is a number
					linkNumber = Integer.parseInt(linkString);
				} catch (NumberFormatException e2) {
					// If it is not a number, a Dialog showing all the available
					// links
					JOptionPane.showMessageDialog(null, appModel.viewAllLinks());
				}
				// Checking if the number typed, is associated with a link in
				// the currently opened HTML File
				if (linkNumber <= appModel.howManyLinks() && linkNumber >= 1) {
					try {
						if (appModel.getPath().startsWith("http://localhost/")) {
							URL addressURL = new URL(appModel.openLink(linkNumber));
							appModel = new BrowserModel(addressURL);
							appView.setDisplay(appModel.builder(appModel));
							appView.setAddress(appModel.getPath());
							appView.setLink("");
						} else {
							File htmlFile = new File(appModel.openLinkLocal(linkNumber));
							appModel = new BrowserModel(htmlFile);
							appView.setDisplay(appModel.builder(appModel));
							appView.setAddress(appModel.getPath());
							appView.setLink("");
						}

					} catch (IOException | URISyntaxException e1) {
						JOptionPane.showMessageDialog(null, "File does not exist");
					}
				} else {
					// If the number typed is not a link in the currently opened
					// HTML File, the following Dialog is shown
					JOptionPane.showMessageDialog(null, appModel.viewAllLinks());
				}
			}
		}
	}

	/**
	 * When the "Browse" button is clicked, the following class is executed.
	 * A FileChooser is shown. Allowing the user to select a local HTML file.
	 */
	private class BrowseListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (appView.getFileChooser().showOpenDialog(appView.getBrowseButton()) == JFileChooser.APPROVE_OPTION) {
				File file = new File(appView.getFileChooser().getSelectedFile().getAbsolutePath());
				try {
					appModel = new BrowserModel(file);
					appView.setDisplay(appModel.builder(appModel));
					appView.setAddress(appModel.getPath());
				}	catch (IOException e1) {
					System.out.println("Error");
				}
			} else {
				System.out.println("no file selected");
			}
		}
	}
}
