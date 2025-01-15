package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgProject {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://stage.schedulehub.io/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1) //Login
	public void TwelweTone_Login() throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.className("_submitBtn_yye06_97")).click();

		Thread.sleep(8000);
		//Logout
		driver.findElement(By.className("_userImage_1kzk2_103")).click();
		driver.findElement(By.xpath("//li[text()='Logout']")).click();

		Thread.sleep(4000);
		driver.close();

		System.out.println("Test Completed Successfully");
	}

	@Test(priority = 2)
	public void TwelweLogin() throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys("tesgmail.com");
		driver.findElement(By.name("password")).sendKeys("1234567");
		driver.findElement(By.className("_submitBtn_yye06_97")).click();

		Thread.sleep(4000);
		driver.close();

		System.out.println("Test Completed Successfully");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}



}
