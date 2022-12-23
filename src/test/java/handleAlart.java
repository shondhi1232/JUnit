import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class handleAlart {

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
}
