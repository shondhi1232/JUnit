package Components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class upload_and_Download_Image {

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
    public void uploadImage(){
        driver.get("https://demoqa.com/upload-download");
        WebElement uploadElement = driver.findElement(By.id("uploadFile"));
        uploadElement.sendKeys("C:\\baby.jpg");

        String text = driver.findElements(By.id("uploadedFilePath")).get(0).getText();
        Assert.assertTrue(text.contains("baby.jpg"));
    }

    @Test
    public void downloadImage(){
        driver.get("https://demoqa.com/upload-download");
        driver.findElement(By.id("downloadButton")).click();

    }
}
