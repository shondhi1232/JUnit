import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.ArrayList;

public class Handle_Multiple_tab {
    WebDriver driver;
    @Before
    public  void setup(){
        //System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void handleMultipleTab() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(3000);
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());

        //switch to open tab
        driver.switchTo().window(tab.get(1));
        String text = driver.findElements(By.id("sampleHeading")).get(0).getText();
        Assert.assertTrue(text.contains("This is a sample page"));
        driver.close();
        driver.switchTo().window(tab.get(0));

    }
}
