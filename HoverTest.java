package testproject;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverTest {

	final String URL = "http://the-internet.herokuapp.com/hovers";
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
	public void testHover() throws Exception {
		// 1. FIND the image									(findElementBy)
		List<WebElement> images = driver.findElements(By.cssSelector("div.figure img"));
		assertEquals(3, images.size());
		
		// get the first photo on the page
		WebElement image = images.get(0);
		
		Thread.sleep(3000);
		
		// 2. HOVER on the image								(????)
		Actions builder = new Actions(driver);
		builder.moveToElement(image).build().perform();
		
		// 3. CLICK on the View Profile link					(click())
		List<WebElement> profileLinks = driver.findElements(By.cssSelector("div.figcaption a"));
		assertEquals(3, profileLinks.size());
		
		WebElement firstImageLink = profileLinks.get(0);
		
		Thread.sleep(1000);
		
		firstImageLink.click();		
		
		// 4. Wait for system to go to next page				
		// 5. GET the url of the new page					(????)
		String urlPage2 = driver.getCurrentUrl();
		System.out.println(urlPage2);
		
		// 6. CHECK that url of new page 					(assert)
		// 	= "http://the-internet.herokuapp.com/users/1"
		assertEquals("http://the-internet.herokuapp.com/users/1", urlPage2);
	}
	
	
	
	
}
