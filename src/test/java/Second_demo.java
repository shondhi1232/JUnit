import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

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
    public void buttonClick(){
        driver.get("https://demoqa.com/buttons");
        Actions action = new Actions(driver);
        WebElement btn= driver.findElement(By.id("doubleClickBtn"));
        action.doubleClick(btn).perform();
    }
}
