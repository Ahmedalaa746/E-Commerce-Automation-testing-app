package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    // Method to take screenshots when testcases are fail

    public static void SaveScreenShots (WebDriver driver, String ScreenshotName){
        Path location = Paths.get("./ScreenShots",ScreenshotName+" .png");
        try {
            Files.createDirectory(location.getParent());
            FileOutputStream fileOutputStream =new FileOutputStream(location.toString());
            fileOutputStream.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            fileOutputStream.close();
        }
        catch (IOException e){
            System.out.println("Expection occurs while taking screenshot");
            e.printStackTrace();
        }
    }
}
