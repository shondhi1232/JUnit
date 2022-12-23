import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class MouseHover {
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

    //you can search this way, or you can use below method
    //mouse hover on the about us
    @Test
    public void hoverMenu(){
        driver.get("https://green.edu.bd/");
        List<WebElement> aboutUsElem = driver.findElements(By.className("dropdown-toggle"));
        //aboutUsElem.get(0).click();
        Actions action = new Actions(driver);
        action.moveToElement(aboutUsElem.get(0)).perform();
    }
    /*
    //in this method used customised/ create xpath own
    @Test
    public void hoverMenu(){
        driver.get("https://green.edu.bd/");
        List<WebElement> aboutUsElem = driver.findElements(By.xpath("//a[contains(text(),'About Us')]"));
        aboutUsElem.get(2).click();

         Actions action = new Actions(driver);
        action.moveToElement(aboutUsElem.get(2)).perform();
    }
     */

    //only click on the about us
    @Test
    public void ClickMenu(){
        driver.get("https://green.edu.bd/");
        List<WebElement> aboutUsElem = driver.findElements(By.className("dropdown-toggle"));
        aboutUsElem.get(0).click();
    }


}
