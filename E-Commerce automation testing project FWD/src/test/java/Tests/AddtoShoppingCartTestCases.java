package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddtoShoppingCartTestCases extends TestBase {
    public AddtoShoppingCartTestCases(WebDriver driver){ super(driver);}


    HomePage homeObj;
    SerachPage searchObj;
    ProductsDetailsPage DetailsPage;
    ShoppingCartPage shopObj;
    String ProductName ="Lenovo";

    @Test(priority = 1)

    public void SearchByProductSuccessfully() throws InterruptedException{
        searchObj =new SerachPage(driver);
        searchObj.SearchProduct(ProductName);
    }

    @Test(priority = 2)

    public void AddProductsToShoppingCart()throws InterruptedException{
        SoftAssert soft = new SoftAssert();
        DetailsPage = new ProductsDetailsPage(driver);
        homeObj = new HomePage(driver);
        shopObj = new ShoppingCartPage(driver);
        Thread.sleep(2000);
        searchObj.AddProductToCart();
        searchObj.OpenDetailsPagofProduct();
        Thread.sleep(2000);
        DetailsPage.AddProductToShoppingCart();
        Thread.sleep(2000);
        System.out.println("Number of products on shopping Cart= "+homeObj.ShoppingCartCount.getText());
        soft.assertTrue(homeObj.ShoppingCartCount.getText().contains("(2"));


        soft.assertTrue(shopObj.SuccessMessage.isDisplayed(),"success message issue");

        homeObj.OpenShoppingCart();
        System.out.println("Number of Rows= "+shopObj.NumberofProductsonCart.size());
        soft.assertTrue((shopObj.NumberofProductsonCart.size()-5)==2);



    }

    @Test(priority = 3)

    public void RemoveProductFromShoppingCart()
    {
        homeObj.OpenShoppingCart();
        shopObj.RemoveProductFromShoppingCART();
        Assert.assertTrue(shopObj.NoDataMessage.getText().contains("Your shopping cart is empty!"));
        Assert.assertTrue(homeObj.ShoppingCartCount.getText().contains("(0)"));

    }
}
