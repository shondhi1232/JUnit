package Components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDown {

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
    public void selectDropDown(){
        driver.get("https://demoqa.com/select-menu");
        WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
        Select option = new Select(dropdown);
        //option.selectByIndex(1);
        //option.selectByValue("2");
        option.selectByVisibleText("Yellow");
    }

    @Test
    public void multipleDropDown(){
        driver.get("https://demoqa.com/select-menu");
        WebElement dropdown = driver.findElement(By.name("cars"));
        Select option = new Select(dropdown);
        if (option.isMultiple()) {
            option.selectByVisibleText("Volvo");
            option.selectByVisibleText("Audi");
        }
    }
}
