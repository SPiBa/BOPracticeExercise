package Helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

public class Utils {
    public WebDriver driver;

    public void takeScreenshot() throws IOException {
        Date t_now = new Date();
        TakesScreenshot tsc = (TakesScreenshot) driver;
        File srcFile = tsc.getScreenshotAs(OutputType.FILE);
        File destFile = new File("/Users/sindhupai/Documents/SePractice/BOPracticeExercise/src/Screenshots/IMG" + t_now +".png");
        //Files.copy(srcFile, destFile);
    }
}
