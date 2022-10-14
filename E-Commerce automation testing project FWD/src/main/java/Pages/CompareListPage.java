package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareListPage extends BasePage {

    public CompareListPage(WebDriver driver){

        super(driver);
    }

    @FindBy(linkText = "product comparison")
    public WebElement compareListLink ;

    public void openCompareList(){

        clickONButton(compareListLink);
    }
}
