package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import io.cucumber.java.lv.Tad;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTestCases extends TestBase{
    HomePage homeObj;
    RegistrationPage registerObj;
    LoginPage loginObj;
    String email ="test74@auto.com";

    //register with valid email
    @Test(priority = 1)
    public void UserCanRegisterSuccessfully(){

        homeObj=new HomePage(driver);
        registerObj=new RegistrationPage(driver);
        homeObj.OpenRegisterationForm();
        registerObj.Registration("ghada","ahmed",email,"1234567");

        //verify the success message appears
        Assert.assertTrue(registerObj.SuccessMsg.getText().contains("your registration completed"));

    }

    @Test(priority = 2,dependsOnMethods = {"usercanregiterSuccessfully"})

    public void UserCanLogoutSuccessfully(){

        registerObj.userLogout();
        Assert.assertTrue(homeObj.LoginLink.isDisplayed());

    }
    @Test(priority = 4,dependsOnMethods = {"usercanlogoutsuccessfully"})
    public void UserCanLoginSuccessfully()throws InterruptedException{
        Thread.sleep(2000);
        homeObj.OpenLoginPage();
        loginObj=new LoginPage(driver);
        loginObj.userLogin(email,"1234567");
        Thread.sleep(2000);
        Assert.assertTrue(registerObj.logoutLink.isDisplayed());



    }

}
