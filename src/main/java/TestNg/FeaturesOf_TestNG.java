package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FeaturesOf_TestNG {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://stage.schedulehub.io/");
		driver.manage().window().maximize();
	}
	
	@Test()
	public void twelweToneTitle() {
		String title = driver.getTitle();
		System.out.println("title");
		
		//Validation
		Assert.assertEquals(title, "Twelve Tone");
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
