package loginTest;

import junit.framework.Assert;
import org.example.Message;
import org.example.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyErrorMessageOnLoginWithoutCredentials {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jovan\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(Url.urlLoginPage);


       // WebElement buttonLogIn = driver.findElement(By.id("login-button"));
        WebElement buttonLogIn = driver.findElement(By.xpath("//input[@data-test='login-button']"));

        buttonLogIn.click();

        //lociranje web elementa preko xpath-a

        String errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();

       // Assert.assertEquals("Message is not as expected", "Epic sadface: Username is required", errorMessage);

        WebElement closeMessage = driver.findElement(By.xpath("//button[@class='error-button']"));

        //if (errorMessage.equals("Epic sadface: Username is required")){
        //    System.out.println("PASSED");

       // }

        if (errorMessage.equals(Message.errorWithoutCredentials)){
            System.out.println("PASSED");
        }
        else {
            System.out.println("FAILED");
        }

        driver.quit();



    }
}
