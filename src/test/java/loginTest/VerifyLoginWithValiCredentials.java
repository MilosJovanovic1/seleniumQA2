package loginTest;

import junit.framework.Assert;
import org.example.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class VerifyLoginWithValiCredentials {

    //pozitivan test


    public static void main(String[] args) {
        final String urlProductsPage = "https://www.saucedemo.com/inventory.html";
        //final String urlLoginPage = "https://www.saucedemo.com/";

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jovan\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        //driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.get(Url.urlLoginPage);

        //set username

        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.clear();
        inputUserName.sendKeys("standard_user");
        System.out.println(inputUserName.getAttribute("value"));

       // driver.findElement(By.id("user-name")).sendKeys("standard_user");


        //set password

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.clear();
        inputPassword.sendKeys("secret_sauce");

        //click on login

        WebElement buttonLogIn = driver.findElement(By.id("login-button"));
        buttonLogIn.click();

        //validacija potvrda da je test prosao ili pao

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        Assert.assertEquals(currentUrl, urlProductsPage);

        //junit

        Assert.assertEquals("Current url is not as expected", urlProductsPage, currentUrl);



        driver.quit();



    }
}
