package loginTest;

import org.example.Message;
import org.example.Url;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.List;

public class LoginTest {
    @Test

    public void verifyLoginWithValidCredentials() {
        ChromeDriver driver = new ChromeDriver();




        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();


        //TODO assertion

        Assert.assertEquals(loginPage.getCurrentURL(), Url.urlInventoryPage);


        loginPage.closePage();



    }

    @Test

    public void verifyLoginWithoutUsername() {
        ChromeDriver driver = new ChromeDriver();


        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();

        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();


        //TODO assertion

        Assert.assertEquals(loginPage.getCurrentURL(), Url.urlLoginPage);
        Assert.assertEquals(loginPage.getErrorMessage(), Message.errorWithoutUsername);




        loginPage.closePage();



    }



}