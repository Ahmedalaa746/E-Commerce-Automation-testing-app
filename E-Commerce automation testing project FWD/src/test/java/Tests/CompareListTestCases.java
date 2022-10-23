package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareListTestCases extends TestBase{

    SerachPage serachObj ;
    ProductsDetailsPage DetailsPage;
    HomePage homeObj ;
    WishesListPage WishObj;
    CompareListPage compareObj;
    String ProductName = " Laptop";

    @Test(priority = 1)
    public  void SerachByProductSuccessfully()throws InterruptedException{
        serachObj= new SerachPage(driver);
        serachObj.SearchProduct(ProductName);
    }

    @Test(priority = 2)
    public void AddProductsToWishesList()throws InterruptedException{
        DetailsPage=new ProductsDetailsPage(driver);
        compareObj =new CompareListPage(driver);
        Thread.sleep(2000);
        serachObj.AddProductToCompareList();
        Thread.sleep(2000);
        Assert.assertTrue(compareObj.compareListLink.isDisplayed());
        serachObj.OpenDetailsPagofProduct();
        Thread.sleep(2000);
        DetailsPage.AddProductToCompareList();
        Thread.sleep(1000);
        Assert.assertTrue(compareObj.compareListLink.isDisplayed());
        compareObj.openCompareList();
        Assert.assertTrue(driver.getCurrentUrl().contains ("compare products"),"issue of compare list");


    }
}
