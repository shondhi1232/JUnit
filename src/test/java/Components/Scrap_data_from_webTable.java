package Components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;
import java.util.List;

public class Scrap_data_from_webTable {

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
    public void scrap_data(){

        driver.get("https://demoqa.com/webtables");
        WebElement table = driver.findElement(By.className("rt-tbody"));
        List<WebElement> allRows = table.findElements(By.className("rt-tr"));

        int i = 0;
        for (WebElement row: allRows){
            List<WebElement> cells = row.findElements(By.className("rt-td"));

            for (WebElement cell: cells){
                i++;
                        System.out.println("num["+i+"]"+ cell.getText());
            }
        }

    }
}
