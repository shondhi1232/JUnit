import org.junit.Assert;
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

public class MouseHover {
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
