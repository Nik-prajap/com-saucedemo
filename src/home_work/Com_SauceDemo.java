package home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project  :  4
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */
public class Com_SauceDemo {

    // Static variables assign to call direct to main method
    static String browser = "Chrome";                           //launch the Chrome browser as requested.
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Print the title
        String title = driver.getTitle();
        System.out.println(title);

        // Print the current Url
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        // Print the page source
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

        // FInd the element and lacate.
        WebElement userName = driver.findElement(By.id("user-name"));
        // Username entered
        userName.sendKeys("performance_glitch_user");
        Thread.sleep(2500);

        // FInd the element and lacate.
        WebElement passWord = driver.findElement(By.id("password"));
        // Entered password
        passWord.sendKeys("secret_sauce");
        Thread.sleep(2500);

        // FInd the element and lacate.
        WebElement login = driver.findElement(By.name("login-button"));
        // Action to click the login button
        login.click();

        // Print the current Url
        String currentUrl1 = driver.getCurrentUrl();
        System.out.println(currentUrl1);

        // navigate to base url
        driver.navigate().to(baseUrl);
        // Page refreshed
        driver.navigate().refresh();

        // Close the browser
        driver.quit();
    }

}
