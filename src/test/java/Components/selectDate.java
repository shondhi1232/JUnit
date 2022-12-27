package Components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class selectDate {
    WebDriver driver;
    @Before
    public  void setup(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
}
