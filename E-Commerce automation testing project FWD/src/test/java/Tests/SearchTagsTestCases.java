package Tests;

import Pages.HomePage;
import Pages.SubCategoryListingPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTagsTestCases extends TestBase{

    HomePage homeObj;
    SubCategoryListingPage subObj;

    @Test(priority = 1)
    public void SelectShoesSubCategorySuccessfully()throws InterruptedException{
        homeObj=new HomePage(driver);
        homeObj.OpenApperalCategoryMenu();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("shoes"));
    }

    @Test (priority = 2)
    public void SelectTagSuccessfully(){

        subObj=new SubCategoryListingPage(driver);
        subObj.OpenTagLink();
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(driver.getCurrentUrl().contains("awesome"),"the Url not contain the tag name !!");
        softAssert.assertTrue(subObj.tagPageTitle.getText().contains("products tagged with 'awesome'"),"the title not contain the tag name !!");

    }
}
