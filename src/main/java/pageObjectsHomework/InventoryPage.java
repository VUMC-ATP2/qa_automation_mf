package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }


    private By titleProducts = By.xpath("//*[@class='title']");
    private By buttonAddToCart = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private By buttonShoppingCart = By.xpath("//*[@class='shopping_cart_link']");


    public WebElement getTitleProducts() {
        return driver.findElement(titleProducts);
    }

    public void clickButtonAddToCart() {
        driver.findElement(buttonAddToCart).click();
    }

    public void clickButtonShoppingCart() {
        driver.findElement(buttonShoppingCart).click();
    }
}
