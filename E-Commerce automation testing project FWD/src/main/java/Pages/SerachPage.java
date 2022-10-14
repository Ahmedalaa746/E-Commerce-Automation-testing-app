package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SerachPage extends BasePage{
    public SerachPage(WebDriver driver){
        super(driver);

    }

    @FindBy (id = "small-searchterms")
    WebElement GeneralSerachTxtBox ;

    @FindBy(css = "button[class=\"button-1 search-box-button\"]")
    WebElement SearchBtn;

    @FindBy(css = "h2[class=\"product-title\"]")
    public List<WebElement>productTitle;

    @FindBy(css = "span[class=\"price actual-price\"]")
    public List<WebElement>ProductPricesLbl;

    @FindBy(css = "button[title=\"Add to wishlist\"]")
    public List<WebElement>WishesListBtn;

    @FindBy(xpath = "//button[@class=\"button-2 product-box-add-to-cart-button\"]")
    public List<WebElement>AddToCartBtn;

    @FindBy(xpath = "//div[@class=\"buttons\"]//button[@class=\"button-2 add-to-compare-list-button\"]")
    public List<WebElement>CompareBtn;

    public void SearchProduct(String ProductName)
    {
        InsertDataTextBox(GeneralSerachTxtBox , ProductName);
        clickONButton(SearchBtn);
    }

    public void AddProductToWishesListFromSearchResult()
    {
        clickONButton(WishesListBtn.get(0));
    }

    public void AddProductToCompareList()
    {
        clickONButton(CompareBtn.get(0));
    }

    public void AddProductToCart()
    {
        clickONButton(AddToCartBtn.get(0));
    }

    public void OpenDetailsPagofProduct()
    {
        clickONButton(productTitle.get(1));
    }

    public  String GetTheProductName ()
    {
        String ProductName= productTitle.get(0).getText().toString();
        return (ProductName);
    }

}
