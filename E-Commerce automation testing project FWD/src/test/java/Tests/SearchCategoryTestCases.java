package Tests;

import Pages.HomePage;
import org.testng.Assert;

public class SearchCategoryTestCases extends TestBase{

    HomePage home;
    public void SelectCategoryAndSubCategorySuccessfully()throws InterruptedException{
        Thread.sleep(1000);
        home = new HomePage(driver);
        home.OpenCategoryMenu();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("desktop"));
    }
}
