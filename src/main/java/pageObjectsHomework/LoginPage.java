package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameField = By.id("user-name");
    private By passwordField = By.xpath("//input[@id='password']");
    private By loginButton = By.id("login-button");


    // Username Field:
//    public WebElement getUsernameField() {                      // so prieks, ja testos loginpaget.getUsernameElement().sendkeys()
//        return driver.findElement(usernameField);
//    }


    // Lai isak kopeeja metode (username, password, click btn):
    public void fillLoginPage(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}


