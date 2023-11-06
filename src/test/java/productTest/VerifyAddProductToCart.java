package productTest;

import junit.framework.Assert;
import org.example.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyAddProductToCart {
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

        // NALAZIMO INVENTORY LIST_LIST

        WebElement inventoryList = driver.findElement(By.xpath("//div[@class='inventory_list']"));

        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath("//div[@class='inventory_item']"));

        for (int i = 0; i < inventoryItems.size(); i++) {
            WebElement item = inventoryItems.get(i);
            WebElement itemName = item.findElement(By.xpath(".//div[@class='inventory_item_name ']"));
            //WebElement itemName = item.getAttribute("innerHTML");
            if (itemName.getText().equals("Test.allTheThings() T-Shirt (Red)")){
                WebElement button = item.findElement(By.xpath(".//button"));
                button.click();
                System.out.println("Item added");
                break;
              //kod relativne pretrage ".//"
            }


        }
        System.out.println("");

        //lociramo korpu

        //WebElement shopingCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));

        //WebElement cartSpan = shopingCart.findElement(By.xpath(".//span"));
        //System.out.println(cartSpan.getText());

        WebElement cartSpan = driver.findElement(By.xpath(".//span"));

        System.out.println(cartSpan.getText());

        Assert.assertEquals("cart number is not as expected,", "1", cartSpan.getText());








        driver.quit();

    }
}
