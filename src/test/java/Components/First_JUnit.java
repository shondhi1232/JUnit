package Components;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import java.time.Duration;

public class First_JUnit {
    //Web Driver is the parent class
    WebDriver driver;
    @Before
    public  void setup(){
        System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        //visible the brower it's by default
        ops.addArguments("--headed");
        /*
        //doesn't show or visible the brower
        ops.addArguments("--headless");

         */
                     //child class of webdriver class
        driver = new FirefoxDriver(ops);
        //miximize the web driver space
        driver.manage().window().maximize();
        //set the time that how much system will stay if it could not find the search element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }
    @Test
    public void _1_getTitle(){
        driver.get("https://demoqa.com/");
        String titleActual = driver.getTitle();
        System.out.println(titleActual);
        String titleExpected = "ToolsQA";
        //checking is expected result is matched with actual result
        Assert.assertEquals(titleExpected,titleActual);
       // Assert.assertTrue(title.contains("ToolsQA"));
    }

/*
    @After
    public  void finishTest(){
        driver.close();
    }
 */
}