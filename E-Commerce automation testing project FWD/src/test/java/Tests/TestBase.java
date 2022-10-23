package Tests;

import Utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase {
    WebDriver driver=null;

    @BeforeClass
    public void openChrome()throws InterruptedException{

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");

        Thread.sleep(2000);

    }

    @AfterClass
    public void CloseChrome()throws InterruptedException{

        Thread.sleep(2000);
        driver.quit();
    }

    // if the test case is fail ,take screenshot

    @AfterMethod
    public void TakeScreenShot(ITestResult res){
        if (res.getStatus() ==ITestResult.FAILURE){
            System.out.println("Test case fail, and taking screenshots");
            Helper.SaveScreenShots(driver,res.getName());

        }
    }
}
