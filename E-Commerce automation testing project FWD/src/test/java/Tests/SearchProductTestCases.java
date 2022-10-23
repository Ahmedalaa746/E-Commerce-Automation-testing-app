package Tests;

import Pages.SerachPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchProductTestCases extends TestBase{

    SerachPage searchObj;
    String ProductName= "Laptop";

    @Test
    public void SearchByProductSuccessfully()throws InterruptedException{
        searchObj =new SerachPage(driver);
        searchObj.SearchProduct(ProductName);
        Thread.sleep(2000);
        for (WebElement Product: searchObj.productTitle){
            System.out.println(Product.getText().contains(ProductName));

        }
        System.out.println(searchObj.GetTheProductName());
    }
}
