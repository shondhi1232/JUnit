import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class check_img_exist {

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
    public  void _2_checkImgExist_2(){
        driver.get("https://demoqa.com/");
//        WebElement imgElement = driver.findElement(By.xpath(" //img[@src='/images/Toolsqa.jpg']"));
//        boolean statusActual = imgElement.isDisplayed();
        //       Assert.assertEquals((statusActual),true);

        //you can write this short code rather than previous 3 line of code
        //this line of code is without Explicitly waited
        // Assert.assertTrue(driver.findElement(By.xpath(" //img[@src='/images/Toolsqa.jpg']")).isDisplayed());

        //use it specific element if it needs more time to run or take more time to load
        //these line of codes are with Explicitly waiter
        WebElement imageElement = driver.findElement(By.xpath(" //img[@src='/images/Toolsqa.jpg']"));
        //ExplicitForTheElement method call from Utils class
        Utils.ExplicitForTheElement(driver, imageElement, 40);

        Assert.assertTrue(imageElement.isDisplayed());

    }

}
