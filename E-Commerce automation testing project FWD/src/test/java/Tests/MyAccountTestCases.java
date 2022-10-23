package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTestCases extends TestBase{
    MyAccountPage myAccountObj ;
    HomePage homeObj ;
    RegistrationPage registerObj ;
    LoginPage loginObj;
    String oldPassword = "aa@12345";
    String newPassword = "12345678";
    String confirmPassword ="12345678";
    String email = "Test@aa.com";

    @Test (priority = 1)
    public void UserCanRegisterSuccussfully()
    {
        homeObj =new HomePage(driver);
        registerObj =new RegistrationPage(driver);
        homeObj.OpenRegisterationForm();
        registerObj.Registration("Ghada","Ahmed",email ,oldPassword);

        // verify the success message appears
        Assert.assertTrue(registerObj.SuccessMsg.getText().contains("your registration completed"));

    }

    @Test (priority = 2)
    public void LoggedUserChangePasswordSuccessfully()throws InterruptedException{

        Thread.sleep(2000);
        myAccountObj=new MyAccountPage(driver);
        registerObj.OpenMyAccountPage();
        myAccountObj.OpenChangePasswordForm();
        myAccountObj.ChangePassword(oldPassword,newPassword ,confirmPassword);
        Thread.sleep(2000);
        Assert.assertTrue(myAccountObj.SuccessMessage.getText().contains("password was changed"));

    }
    @Test(priority = 2)

    public void UserCanLoginSuccessfully()throws InterruptedException{
        homeObj.OpenLoginPage();
        Thread.sleep(2000);
        registerObj.userLogout();
        Assert.assertTrue(homeObj.LoginLink.isDisplayed());

    }

    @Test(priority = 3)
    public void UserCanLogoutSuccessfully()throws InterruptedException{

        Thread.sleep(2000);
        homeObj.OpenLoginPage();
        loginObj.userLogin(email,newPassword);
        Assert.assertTrue(registerObj.logoutLink.isDisplayed());

    }
}
