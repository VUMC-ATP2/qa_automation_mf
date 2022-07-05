package seleniumHomework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

// 1. Scenārijs:
//        1. Navigēt uz saiti https://www.saucedemo.com/
//        2. Ielogoties ar pareizu lietotāja vārdu/paroli
//        3. Pārbaudīt, ka lietotājs ir ielogojies
//        4. Ievietot Grozā 1 produktu
//        5. Doties uz grozu
//        6. Pārbaudīt, kā šī prece ir grozā
//        7. Doties uz Checkout
//        8. Ievadīt vārdu/uzvārdu/pasta indeksu
//        9. Doties uz Checkout overview lapu, pārbaudīt datus
//        10. Doties uz finish lapu un pārbaudīt vai viss bija veiksmīgi
//        11. Doties atpakaļ uz pirmo lapu ar pogu 'Back Home'

// 2. Scenārijs:
//        1. Navigēt uz saiti https://www.saucedemo.com/
//        2. Ielogoties ar pareizu lietotāja vārdu/paroli
//        3. Doties uz grozu
//        4. Doties uz Checkout
//        5. Pārbaudīt, ka FirstName/LastName/Zip code ir obligāts
//        6. Pārbaudīt, ka forma parāda pareizu kļūdas paziņojumu pie katra neievadītā lauka


@Log4j
public class SauceDemoTests {
    ChromeDriver driver;
    CartPage cartPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutPage checkoutPage;
    CheckoutSuccessPage checkoutSuccessPage;
    InventoryPage inventoryPage;
    LoginPage loginPage;


    @BeforeMethod(alwaysRun = true)
    public void login() {
        this.driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        log.info("Login Page: authorize user");
        loginPage = new LoginPage(driver);
        loginPage.fillLoginPage("standard_user", "secret_sauce");
    }

    @Test
    public void scenario1() {
        inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");        // vai ielogojies sistema
        log.info("Inventory page: choosing product");
        inventoryPage.clickButtonAddToCart();
        inventoryPage.clickButtonShoppingCart();

        log.info("Cart page: checking right product");
        cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getChosenProductName().getText(), "Test.allTheThings() T-Shirt (Red)");
        cartPage.clickButtonCheckout();

        log.info("Checkout page: filling data");
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.setCheckoutFirstName("Andris");
        checkoutPage.setCheckoutLastName("Berzins");
        checkoutPage.setCheckoutPostalCode("LV-1021");
        checkoutPage.clickButtonContinue();

        log.info("Checkout overview page: checking data");
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.getInventoryItemName().getText(), "Test.allTheThings() T-Shirt (Red)");
        Assert.assertEquals(checkoutOverviewPage.getItemTotal().getText(), "Item total: $15.99");
        checkoutOverviewPage.clickButtonFinish();

        log.info("Checkout Success Page: checking data");
        checkoutSuccessPage = new CheckoutSuccessPage(driver);
        Assert.assertEquals(checkoutSuccessPage.getTilteCheckoutComplete().getText(), "CHECKOUT: COMPLETE!");
        checkoutSuccessPage.clickBtnBackHome();
    }

    @Test
    public void scenario2() {
        inventoryPage = new InventoryPage(driver);
        inventoryPage.clickButtonShoppingCart();

        cartPage = new CartPage(driver);
        cartPage.clickButtonCheckout();

        log.info("Checkout page: checking field requirements");
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickButtonContinue();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");        // Pārbaudīt, ka FirstName/LastName/Zip code ir obligāts
        Assert.assertEquals(checkoutPage.getButtonError().getText(), "Error: First Name is required");
        checkoutPage.setCheckoutFirstName("x");
        checkoutPage.clickButtonContinue();
        Assert.assertEquals(checkoutPage.getButtonError().getText(), "Error: Last Name is required");
        checkoutPage.setCheckoutLastName("y");
        checkoutPage.clickButtonContinue();
        Assert.assertEquals(checkoutPage.getButtonError().getText(), "Error: Postal Code is required");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
