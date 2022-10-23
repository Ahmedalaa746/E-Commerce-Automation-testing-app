package Tests;

import Pages.HomePage;
import Pages.ProductsDetailsPage;
import Pages.SubCategoryListingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterByColorTestCases extends TestBase{
    HomePage homeObj ;
    SubCategoryListingPage subObj;
    ProductsDetailsPage detailsObj;

    @Test(priority = 1)
    public void  SelectShoesSubCategorySuccessfully()throws InterruptedException{
        homeObj = new HomePage(driver);
        homeObj.OpenApperalCategoryMenu();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("shoes"));
    }

    @Test(priority = 2)
    public void FilterByColorSuccessfully()throws InterruptedException{
        subObj=new SubCategoryListingPage(driver);
        subObj.FilterByRedColor();
        Thread.sleep(2000);
        Assert.assertTrue(subObj.RedColorCheckBox.isSelected());

    }

    @Test(priority = 3)
    public void CheckColorOnDetailsPageofProduct()throws InterruptedException{

        detailsObj =new ProductsDetailsPage(driver);
        subObj.OpenDetailsPageOfFirstProduct();
        System.out.println("the available color of the product = "+ detailsObj.ColorBoxes.get(0).getCssValue("background-color"));
        Assert.assertTrue(detailsObj.ColorBoxes.get(0).getCssValue("background-color").contains("rgba(101 ,50 ,50 ,1"));

    }
}
