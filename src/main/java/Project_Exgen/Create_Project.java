package login.Project_Exgen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Project {

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
		
		Thread.sleep(5000) ;
		WebElement creativeOps = driver.findElement(By.xpath("//span[contains(text(), 'Creative Ops')]"));
		creativeOps.click();

		WebElement createProject = driver.findElement(By.xpath("//p[text()='Create Project']"));
		createProject.click();
		
		WebElement projectName = driver.findElement(By.cssSelector(".MuiInputBase-input"));
		projectName.sendKeys("Twelve Tone");

		Thread.sleep(1000);
		WebElement description = driver.findElement(By.xpath("//textarea[@name='projectDesc']"));
		description.sendKeys("For Testing");

		WebElement selectCategory = driver.findElement(By.xpath("//div[@id='mui-component-select-category']"));
		selectCategory.click();

		Thread.sleep(2000);
		WebElement dropDown = driver.findElement(By.xpath("//li[@data-value='Web Development']"));
		dropDown.click();
		
		Thread.sleep(2000);

		WebElement addProject = driver.findElement(By.xpath("//button[normalize-space(text())='Add Project']"));
		addProject.click();

		Thread.sleep(3000);
		driver.close();
	
	}

}
