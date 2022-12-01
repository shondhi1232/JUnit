import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class First_JUnit {
    WebDriver driver;
    @Before
    public  void setup(){
        System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }
    @Test
    public void getTitle(){
        driver.get("https://demoqa.com/");
        String titleActual = driver.getTitle();
        System.out.println(titleActual);
        String titleExpected = "ToolsQA";
        Assert.assertEquals(titleExpected,titleActual);
       // Assert.assertTrue(title.contains("ToolsQA"));
    }
    @Test
    public  void checkImgExist(){
        driver.get("https://demoqa.com/");
        WebElement imgElement = driver.findElement(By.xpath(" //img[@src='/images/Toolsqa.jpg']"));
        boolean statusActual = imgElement.isDisplayed();
        Assert.assertEquals((statusActual),true);
    }
/*
    @After
    public  void finishTest(){
        driver.close();
    }
 */
}