package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {

    private WebDriver driver;

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    private By tilteCheckoutComplete = By.xpath("//*[@class='title']");
    private By btnBackHome = By.id("back-to-products");

    public WebElement getTilteCheckoutComplete() {
        return driver.findElement(tilteCheckoutComplete);
    }

    public void clickBtnBackHome() {
        driver.findElement(btnBackHome).click();
    }
}
