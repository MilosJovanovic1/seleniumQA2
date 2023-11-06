package pages;

import org.example.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class InventoryPage {


    public ChromeDriver driver;

    public InventoryPage(ChromeDriver driver){
        this.driver = driver;

    }

    public void openPage(){
        driver.get(Url.urlLoginPage);
    }

    public String currentUrl(){

        return driver.getCurrentUrl();
    }

    public void removeItemFromCart(){

        driver.findElement(By.name("remove-sauce-labs-backpack")).click();
    }

    public void removeProductsFromCart (String productName){

        List<WebElement> inventoriItems = driver.findElements(By.xpath("//div[@class='cart_item']"));


        for (int i = 0; i < inventoriItems.size(); i++){
            WebElement item = inventoriItems.get(i);
            WebElement itemName = item.findElement(By.xpath(".//div[@class='inventory_item_name']"));


            if (itemName.getText().equals(productName)){
                WebElement button = item.findElement(By.xpath("//button[@class='btn btn_secondary btn_small cart_button']"));
                button.click();
                break;


            }

        }

    }

    public void clickOnContinueShoppingBtn(){

        driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_medium']")).click();

    }

    public void clickOnCheckoutBtn(){

        driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']")).click();

    }

    public void productInfo(String productName) {

        List<WebElement> inventoriItems = driver.findElements(By.xpath("//div[@class='cart_item']"));


        for (int i = 0; i < inventoriItems.size(); i++) {
            WebElement item = inventoriItems.get(i);
            WebElement itemName = item.findElement(By.xpath(".//div[@class='inventory_item_name']"));


            if (itemName.getText().equals(productName)) {
                WebElement button = item.findElement(By.xpath(".//div[@class='inventory_item_name']"));
                button.click();
                break;


            }
        }
    }

    public void closePage(){

        driver.quit();
    }


}
