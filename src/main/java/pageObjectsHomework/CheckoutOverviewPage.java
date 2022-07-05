package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {

    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public By inventoryItemName = By.xpath("//*[@class='inventory_item_name']");
    private By itemTotal = By.xpath("//*[@class='summary_subtotal_label']");
    private By buttonFinish = By.id("finish");


    public WebElement getInventoryItemName() {
        return driver.findElement(inventoryItemName);
    }

    public WebElement getItemTotal() {
        return driver.findElement(itemTotal);
    }

    public void clickButtonFinish() {
        driver.findElement(buttonFinish).click();
    }
}
