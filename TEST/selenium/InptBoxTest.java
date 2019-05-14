package selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InptBoxTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver","/Users/macstudent/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		//1. tell selenium what page to test
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
//2. type your msg into text box(id=user message )(send keys ("....."))
		textBox.sendkeys("hello world");
		//3. Find the button Form#get-input button
		WebElement button=driver.findElement(By.cssSelector("form#get-input buttton"));
		//4. click on the button
		button.click();
		//5. find the output msg thing(id=msg)
		webElement outputSpan=driver.findElement9By.id("displey"));
		
		webElement button=driver.findElement(By.cssSelector("for#get-input button"));
		
	}

}
