package login.Project_Exgen;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Teams {

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

		WebElement addTeamText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='add team']")));
		addTeamText.click();
		
		WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.MuiInputBase-input.MuiOutlinedInput-input.css-1x5jdmq")));
		inputField.sendKeys("Exgen Team");
		
		WebElement assignProject = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Open']")));
		assignProject.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement checkbox = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#\\:r2\\:-option-0")));
		checkbox.click();
		
		WebElement emailAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":r4:")));
		emailAddress.sendKeys("sneha@yopmail.com");
		emailAddress.sendKeys(Keys.ENTER);
		
		WebElement option = driver.findElement(By.cssSelector("#\\:r4\\:-option-0"));
		option.click(); 
		
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		WebElement addTeamButton = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//p[text()='Add Team']]")));
		addTeamButton.click();	
	}
}
