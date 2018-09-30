/**
 * BrowserMainTest.java
 */
package com.andreasneokleous;

import org.junit.*;

import com.andreasneokleous.BrowserMain;
/**
 * The class <code>BrowserMainTest</code> contains tests for the class <code>{@link BrowserMain}</code>.
 *
 * @author Andreas Neokleous 
 * @version $Revision: 1.0 $
 */
public class BrowserMainTest {
	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 16/05/16 21:04
	 */
	@Test
	public void testMain_1()
		throws Exception {
		String[] args = new String[] {};

		BrowserMain.main(args);
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
		new org.junit.runner.JUnitCore().run(BrowserMainTest.class);
	}
}