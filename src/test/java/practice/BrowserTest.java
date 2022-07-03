package practice;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_object.MainPage;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;


@Log4j  // anotacija uz loggingu

public class BrowserTest {

    private final String LOCAL_FILE = "file://" + this.getClass().getResource("/elements.html").getPath();

    ChromeDriver driver;                 // izveido klases "ChromeDriver" mainiigo/objektu "driver" - seit tas NAV INICIALIZETS. (Objekta) Mainigais ir izveidots klases liimenii.
    // seit saglabasies visa info par inicizlieto driver
    MainPage mainPage;                    // Klases "MainPage" mainīgais/objekts "mainpage" tiek definets, bet neinicializēts
    WebDriverWait wait;


    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");                     // lai samazinatu Console pazinojumus
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }


    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Initialize ChromeWebDriver");
        // ChromeDriver driver = new ChromeDriver();          // "driver" inicilizejas ieksa TIKAI metode "openBrowser" & CITAS METODES NAV PIEEJAMS

        this.driver = new ChromeDriver();                 // šis inicialize "driver", kas saglabasies klases limenii "ChromeDriver driver"

        // "new ChromeDriver()" - tiek veidots jauns klases ChromeDriver objekts
        // klases mainigaja "driver" zem klases uzreiz ---> pec inicializacijas vares objektu "driver" visas klases metodes dabut citas metodes *
        // "ChromeDriver" - klase, "driver" - objekts, kas izveidots uz klases "ChromeDriver" pamata
        // "this.driver" - suta visu info uz "ChromeDriver driver"
//        driver.get("https://google.lv");
        Duration duration = Duration.ofSeconds(20);
        wait = new WebDriverWait(driver, duration.getSeconds());    // jauns wait objekts
        driver.manage().window().maximize();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));     // NEIET. NETIEŠĀ gaidīšana. Gaida, kamer atrod elementu 20 sek
    }


    @Test
    public void chromeDriverTest() {
        Assert.assertEquals(driver.getTitle(), "Google");           // <title>Google</title>
//        driver.getTitle();              //Google   // sis "driver" nem sev metodes no augseja "ChromeDriver driver", jo tas ir inicializets
    }


    @Test
    public void elementTest() {
        driver.get(LOCAL_FILE);
// --- Šis viss tika aizkomentēts, jo izmantosim Page Object pieeju, kas aprakstīs šo:
//        WebElement firstNameField = driver.findElement(By.id("fNameID"));              // sis ir elements "nameField" vards
//        firstNameField.sendKeys("John");                                               // aizsuta info, ar kuru aizpildit
//        WebElement lastName = driver.findElement(By.id("lNameID"));
//        lastName.sendKeys("Berzins");
//        WebElement aboutInfo = driver.findElement(By.id("aboutMeID"));                   // sis ir elements "nameField" vards
//        aboutInfo.clear();
//        aboutInfo.sendKeys("La la laa");
//        WebElement buttonCheckInformation = driver.findElement(By.id("checkDataID"));
//        buttonCheckInformation.click();                                                 // tuksa iekava, jo uzspiez un viss


        mainPage = new MainPage(driver);                           // tiek inicilizets driver caur konstruktoru!! kas aiziet tālāk uz MainPage klases mainīgo, kur saglabājas
        mainPage.getFirstNameField().sendKeys("John");       // sadi parasti nedara, ka ar "sendKeys" metodi, ka aizpilda tekstu.
        mainPage.getFirstNameField().clear();
        mainPage.setFirstName("John");                             // sadi parasti dara - uztaisa metodi "setFirstName", kas ierakstits tekstu un teksts atnāks kā arguments no parametra
        mainPage.setLastNameField("Berzins");
//        mainPage.clickOnMe();

        Assert.assertFalse(mainPage.getStudentCheckBox().isSelected());                   // parbauda, ka nav iekekseets Checkbox
        mainPage.selectStudentCheckBox();                                                 // iekeksee Checkbox
        Assert.assertTrue(mainPage.getStudentCheckBox().isSelected());                    // parbauda, ka IR ieksests

 // Izprintet visas pieejamas Universities:
        for (WebElement element : mainPage.getAllUniversitiesOptions()) {                 // mainigas "element"
            System.out.println(element.getText());                                        // mainigajam "element" metode getText()
        }

        mainPage.getUniversities().selectByValue("RSU");                                       // izvēlēties tādu caur "value", kuru vajag
        Assert.assertEquals(mainPage.getUniversities().getFirstSelectedOption().getText(), "Rīgas Stradiņa universitāte");
        mainPage.getUniversities().selectByVisibleText("Rīgas Tehniskā universitāte");           // caur "redzamo textu"
        Assert.assertEquals(mainPage.getUniversities().getFirstSelectedOption().getText(), "Rīgas Tehniskā universitāte");


//        Assert.assertEquals(mainPage.getJavaRadioButton().isSelected(), false);
        Assert.assertFalse(mainPage.getJavaRadioButton().isSelected());
        mainPage.getJavaRadioButton().click();
        Assert.assertTrue(mainPage.getJavaRadioButton().isSelected());


//        driver.findElement(By.xpath("testestes")).click();                       // tikai testam prieks netiesas gaidasanas

        mainPage.clickOnMe();
        wait.until(ExpectedConditions.visibilityOf(mainPage.getClickOnMeResult()));   // gaidisim 20 sekundes, lai paraditos elements "ClickOnMeResult" / kad paradas elements, tad viss
//        wait.until(ExpectedConditions.textToBePresentInElement(mainPage.getClickOnMeResult(), "Viss ir labi!"));
        Assert.assertEquals(mainPage.getClickOnMeResult().getText(), "Viss ir labi!");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        log.info("Closing ChromeWebDriver");
        driver.close();                         //  aizver parlukprogrammu, tur Chromedriver datora procesos
        driver.quit();                          // Nogalina driveri/sesiju
    }
}


