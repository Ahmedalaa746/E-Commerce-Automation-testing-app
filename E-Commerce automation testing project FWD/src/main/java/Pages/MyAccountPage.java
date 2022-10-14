package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy (id = "OldPassword")
    WebElement OldPassTxt ;

    @FindBy (id = "NewPassword")
    WebElement NewPassTxt ;

    @FindBy (id = "ConfirmNewPassword")
    WebElement ConfirmPassTxt ;

    @FindBy (css = "button[class=\"button-1 change-password-button\"]")
    WebElement ChangePassBtn ;

    @FindBy (css = "p[class=\"content\"]")
    public WebElement SuccessMessage ;

    @FindBy (css = "a[href=\"/customer/changepassword\"]")
    WebElement ChangePasswordLink ;

    public  void  OpenChangePasswordForm()
    {
        clickONButton(ChangePasswordLink);
    }

    public void ChangePassword(String OldPass , String Newpass , String ConfirmPass)
    {
        InsertDataTextBox(OldPassTxt , OldPass);
        InsertDataTextBox(NewPassTxt , Newpass);
        InsertDataTextBox(ConfirmPassTxt , ConfirmPass);
        clickONButton(ChangePassBtn);
    }



}
