package practice;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

//@Slf4j                                 // anotacija uz loggingu
@Log4j
public class BrowserTest {

    ChromeDriver driver;                 // izveido klases "ChromeDriver" mainiigo/objektu "driver" - seit tas NAV INICIALIZETS. Mainigais ir izveidots klases liimenii.
    // tiek izveidots objekta mainigais klases limenii
    // seit saglabasies visa info par inicizlieto driver

    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Initialize ChromeWebDriver");
        // ChromeDriver driver = new ChromeDriver();     // "driver" inicilizejas ieksa TIKAI metode "openBrowser" & CITAS METODES NAV PIEEJAMS

        this.driver = new ChromeDriver();   // "this.driver = new ChromeDriver()" - inicialize "driver", kas saglabasies klases limenii "ChromeDriver driver"
        // "new ChromeDriver()" - tiek veidots jauns klases ChromeDriver objekts
        // klases mainigaja "driver" zem klases uzreiz ---> pec inicializacijas vares objektu "driver" visas klases metodes dabut citas metodes *
        // "ChromeDriver" - klase, "driver" - objekts, kas izveidots uz klases "ChromeDriver" pamata
        // "this.driver" - suta visu info uz "ChromeDriver driver"
        driver.get("https://google.lv");
    }


    @Test
    public void chromeDriverTest() {
        Assert.assertEquals(driver.getTitle(), "Google");           // <title>Google</title>
//        driver.getTitle();              //Google   // sis "driver" nem sev metodes no augseja "ChromeDriver driver", jo tas ir inicializets
        driver.manage().window().maximize();      // *seit piemeram
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        log.info("Closing ChromeWebDriver");
        driver.close();
    }
}


