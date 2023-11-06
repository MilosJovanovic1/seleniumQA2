package pages;

import models.User;
import org.example.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPage {



    //metode za lociranje web elemenata

    public ChromeDriver driver;

    public LoginPage(ChromeDriver driver){
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://www.saucedemo.com/");

    }


    public WebElement returnUsername(){
        return driver.findElement(By.id("user-name"));
    }
    public WebElement returnPassword(){
        return driver.findElement(By.id("password"));

    }

    public WebElement returnLoginBtn(){
        return driver.findElement(By.id("login-button"));
    }

    public WebElement returnErrorMessage(){

        return driver.findElement(By.xpath("//h3[@data-test='error']"));

    }

    //metode za akcije nad web elementima

    public void setUserName(String username){
        //returnUsername().clear();

        returnUsername().sendKeys(username);
    }

    public void setPassword(String password){

        returnPassword().sendKeys(password);
    }

    public void clickOnLogin(){

        returnLoginBtn().click();
    }
    public void login(User user){
        setUserName(user.getUsername());
        setPassword(user.getPassword());
        clickOnLogin();


    }

    public String getCurrentURL(){
        return  driver.getCurrentUrl();
    }

    public String getErrorMessage(){
       return returnErrorMessage().getText();


    }



    public void closePage(){
        driver.quit();
    }






}
