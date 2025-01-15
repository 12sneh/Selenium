package login.Project_Exgen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_Task {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://beta.exgen.ai/");
		driver.manage().window().maximize();

		WebElement emailInput = driver.findElement(By.id("outlined-email"));
		emailInput.sendKeys("vikas.s@uiuxstudio.com");
		Thread.sleep(2000);
		WebElement continueButton = driver.findElement(By.xpath("//p[text()='Continue']"));
		continueButton.click();

		WebDriverWait wait = new WebDriverWait(driver, (20));
		WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outlined-password"))); 
		passwordInput.sendKeys("Pass@123");

		WebElement loginButton = driver.findElement(By.xpath("//button[.//p[text()='Continue']]"));
		loginButton.click();

		WebElement exgenLink =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a._link_ielq1_58")));
		exgenLink.click();

		WebElement addTask = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Add Task']")));
		addTask.click();
		
		WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Cancel']")));
		cancelButton.click();
		
		WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Close']")));
		closeButton.click();
		
		WebElement enterTitleText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outlined-basic")));
		enterTitleText.sendKeys("Automation");
		
		WebElement description = driver.findElement(By.cssSelector("div[role='textbox']"));
		description.sendKeys("This task is about Automation");
		
		WebElement priority = driver.findElement(By.xpath("//p[text()='LOW']"));
		priority.click();
		
		WebElement highText = driver.findElement(By.xpath("//p[text()='HIGH']"));
		highText.click();
		
		Thread.sleep(2000);
		
		WebElement createButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='CREATE TASK']")));
    	createButton.click();
    	
    	System.out.println("Test Completed");
		
	}

}
