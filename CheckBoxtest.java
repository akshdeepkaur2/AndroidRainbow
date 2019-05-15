package testproject;
import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxtest {

	final String URL = "https://www.seleniumeasy.com/test/basic-checkbox-demo.html";
	final String DRIVER_PATH = "/Users/akshdeepkaur/Desktop/chromedriver";
	//final String DRIVER_PATH = "C:\\chromedriver.exe";
	
	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		// Setup Selenium + Chrome
		System.setProperty("webdriver.chrome.driver",DRIVER_PATH);
		driver = new ChromeDriver();
		
		// Tell Selenium what page to test
		driver.get(URL);
	}

	@After
	public void tearDown() throws Exception {
		// At end of test case, wait for a few seconds, then close the browser
		Thread.sleep(2000);				// OPTION 1
		driver.close();
	}

	@Test
	public void testSingleCheckbox() {
		
		/*
		 * 1. FIND the checkbox  (id="isAgeSelected")
		 * 2. CLICK on the checkbox
		 * 3. FIND the output message (id="txtAge")
		 * 4. CHECK the output message = "Success - Check box is checked"
		 */
		
		WebElement checkbox = driver.findElement(By.id("isAgeSelected"));
		checkbox.click();
		
		// test that checkbox actually got checked
		boolean isChecked = checkbox.isSelected();
		assertTrue(isChecked);
		
		WebElement outputDiv = driver.findElement(By.id("txtAge"));
		String actualOutput = outputDiv.getText();

		String expectedOutput = "Success - Check box is checked";
		
		// check that output message matches expected mesage
		assertEquals(expectedOutput, actualOutput);
		
	}

	@Test
	public void testMultipleCheckbox() {
		/*
		 * PART 1: Press Button
		 * 	-> All boxes get checked
		 * 	-> Word on the button changes to "Uncheck All"
		 * 
		 * PART 2: Unselect a checkbox
		 * 	-> The checkbox is NOT selected
		 *  -> Word on button changes to "Check All"
		 */
		
		// PRESS BUTTON:
		// 1. FIND THE BUTTON										(findByElement)
		WebElement button = driver.findElement(By.id("check1"));
		// 2. CLICK ON THE BUTTON									(.click())
		button.click();
		
		// 3. CHECK that ALL BOXES ARE CHECKED!						(assert)
		//		--  GET ALL BOXES
		List<WebElement> checkboxes = driver.findElements(By.className("cb1-element"));
		
		//		--  CHECK THAT EACH BOX IS CHECKED
		for (int i = 0; i < checkboxes.size(); i++) {
			WebElement checkbox = checkboxes.get(i);
			boolean isChecked = checkbox.isSelected();
			assertTrue(isChecked);
		}
		
		// 4. CHECK that WORD on button changes to "UNCHECK ALL" 	(assert)
		String buttonText = button.getAttribute("value");
		assertEquals("Uncheck All", buttonText);
	
		// --------------------------------
		// PART 2: UNCHECK ONE CHECKBOX:
		// --------------------------------
		
		// 1. FIND A CHECKBOX					(findByElement)
		WebElement checkbox2 = checkboxes.get(2);
		// 2. CHECK THAT BOX IS CHECKED			(assert)
		boolean isBoxChecked = checkbox2.isSelected();
		assertTrue(isBoxChecked);
		// assertTrue = assertEquals(true, isBoxChecked);
		
		// 3. CLICK ON BOX						(click)
		checkbox2.click();
		// 4. CHECK THAT BOX IS UNCHECKED		(assert)
		isBoxChecked = checkbox2.isSelected();
		assertFalse(isBoxChecked);
		// assertFalse  = assertEquals(false, isBoxChecked);
		
		// 5. CHECK THAT WORD CHAGNES TO "CHECK ALL"	(assert)
		buttonText = button.getAttribute("value");
		assertEquals("Check All", buttonText);
		
		
	}
	
	
}

