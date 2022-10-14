package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    @FindBy (id = "gender-male")
    WebElement MaleRadioBtn ;

    @FindBy (id = "gender-female")
    WebElement FemaleRadioBtn;

    @FindBy(id = "FirstName")
    WebElement FirstNameTxtBox ;

    @FindBy(id = "LastName")
    WebElement LastNameTxtBox ;

    @FindBy(xpath = "//select[@name=\"DateOfBirthDay\"]")
    WebElement DayBirth;

    @FindBy(xpath = "//select[@name=\"DateOfBirthMonth\"]")
    WebElement MonthBirth ;

    @FindBy(xpath = "//select[name=\"DateOfBirthYear\"]")
    WebElement YearBirth ;

    @FindBy(id = "Email")
    WebElement EmailTxtBox ;

    @FindBy (id = "Password")
    WebElement PassTxtBox;

    @FindBy(id = "ConfirmPassword")
    WebElement ConfirmPassTxtBox;

    @FindBy (id = "register-button")
    WebElement RegisterBtn ;

    @FindBy(xpath = "//div[@class=\"result\"]")
    public WebElement SuccessMsg;

    @FindBy(css = "a[href=\"/logout\"]")

    public WebElement logoutLink;

    @FindBy(linkText = "My account")
    WebElement MyAccountLink ;

    //fill the form with registration and then register

    public void Registration(String Fname ,String Lname , String Email , String Password)
    {
        clickONButton(MaleRadioBtn);
        InsertDataTextBox(FirstNameTxtBox , Fname);
        InsertDataTextBox(LastNameTxtBox , Lname);
        InsertDataTextBox(EmailTxtBox ,Email);
        InsertDataTextBox(PassTxtBox,Password);
        InsertDataTextBox(ConfirmPassTxtBox,Password);
        clickONButton(RegisterBtn);

    }

    public void userLogout()
    {
        clickONButton(logoutLink);
    }

    public void OpenMyAccountPage()
    {
        clickONButton(MyAccountLink);
    }


}
