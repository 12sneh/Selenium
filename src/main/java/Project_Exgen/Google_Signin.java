package login.Project_Exgen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google_Signin {

    public static void main(String[] args) throws InterruptedException {
        
        // Set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://beta.exgen.ai/");
        driver.manage().window().maximize();

        // Wait for the "Continue with Google" button and click it
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement googleSignInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[contains(@class, '_googleTxt') and text()='Continue with Google']")));
            googleSignInButton.click();
            System.out.println("Clicked on 'Continue with Google' button");
            
            // Wait briefly for new window/tab to appear
            Thread.sleep(2000);

            // Switch to the new window (Google login window)
            for (String windowHandle : driver.getWindowHandles()) {
                driver.switchTo().window(windowHandle);
                if (driver.getCurrentUrl().contains("accounts.google.com")) {
                    System.out.println("Switched to Google login window.");
                    break;
                }
            }

            // Wait for the email input field and enter email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
            emailField.sendKeys("sneha.offshoreuiuxstudio@gmail.com");
            System.out.println("Entered email.");

            // Locate and click the "Next" button after entering the email
            WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
            nextButton.click();
            System.out.println("Clicked 'Next' button.");

            // Additional steps to handle password input and any further login actions can be added here

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
          
        }
    }
}
