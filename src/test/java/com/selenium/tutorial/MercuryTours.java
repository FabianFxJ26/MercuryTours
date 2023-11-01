package com.selenium.tutorial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours {
	private WebDriver webDriver;
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	By textFieldUserNameLocator = By.id("email");
	By textFieldPasswordLocator = By.name("password");
	By textFieldConfirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	By buttonSubmit = By.cssSelector("input[name='submit']");

	By userLocator = By.name("userName");
	By passwordLocator = By.name("password");
	By buttonInitSesion = By.name("submit");
	By initSesionOk = By.xpath("//img[@src='images/mast_register.gif']");

	@Before
	public void setUp() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get("https://demo.guru99.com/test/newtours/");	
	}

	@After
	public void tearDown() throws Exception {
		//webDriver.quit();
	}
	/**
	 * Primer escenario de prueba para automatizar
	 * @throws InterruptedException 
	 */
	@Test
	public void tregisterUser() throws InterruptedException {
		webDriver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		if (webDriver.findElement(registerPageLocator).isDisplayed())
		{
			webDriver.findElement(textFieldUserNameLocator).sendKeys("XimenaAlfonso");
			webDriver.findElement(textFieldPasswordLocator).sendKeys("ximena123");
			webDriver.findElement(textFieldConfirmPasswordLocator).sendKeys("ximena123");
			webDriver.findElement(buttonSubmit).click();
		}
		else
		{
			System.out.println("404 page not found");
		}
		List<WebElement> fonts = webDriver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is XimenaAlfonso.",fonts.get(5).getText());
	}
	@Test
	public void signIn() throws InterruptedException
	{
		if(webDriver.findElement(userLocator).isDisplayed())
		{
			webDriver.findElement(userLocator).sendKeys("XimenaAlfonso");
			webDriver.findElement(passwordLocator).sendKeys("ximena123");
			webDriver.findElement(buttonInitSesion).click();
			Thread.sleep(2000);
			assertTrue(webDriver.findElement(initSesionOk).isDisplayed());
		}
		else
		{
			System.out.println("The init sesion to failure");
		}
	}
}
