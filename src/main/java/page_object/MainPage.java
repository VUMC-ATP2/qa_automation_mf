package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MainPage {

    private WebDriver driver;                                   // seit bus saglabāts "driver" kas atnāca no jebkuras klases -ša jā gadījumā no "BrowserTest"

    public MainPage(WebDriver driver) {                         // kad izveidot caur konstruktoru jaunu "driver", to caur this.driver saglabā klases līmenī augšā
        this.driver = driver;                                   //  stradas ar to driver, kurs tika inicializets. Saja klase vares manipulet ar inicializeto driveri.
    }

    private By firstNameField = By.id("fNameID");                    // tiek definets, kā elementu atrast (sis NAV elements!). elements bus tad, kad izsauks driver + to elementu
    private By lastNameField = By.id("lNameID");
    private By aboutMeField = By.id("aboutMeID");
    private By clickOnMeButton = By.xpath("//button[@id='checkDataID']");
    private By clickOnMeResult = By.id("checkDataResultID");
    private By studentCheckBox = By.xpath("//input[@id='studentID' and @type='checkbox']");
    private By universitiesList = By.name("universities");
    private By javaRadioButton = By.id("javaID");
// private By javaRadioButton = By.xpath("//label[@for='javaID']");     // reizem nevar ieclickot uz "izput", bet click uz "label" - LABAK UZ LABEL, jo Radiobutton ir MAZS

// Field - Name:
    public WebElement getFirstNameField() {                             // getteris - kura atgriez WebElement
        return driver.findElement(firstNameField);                      // izmantojot dirver, kas atnāk no "Browser Test", kad veidojam MainPage objektu (izmantojot konstruktoru)
    }
    public void setFirstName(String value) {
        driver.findElement(firstNameField).sendKeys(value);            // setteris, kas ierakstits tekstu.
    }


// Field - Surname:
    public WebElement getLastNameField() {
        return driver.findElement(lastNameField);
    }
    public void setLastNameField(String value) {
        driver.findElement(lastNameField).sendKeys(value);
    }


// Field - Information about me:
    public WebElement getAboutMeField() {
        return driver.findElement(aboutMeField);
    }
    public void setAboutMeField(String value) {
        driver.findElement(aboutMeField).sendKeys(value);
    }


// Button - click on me:
    public void clickOnMe() {                              // METODE, lai uzspiestu, NEVAJAG getter, setter, bet CLICK TIKAI
        driver.findElement(clickOnMeButton).click();
    }
    public WebElement getClickOnMeResult() {
        return driver.findElement(clickOnMeResult);
    }


// Checkbox - Student:
    public void selectStudentCheckBox() {                              // select - lai ieliktu keksi Checkbox
        driver.findElement(studentCheckBox).click();
    }
    public WebElement getStudentCheckBox() {
        return driver.findElement(studentCheckBox);
    }


// Dropdown - Universities:
    public List<WebElement> getAllUniversitiesOptions() {                                          // getteris, kas atgriezis sarakstu ar web objektu elementiem
        return new Select(driver.findElement(universitiesList)).getOptions();                      // getOptions - atgriezis listu ar options/izvelnem
    }
    public Select getUniversities() {
        return new Select(driver.findElement(universitiesList));
    }       // metode, kas atgriezis to Selectu


// Radiobuttons - JAVA, HTML:
    public WebElement getJavaRadioButton() {
        return driver.findElement(javaRadioButton);
    }
}