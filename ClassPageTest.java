package testproject;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassPageTest {


	final String URL = "https://www.webdirectory.com/Animals/";
	final String DRIVER_PATH = "/Users/akshdeepkaur/Desktop/chromedriver";
	
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
		Thread.sleep(1000);				// OPTION 1
		TimeUnit.SECONDS.sleep(1);		// OPTION 2
		driver.close();
	}

	@Test
	public void testNumberofLinks() {
		fail("Not yet implemented");
	}

}
