package login.Project_Exgen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_Teams {

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

		WebDriverWait wait = new WebDriverWait(driver, (10));
		WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outlined-password"))); 
		passwordInput.sendKeys("Pass@123");

		WebElement loginButton = driver.findElement(By.xpath("//p[text()='Continue']"));
		loginButton.click();
		
		WebElement teamsText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Teams']")));
		teamsText.click();
		
		WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.css-ik44ad")));
		button.click(); 
		
		WebElement deleteTeam = driver.findElement(By.xpath("//p[text()='Delete Team']"));
		deleteTeam.click();
		
		Thread.sleep(1000);
		
		WebElement closeButton = driver.findElement(By.xpath("//p[text()='Close']"));
		closeButton.click();
		
//		WebElement yesButton = driver.findElement(By.xpath("//p[text()='Yes']"));
//		yesButton.click();
		
		System.out.println("Successfully Completed");		

		driver.close();
	}

}
