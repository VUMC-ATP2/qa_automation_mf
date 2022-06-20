package practice;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Slf4j                                 // anotacija uz loggingu
public class BrowserTest {

    ChromeDriver driver;                 //izveido objekta mainigo klases liimenii / seit liek citu driver nosaukumu

    @BeforeTest
    public void setProperties() {
        System.setProperty("webdriver.chrome.silentOutput", "true");
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Initialize ChromeWebDriver");
        this.driver = new ChromeDriver();   // "new ChromeDriver()"-seit tiek inicializets "driver"!!!!, kas saglabajas
        // klases mainigaja "driver" zem klases uzreiz
        // "ChromeDriver"-klase, "driver" - objekts, kas izveidots uz klases "ChromeDriver" pamata
        driver.get("https://google.lv");
    }


    @Test
    public void chromeDriverTest() {
        Assert.assertEquals(driver.getTitle(), "Google");
//        driver.getTitle();              //Google   // sis driver. nem sev metodes no augseja "ChromeDriver driver"
        driver.manage().window().maximize();
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        log.info("Closing ChromeWebDriver");
        driver.close();
    }
}
