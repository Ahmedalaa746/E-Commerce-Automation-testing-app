package Tests;

import Pages.HomePage;
import Pages.ProductsDetailsPage;
import Pages.SerachPage;
import Pages.WishesListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishesListTestCases extends TestBase{
    SerachPage searchObj;
    ProductsDetailsPage DetailPage;
    HomePage homeObj;
    WishesListPage wishObj;
    String ProductName ="Laptop";

    @Test(priority = 1)
    public void SearchByProductSuccessfully()throws InterruptedException{
        searchObj=new SerachPage(driver);
        searchObj.SearchProduct(ProductName);

    }

    @Test(priority = 2)
    public void AddProductsToWishesList()throws InterruptedException{
        DetailPage=new ProductsDetailsPage(driver);
        homeObj= new HomePage(driver);
        Thread.sleep(2000);
        searchObj.AddProductToWishesListFromSearchResult();
        searchObj.OpenDetailsPagofProduct();
        Thread.sleep(2000);
        DetailPage.AddToWishListFromProductDetails();
        Thread.sleep(2000);
        Assert.assertTrue(homeObj.WishListCount.getText().contains("(2)"));

        homeObj.OpenWishesList();
        wishObj=new WishesListPage(driver);
        System.out.println("Number of rows =  "+wishObj.tabelRows.size());
        Assert.assertTrue((wishObj.tabelRows.size()-1)==2);

    }

    @Test(priority = 3)
    public void RemoveProductFromWishesList()
    {
        wishObj.removeProsudtFromWishesList();
        Assert.assertTrue(wishObj.NoDataMessage.getText().contains("The wsihlist is empty!"));

    }
}
