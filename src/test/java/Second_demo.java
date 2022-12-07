import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class Second_demo {
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
    public void submitForm(){
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("shondi Akter");
        driver.findElement(By.id("userEmail")).sendKeys("shondi@test.com");
        driver.findElement(By.cssSelector("[id=currentAddress]")).sendKeys("Dhaka, Bangladesh");
        driver.findElement(By.cssSelector("[id = permanentAddress]")).sendKeys("Dhaka, Bangladesh");
        driver.findElement(By.id("submit")).click();
    }

    @Test
    public void submitFormUsingTagName(){
        driver.get("https://demoqa.com/text-box");
        List<WebElement> textElement =  driver.findElements(By.tagName("input"));
        textElement.get(0).sendKeys("shondi Akter");
        textElement.get(1).sendKeys("shondi@test.com");
        driver.findElement(By.id("submit")).click();
    }

    @Test
    public void DoubleButtonClick(){
        driver.get("https://demoqa.com/buttons");
        Actions action = new Actions(driver);
        WebElement btn= driver.findElement(By.id("doubleClickBtn"));
        action.doubleClick(btn).perform();
    }

    @Test
    public void ButtonClick(){
        driver.get("https://demoqa.com/buttons");
        Actions action = new Actions(driver);
        List<WebElement> buttons =  driver.findElements(By.cssSelector("[type = button]"));
        action.doubleClick(buttons.get(1)).perform();
        action.contextClick(buttons.get(2)).perform();
        action.click(buttons.get(3)).perform();

        //button response message find and assert using tag p
        List<WebElement> messages =  driver.findElements(By.tagName("p"));
        String message1Actual = messages.get(0).getText();
        String message1Expected = "You have done a double click";
        Assert.assertTrue(message1Expected.contains(message1Actual));


        String message2Actual = messages.get(1).getText();
        String message2Expected = "You have done a right click";
        Assert.assertTrue(message2Expected.contains(message2Actual));


        String message3Actual = messages.get(2).getText();
        String message3Expected = "dynamic click";
        Assert.assertTrue(message3Actual.contains(message3Expected));
    }

    @Test
    public void handleAlart() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        //Thread.sleep(200);
        driver.switchTo().alert().accept();

        //driver.findElement(By.id("button")).click();
        //Thread.sleep(600);
        //driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();
        String actualMsg= driver.findElement(By.id("confirmResult")).getText();
        String expectedMsg="Cancel";
        Assert.assertTrue(actualMsg.contains(expectedMsg));

        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("shondhi");
        driver.switchTo().alert().accept();

    }
    @Test
    public void selectDate(){
        driver.get("https://demoqa.com/date-picker");
        driver.findElement(By.id("datePickerMonthYearInput")).clear();
        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys("12/07/22");

        //calendar will disappear
       // driver.findElement(By.tagName("body")).click();

        //If body tag doesn't work than we can use this command
        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys(Keys.ENTER);
    }
    @Test
    public void selectDateByKeyboard(){
        driver.get("https://demoqa.com/date-picker");
        Actions action = new Actions(driver);
        WebElement datePicker = driver.findElement(By.id("datePickerMonthYearInput"));

        //always don't work
        //action.moveToElement(datePicker);
       // action.doubleClick(datePicker).click().keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();

        //another way to remove the text in the datePicker
        //easier way before one
        //this command work as keyboard   control+a
        datePicker.sendKeys(Keys.CONTROL+"a");
        datePicker.sendKeys(Keys.BACK_SPACE);
    }
    public void selectDropDown(){
        driver.get("");
    }
}
