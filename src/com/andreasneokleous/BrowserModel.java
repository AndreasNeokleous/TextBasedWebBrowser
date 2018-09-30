/**
 * BrowseModel.java
 */
package com.andreasneokleous;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

/**
 * The Model manages the functionality and calculations of the application.
 * @author Andreas Neokleous
 *
 */
public class BrowserModel {

	private URL htmlURL;
	private Document doc;
	private Elements linksList;
	private String path;

	public BrowserModel() {
		super();
	}

	/**
	 * Constructor called when a URL is typed, coming from a Local Web Server.
	 */
	public BrowserModel(URL url) throws IOException {
		super();
		this.htmlURL = url;
		this.doc = Jsoup.parse(url, 1000);
		this.linksList = doc.select("a");
		this.path = url.toString();
	}

	/**
	 * Constructor called when the address typed, is a local path
	 */
	public BrowserModel(File file) throws IOException {
		super();
		this.htmlURL = file.toURI().toURL();
		this.doc = Jsoup.parse(file, null);
		this.linksList = doc.select("a");
		this.path = file.getAbsolutePath();
	}

	/**
	 * This method is the one that parses the HTML file before displaying it.
	 * The <A>,
	 * <UL>
	 * ,
	 * <OL>
	 * ,
	 * <HR>
	 * ,<BR>
	 * and
	 * <P>
	 * tags are handled.
	 */
	public String builder(BrowserModel htmlModel) {
		int linkNumber = 1;

		// Writing the link number after every <A> tag found in the document.
		for (Element element : htmlModel.doc.select("a")) {
			element.append("[" + linkNumber + "]");
			linkNumber++;
		}

		// Managing the new lines before and after the <UL> and <OL> tags.
		for (Element element : htmlModel.doc.select("ul,ol")) {
			element.prepend("\\n");
			element.append("\\n\\n");
		}

		// Adding the dot symbol of the Unordered List before each item in the
		// list
		for (Element element : htmlModel.doc.select("ul").select("li")) {
			element.prepend(" •");
			element.prepend(" \\n");
		}

		// Adding a number before each item of the Ordered List
		int i = 1;
		for (Element element2 : htmlModel.doc.select("ol").select("li")) {
			element2.prepend(" " + i + ". ");
			element2.prepend(" \\n");
			i++;

		}

		// Displaying ___ as a thematic break
		for (Element element : htmlModel.doc.select("hr")) {
			element.append("\\n _____ \\n");
		}

		// Managing the <BR> and <P> tags with new lines
		htmlModel.doc.select("br").append("\\n");
		htmlModel.doc.select("p").prepend("\\n\\n");
		htmlModel.doc.select("p").append("\\n");

		String s1 = htmlModel.doc.text().replaceAll("\\\\n", "\n");

		String htmlString = Jsoup.clean(s1, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false))
				.trim();
		return htmlString;
	}

	/**
	 * The following method gets all the available links in the currently opened
	 * HTML file
	 * 
	 * @return StringBuffer with all the Available Links
	 */
	public StringBuffer viewAllLinks() {
		StringBuffer buffer = new StringBuffer("Available Links: \n");
		if (linksList != null) {
			for (int i = 0; i < this.linksList.size(); i++) {
				buffer.append(i + 1 + " - " + this.linksList.get(i).attr("href") + " \n");
			}
		}
		return buffer;
	}

	/**
	 * Getting the count of the available links
	 */
	public int howManyLinks() {
		if (linksList != null) {
			return this.linksList.size();
		} else {
			return 0;
		}
	}

	/**
	 * Method when HTML files are in a Local Web Server This method handles the
	 * link number typed. It is called when the user wants to open a link of the
	 * currently opened HTML file
	 */
	public String openLink(int linkNumber) throws IOException, URISyntaxException {
		// Creating URI using the current URL
		URI uri = new URI(this.htmlURL.toExternalForm());
		// Getting the parent path
		URI parent = uri.getPath().endsWith("/") ? uri.resolve("..") : uri.resolve(".");
		// Creating a string with the URL of the link
		String linkPath = parent + this.linksList.get(linkNumber - 1).attr("href");
		BrowserModel link = new BrowserModel(new URL(linkPath));
		return link.getPath();
	}

	/**
	 * Method when HTML files are in a local storage device Same functionality
	 * as openLink method
	 */
	public String openLinkLocal(int linkNumber) throws MalformedURLException, IOException, URISyntaxException {
		URI uri = new URI(this.htmlURL.toExternalForm());
		URI parent = uri.getPath().endsWith("/") ? uri.resolve("..") : uri.resolve(".");
		String linkPath = parent + this.linksList.get(linkNumber - 1).attr("href");
		BrowserModel link = new BrowserModel(new File(linkPath.replace("file:/", "").replace("%20", " ")));
		return link.getPath();
	}

	public String getPath() {
		return this.path;
	}

}
