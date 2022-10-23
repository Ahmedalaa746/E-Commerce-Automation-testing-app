package Tests;

import Pages.HomePage;
import Pages.SerachPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTestCases extends TestBase {

    HomePage homeObj;
    SerachPage searchObj;
    String ProductName="Apple";


    @Test (priority = 1)
    public void UserChangeCurrencyToEuroSuccessfully(){
        homeObj=new HomePage(driver);
        homeObj.ChangeCurrency("Euro");
    }

    @Test(priority = 2)
    public void SearchByProductSuccessfully() throws InterruptedException{
        searchObj=new SerachPage(driver);
        searchObj.SearchProduct(ProductName);
        Thread.sleep(2000);
        for (WebElement Price: searchObj.ProductPricesLbl){
            System.out.println(Price.getText());
            Assert.assertTrue(Price.getText().contains("&"));
        }
    }

    @Test (priority = 3)

    public void UserChangeCurrencyToDollarSuccessfully(){
        homeObj=new HomePage(driver);
        homeObj.ChangeCurrency("US Dollar");
        for (WebElement Price:searchObj.ProductPricesLbl){
            System.out.println(Price.getText());
            Assert.assertTrue(Price.getText().contains("$"));
        }
    }
}
