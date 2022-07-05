package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    private By chosenProductName = By.xpath("//*[@class='inventory_item_name']");
    private By buttonCheckout = By.id("checkout");


    public WebElement getChosenProductName() {
        return driver.findElement(chosenProductName);
    }

    public void clickButtonCheckout() {
        driver.findElement(buttonCheckout).click();
    }
}
