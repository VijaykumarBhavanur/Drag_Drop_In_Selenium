package com.bridgelabz.selenium.dragdrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author Vijaykumar Bhavanur
 * purpose: To demonstrate drag drop functionality in selenium
 * 
 */
public class DragDrop {

	// Defining driver instance reference
	WebDriver driver;

	/**
	 * Method used to create and initialize driver instance
	 */
	@BeforeMethod
	public void setup() {

		// To set the path of the driver for the respective browser
		System.setProperty("webdriver.chrome.driver", "/home/admin1/Documents/chromedriver");

		// Creating browser instance based on driver
		driver = new ChromeDriver();

		// To Open URL of application to be tested
		driver.get("https://jqueryui.com/droppable/");

		// maximizing window
		driver.manage().window().maximize();

		// To switch to particular frame in a window
		driver.switchTo().frame(0);
	}

	/**
	 * Method to Test drop down automation functionality
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void dropDownTest() throws InterruptedException {

		// creating actions class instance
		Actions action = new Actions(driver);

		// finding web_element by xpath and draging element from source xpath to
		// destination xpath
		action.clickAndHold(driver.findElement(By.xpath("/html[1]/body[1]/div[1]")))
				.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[2]"))).release().build().perform();
		// waiting for 5seconds
		Thread.sleep(5000);

	}

	/**
	 * Method to close resource such as browser after executing test methods
	 */
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}