/**
 * BrowserModelTest.java
 */
package com.andreasneokleous;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import com.andreasneokleous.BrowserModel;

/**
 * This is the Test Class for the BrowserModel.java
 * 
 * @author Andreas Neokleous
 *
 */
public class BrowserModelTest {

	@Test
	public void testLinksNumber() throws IOException {
		File htmlFile = new File("test1.html");
		BrowserModel model = new BrowserModel(htmlFile);
		assertEquals(2, model.howManyLinks());
	}

	@Test
	public void testViewAllLinks() throws IOException {
		File htmlFile = new File("test1.html");
		BrowserModel model = new BrowserModel(htmlFile);
		StringBuffer linksBuffer = new StringBuffer("Available Links: \n" + "1 - test2.html \n" + "2 - test3.html \n");
		assertEquals(linksBuffer.toString(), model.viewAllLinks().toString());
	}

	@Test
	public void testOpenLink() throws IOException, URISyntaxException {
		File htmlFile = new File("test1.html");
		BrowserModel model = new BrowserModel(htmlFile);

		File file = new File("test2.html");
		String fileDir = file.getAbsolutePath();
		assertEquals(fileDir, model.openLinkLocal(1));
	}

	@Test
	public void testPath() throws IOException {
		File htmlFile = new File("test1.html");
		BrowserModel model = new BrowserModel(htmlFile);
		assertEquals(htmlFile.getAbsolutePath(), model.getPath());
	}
}
