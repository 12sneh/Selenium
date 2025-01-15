package login.Project_Exgen;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit_Project {
    
    private WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Set up WebDriver using WebDriverManager
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @AfterMethod 
//    public void tearDown() {
//        driver.quit(); // Close the browser
//    }

    @Test
    public void login() throws InterruptedException {
        driver.get("https://beta.exgen.ai/");
        
        // Input email
        WebElement emailInput = driver.findElement(By.id("outlined-email"));
        emailInput.sendKeys("vikas.s@uiuxstudio.com");
        
        Thread.sleep(2000);
        
        // Click continue button
        WebElement continueButton = driver.findElement(By.xpath("//p[text()='Continue']"));
        continueButton.click();
        
        WebDriverWait wait = new WebDriverWait(driver, (10));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outlined-password"))); 
        passwordInput.sendKeys("Pass@123");
       
        // Click the login button
		WebElement loginButton = driver.findElement(By.xpath("//button[.//p[text()='Continue']]"));
        loginButton.click();
       
        Thread.sleep(4000);
        
        WebElement exgenLink = driver.findElement(By.cssSelector("a._link_ielq1_58"));
        exgenLink.click();
        
        Thread.sleep(2000);
        
        WebElement moreHorizIcon = driver.findElement(By.cssSelector("svg[data-testid='MoreHorizIcon']"));
        moreHorizIcon.click();

        WebElement editDiv = driver.findElement(By.xpath("//li[contains(@class, 'css-1jvskzp')]"));
        editDiv.click();

        WebElement projectName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='projectName']")));
    
        projectName.clear();
   
        Thread.sleep(2000);

        projectName.sendKeys("Exgen Project");
        
        WebElement updateButton = driver.findElement(By.xpath("//button[text()='Update Project']"));
        updateButton.click();
        
    }
}
