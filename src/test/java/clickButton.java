import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class clickButton {

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
}
