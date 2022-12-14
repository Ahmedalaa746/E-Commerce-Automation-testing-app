package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage{

    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }

    @FindBy (tagName = "tr")
    public List<WebElement>NumberofProductsonCart;

    @FindBy(xpath = "//button[@class=\"remove-btn\"]")
    List<WebElement> RemoveProductIcons;

    @FindBy(id = "checkout")
    WebElement CheckoutBtn;

    @FindBy(xpath = "//div[@class=\"no-data\"]")
    public WebElement NoDataMessage ;

    @FindBy(id = "termsofservice")
    WebElement termsOfServiceCheckBox;

    @FindBy(linkText = "shopping cart")
    public WebElement SuccessMessage;

    public void SelectTermsofservice(){ clickONButton(termsOfServiceCheckBox);}

    public void openCheckOutPage(){clickONButton(CheckoutBtn);}

    public void RemoveProductFromShoppingCART()
    {
        for (WebElement icon : RemoveProductIcons)
        {
            clickONButton(RemoveProductIcons.get(0));
        }
    }
}
