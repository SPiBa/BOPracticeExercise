package Tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/sindhupai/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void setHomePage(){
        driver.get("https://spree-vapasi.herokuapp.com");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void takeScreenshot() throws IOException {
        Date t_now = new Date();
        TakesScreenshot tsc = (TakesScreenshot) driver;
        File srcFile = tsc.getScreenshotAs(OutputType.FILE);
        File destFile = new File("/Users/sindhupai/Documents/SePractice/BOPracticeExercise/src/Screenshots/IMG" + t_now +".png");
        FileUtils.copyFile(srcFile,destFile);
    }
}
