import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.Keys.*;
import static org.openqa.selenium.Keys.ARROW_DOWN;

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
        driver.findElement(By.id("firstName")).sendKeys("sand");
        driver.findElement(By.id("lastName")).sendKeys("milo");

        driver.findElement(By.id("userEmail")).sendKeys("sand@test.com");

        //select gender from radio button
        driver.findElement(By.xpath("//label[text()='Female']")).click();

        driver.findElement(By.id("userNumber")).sendKeys("01235932998");

        //select Date of birth from calendar
        driver.findElement(By.id("dateOfBirthInput")).click();
        WebElement dropdown1 = driver.findElement(By.className("react-datepicker__month-select"));
        Select option = new Select(dropdown1);
        option.selectByValue("0");

        WebElement dropdown2 = driver.findElement(By.className("react-datepicker__year-select"));
        Select option2 = new Select(dropdown2);
        option2.selectByVisibleText("2000");
        driver.findElement(By.xpath("//div[text()='1']")).click();

        //write subject
        driver.findElement(By.id("subjectsInput")).sendKeys("JavasScript");

        //Selecting the hobbies from checkbox using XPath
        //driver.findElement(By.id("hobbies-checkbox-1")).click();
        driver.findElement(By.xpath("//label[text()='Sports']")).click();
        driver.findElement(By.xpath("//label[text()='Reading']")).click();

        //Selecting the last check-box
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']")).click();

        //upload image
        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\baby.jpg");

        //write current address in the text box
        driver.findElement(By.id("currentAddress")).sendKeys("Dhaka,Bangladesh");

        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //javaScript scroll down code, and it is executing by javascriptExecutor and it is done through driver.
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        //select sate
        Actions action = new Actions(driver);
        List<WebElement> sateBtn =driver.findElements(By.className("css-yk16xz-control"));
        WebElement selectBtn = sateBtn.get(1);
        action.click(selectBtn).perform();
        Thread.sleep(2000);
        action.keyDown(selectBtn,DOWN).click().perform();
        action.keyDown(selectBtn,ENTER).perform();

        //select city
        Actions actionCT = new Actions(driver);
        WebElement city = driver.findElement(By.id("city"));
        actionCT.click(city).perform();
        Thread.sleep(4000);
        actionCT.keyDown(city,DOWN).click().perform();
        actionCT.keyDown(city,ENTER).perform();

        //submit button click
        Actions action3 = new Actions(driver);
        WebElement submit =driver.findElement(By.cssSelector("[type=submit]"));
        action3.click(submit).perform();

//----------------------------------------------------------------------------
        //submit Assertion
        WebElement txtData = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Thread.sleep(2000);
        String actualData = txtData.getText();
        String expectedData = "Thanks for submitting";
        Assert.assertTrue(actualData.contains(expectedData));

        //UserName Assertion
        List<WebElement> td1 = driver.findElements(By.tagName("td"));
        String nameActual = td1.get(1).getText();
        String nameExpected = "sand";
        Assert.assertTrue(nameActual.contains(nameExpected));

        //student email assertion
        List<WebElement> td2 = driver.findElements(By.tagName("td"));
        String mailActual = td2.get(3).getText();
        String mailExpected = "sand@test.com";
        Assert.assertTrue(mailActual.contains(mailExpected));

        //Gender assertion
        List<WebElement> td3 = driver.findElements(By.tagName("td"));
        String genderActual = td3.get(5).getText();
        String genderExpected = "sand@test.com";
        Assert.assertTrue(genderActual.contains(genderExpected));

        //mobile
        List<WebElement> td4 = driver.findElements(By.tagName("td"));
        String mobileActual = td4.get(7).getText();
        String mobileExpected = "01235932998";
        Assert.assertTrue(mobileActual.contains(mobileExpected));

        //Date of birth
        List<WebElement> td5 = driver.findElements(By.tagName("td"));
        String DBActual = td5.get(9).getText();
        String DBExpected = "01 January,2000";
        Assert.assertTrue(DBActual.contains(DBExpected));

        //Subject assertion
        List<WebElement> td6 = driver.findElements(By.tagName("td"));
        String subjectActual = td6.get(11).getText();
        String subjectExpected = "JavasScript";
        Assert.assertTrue(subjectActual.contains(subjectExpected));

        //hobbies assertion
        List<WebElement> td7 = driver.findElements(By.tagName("td"));
        String hobbyActual = td7.get(13).getText();
        String hobbyExpected = "Sports";
        Assert.assertTrue(hobbyActual.contains(hobbyExpected));

        //Address assertion
        List<WebElement> td8 = driver.findElements(By.tagName("td"));
        String addressActual = td8.get(17).getText();
        String addressExpected = "Dhaka";
        Assert.assertTrue(addressActual.contains(addressExpected));

        //State and City
        List<WebElement> td9 = driver.findElements(By.tagName("td"));
        String scActual = td9.get(19).getText();
        String scExpected = "NCR";
        Assert.assertTrue(scActual.contains(scExpected));

    }

}
