/**
 * BrowserView.java
 */
package com.andreasneokleous;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.GridBagLayout;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;


import javax.swing.JButton;

/**
 * The View is the GUI that the user can interact with
 * @author Andreas Neokleous 
 *
 */
public class BrowserView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField addressField;
	private JEditorPane displayScreen;
	private JTextField linkField;
	private JButton goButton;
	private JButton doneButton;
	private JButton browseButton;
	private JFileChooser fileChooser;

	
	public BrowserView() {
		setTitle("Text Based Web Browser - an00194");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 30, 0, 60, 0};
		gbl_contentPane.rowHeights = new int[] {0, 200, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0};
		contentPane.setLayout(gbl_contentPane);

		browseButton = new JButton("Browse");
		GridBagConstraints gbc_browseButton = new GridBagConstraints();
		gbc_browseButton.insets = new Insets(0, 0, 5, 5);
		gbc_browseButton.gridx = 0;
		gbc_browseButton.gridy = 0;
		contentPane.add(browseButton, gbc_browseButton);
		
		addressField = new JTextField();
		GridBagConstraints gbc_addressField = new GridBagConstraints();
		gbc_addressField.gridwidth = 3;
		gbc_addressField.insets = new Insets(0, 0, 5, 5);
		gbc_addressField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addressField.gridx = 1;
		gbc_addressField.gridy = 0;
		contentPane.add(addressField, gbc_addressField);
		addressField.setColumns(10);
		
		doneButton = new JButton("Done");
		GridBagConstraints gbc_doneButton = new GridBagConstraints();
		gbc_doneButton.insets = new Insets(0, 0, 5, 0);
		gbc_doneButton.gridx = 4;
		gbc_doneButton.gridy = 0;
		contentPane.add(doneButton, gbc_doneButton);
		
		displayScreen = new JEditorPane();
		displayScreen.setEditable(false);
		GridBagConstraints gbc_displayScreen = new GridBagConstraints();
		gbc_displayScreen.gridwidth = 5;
		gbc_displayScreen.insets = new Insets(0, 0, 5, 5);
		gbc_displayScreen.fill = GridBagConstraints.BOTH;
		gbc_displayScreen.gridx = 0;
		gbc_displayScreen.gridy = 1;
		JScrollPane scrollPane = new JScrollPane(displayScreen);
		contentPane.add(scrollPane,gbc_displayScreen);
		
		
		linkField = new JTextField();
		GridBagConstraints gbc_linkField = new GridBagConstraints();
		gbc_linkField.insets = new Insets(0, 0, 0, 5);
		gbc_linkField.fill = GridBagConstraints.BOTH;
		gbc_linkField.gridx = 3;
		gbc_linkField.gridy = 2;
		contentPane.add(linkField, gbc_linkField);
		
		goButton = new JButton("GO");
		GridBagConstraints gbc_goButton = new GridBagConstraints();
		gbc_goButton.gridx = 4;
		gbc_goButton.gridy = 2;
		contentPane.add(goButton, gbc_goButton);
		
		
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new java.io.File("."));
		fileChooser.setDialogTitle("Choose an HTML file");
		FileNameExtensionFilter htmlFilter = new FileNameExtensionFilter("html files (*.html)", "html");
		fileChooser.setFileFilter(htmlFilter);
		
	}
	
	/**
	 * Getters and Setters for the fields
	 */
	
	public String getAddress(){
		return addressField.getText();
	}
	
	public void setAddress(String address){
		addressField.setText(address);
	}
	
	public void setDisplay(String displayHTML){
		this.displayScreen.setText(displayHTML);
	}
	
	public String getLink(){
		return linkField.getText();
	}
	
	public void setLink(String linkNumber){
		this.linkField.setText(linkNumber);
	}
	
	public JFileChooser getFileChooser(){
		return this.fileChooser;
	}
	
	public JButton getBrowseButton(){
		return this.browseButton;
	}

	/**
	 * The button listeners that are called by the Controller Constructor.
	 */
	
	public void addressBarButtonListener(ActionListener listenForDoneButton){
		doneButton.addActionListener(listenForDoneButton);
	}
	
	public void linksButtonListener(ActionListener listenForGoButton){
		goButton.addActionListener(listenForGoButton);
	}
	
	public void browseButtonListener(ActionListener listenForBrowseButton){
		browseButton.addActionListener(listenForBrowseButton);
	}

}
