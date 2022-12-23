import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utils {
    public static void ExplicitForTheElement(WebDriver driver,WebElement WebElement,int second){

        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOf((WebElement)));

    }

    public static void takeScreenShort(WebDriver driver) throws IOException {

        File screenShortFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenShot/"+time+".png";
        File DestinationFile = new File(fileWithPath);
        FileUtils.copyFile(screenShortFile,DestinationFile);
    }

}
