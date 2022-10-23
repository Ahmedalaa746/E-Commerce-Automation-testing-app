package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckOutTestCases extends TestBase {

    SerachPage searchObj ;
    HomePage homeObj ;
    String ProductName="Laptop";
    ShoppingCartPage shopObj;
    RegistrationPage registerObj;
    CheckOutPage checkObj;
    String email="test44@aa.com";

    @Test(priority = 1)

    public void UserCanRegisterSuccessfully()
    {
        homeObj=new HomePage(driver);
        registerObj=new RegistrationPage(driver);
        homeObj.OpenRegisterationForm();
        registerObj.Registration("Ghada","Ahmed",email,"aa@12345");
        Assert.assertTrue(registerObj.SuccessMsg.getText().contains("Your registration completed"),"the user can't register!!");

    }
    @Test(priority = 2)

    public void SerachByProductSuccessfully() throws InterruptedException{
        Thread.sleep(2000);
        searchObj=new SerachPage(driver);
        searchObj.SearchProduct(ProductName);

    }
    @Test (priority = 3,dependsOnMethods = {"SearchByProductSuccessfully"})
    public void AddProductsToShoppingCart() throws InterruptedException{
        SoftAssert soft =new SoftAssert();
        homeObj=new HomePage(driver);
        shopObj=new ShoppingCartPage(driver);
        Thread.sleep(2000);
        searchObj.AddProductToCart();
        Thread.sleep(2000);
        soft.assertTrue(homeObj.ShoppingCartCount.getText().contains("(1)"));

        homeObj.OpenShoppingCart();
        System.out.println("Number of Rows= "+shopObj.NumberofProductsonCart.size());
        soft.assertTrue((shopObj.NumberofProductsonCart.size()-5)==1,"the number of products on shopping cart not correct!");

    }
    @Test(priority = 4,dependsOnMethods = {"AddproductsToshoppingCart"})
    public void LoggedUserCanCheckoutSuccessfully()throws InterruptedException{
        SoftAssert soft = new SoftAssert();
        checkObj=new CheckOutPage(driver);
        shopObj.SelectTermsofservice();
        shopObj.openCheckOutPage();
        Thread.sleep(3000);
        checkObj.EnterBillingAddress("Cairo","74 cairo","7420","01000074");
        Thread.sleep(2000);
        soft.assertTrue(checkObj.successMessage.isDisplayed(),"issue of success message");
        soft.assertTrue(checkObj.OrderNumberTxt.isDisplayed(),"issue of order Number");
    }


}
