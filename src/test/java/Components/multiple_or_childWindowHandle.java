package Components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class multiple_or_childWindowHandle {

    WebDriver driver;
    @Before
    public  void setup(){
       // System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void handleMultipleWindow(){
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("windowButton")).click();
        String mainWindowHandle = driver.getWindowHandle();

        Set<String> allWindowHandle = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandle.iterator();

        while (iterator.hasNext()){
            String childWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                String text = driver.findElements(By.id("sampleHeading")).get(0).getText();
                Assert.assertTrue(text.contains("This is a sample page"));

            }

        }
        driver.close();
        driver.switchTo().window(mainWindowHandle);
    }

}
