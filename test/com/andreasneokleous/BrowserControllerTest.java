/**
 * BrowserControllerTest.java
 */
package com.andreasneokleous;

import org.junit.*;

import com.andreasneokleous.BrowserController;
import com.andreasneokleous.BrowserModel;
import com.andreasneokleous.BrowserView;

import static org.junit.Assert.*;

/**
 * The class <code>BrowserControllerTest</code> contains tests for the class <code>{@link BrowserController}</code>.
 *
 * @author Andreas Neokleous
 * @version $Revision: 1.0 $
 */
public class BrowserControllerTest {
	/**
	 * Run the BrowserController(BrowserModel,BrowserView) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 16/05/16 21:04
	 */
	@Test
	public void testBrowserController_1()
		throws Exception {
		BrowserModel model = new BrowserModel();
		BrowserView view = new BrowserView();

		BrowserController result = new BrowserController(model, view);
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 16/05/16 21:04
	 */
	@Before
	public void setUp()
		throws Exception {
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 16/05/16 21:04
	 */
	@After
	public void tearDown()
		throws Exception {
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 16/05/16 21:04
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BrowserControllerTest.class);
	}
}