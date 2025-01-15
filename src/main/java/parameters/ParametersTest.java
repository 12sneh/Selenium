package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametersTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"url","email","password"})
	public void paramtr(String url, String email, String password) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.className("_submitBtn_yye06_97")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
