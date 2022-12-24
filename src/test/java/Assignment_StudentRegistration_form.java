import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Assignment_StudentRegistration_form {

    WebDriver driver;
    @Before
    public  void setup(){
        System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void submitForm() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys("shondi");
        driver.findElement(By.id("lastName")).sendKeys("Akter");
        driver.findElement(By.id("userEmail")).sendKeys("shondi@test.com");

    }
    @Test
    public void select_RadioButton(){
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.xpath("//label[text()='Female']")).click();

    }
    @Test
    public void enterPhoneNumber(){
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("userNumber")).sendKeys("01335932998");
    }
    @Test
    public void selectDateOfBirth(){
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("dateOfBirthInput")).click();
        WebElement dropdown1 = driver.findElement(By.className("react-datepicker__month-select"));
        Select option = new Select(dropdown1);
        option.selectByValue("0");

        WebElement dropdown2 = driver.findElement(By.className("react-datepicker__year-select"));
        Select option2 = new Select(dropdown2);
        option2.selectByVisibleText("2000");
        driver.findElement(By.xpath("//div[text()='1']")).click();
    }
    @Test
    public void subjectWrite(){
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("subjectsInput")).sendKeys("JavasScript");
    }
    @Test
    public void selectCheckBox(){
        driver.get("https://demoqa.com/automation-practice-form");


        //driver.findElement(By.id("hobbies-checkbox-1")).click();

        //Selecting the first checkbox using XPath
        driver.findElement(By.xpath("//label[text()='Sports']")).click();
        driver.findElement(By.xpath("//label[text()='Reading']")).click();

        //Selecting the last check box
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']")).click();
    }
    @Test
    public void uploadImage(){

        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\baby.jpg");
    }
    @Test
    public void writeCurrentAddress(){

        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("currentAddress")).sendKeys("Dhaka,Bangladesh");
    }

    public void selectSateAndCity(){
        driver.get("https://demoqa.com/automation-practice-form");
            //not work
        driver.findElement(By.xpath("//div[text()='Rajasthan']")).click();

    }
    @Test
    public void submitButton(){
        driver.get("https://demoqa.com/automation-practice-form");

        driver.findElement(By.id("submit")).click();
    }

}
