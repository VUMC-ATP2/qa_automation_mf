package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkoutFirstName = By.id("first-name");
    private By checkoutLastName = By.xpath("//input[@id='last-name']");
    private By checkoutPostalCode = By.id("postal-code");
    private By buttonContinue = By.id("continue");
    private By buttonError = By.xpath("//*[@data-test='error']");


    public void setCheckoutFirstName(String value) {
        driver.findElement(checkoutFirstName).sendKeys(value);
    }

    public void setCheckoutLastName(String value) {
        driver.findElement(checkoutLastName).sendKeys(value);
    }

    public void setCheckoutPostalCode(String value) {
        driver.findElement(checkoutPostalCode).sendKeys(value);
    }

    public void clickButtonContinue() {
        driver.findElement(buttonContinue).click();
    }

    public WebElement getButtonError() {
        return driver.findElement(buttonError);
    }
}
