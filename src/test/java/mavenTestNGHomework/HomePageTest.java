package mavenTestNGHomework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
    ChromeDriver chromeDriver;

    @BeforeMethod
    public void openBrowser() {
        this.chromeDriver = new ChromeDriver();
    }

    @Test
    public void ChromeDriverTitleTestFirst() {
        chromeDriver.get("https://www.tvnet.lv/");
        Assert.assertEquals(chromeDriver.getTitle(), "TVNET - Īstas ziņas");
    }

    @Test
    public void ChromeDriverTitleTestSecond() {
        chromeDriver.get("https://www.diena.lv/");
        Assert.assertEquals(chromeDriver.getTitle(), "Diena / Diena");
    }

    @AfterMethod
    public void closeBrowser() {
        chromeDriver.close();
    }
}
