package pages;

import models.Product;
import org.example.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.ProductPagePath;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage {

    public ChromeDriver driver;


    public ProductsPage(ChromeDriver driver) {
        this.driver = driver;

    }

    public void openPage() {

        driver.get(Url.urlLoginPage);
    }

    public void addProductTocart(String productName) {
        WebElement inventoryList = driver.findElement(By.xpath("//div[@class='inventory_list']"));

        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath("//div[@class='inventory_item']"));

        for (int i = 0; i < inventoryItems.size(); i++) {
            WebElement item = inventoryItems.get(i);
            WebElement itemName = item.findElement(By.xpath(".//div[@class='inventory_item_name ']"));
            //WebElement itemName = item.getAttribute("innerHTML");
            if (itemName.getText().equals(productName)) {
                WebElement button = item.findElement(By.xpath(".//button"));
                button.click();
                System.out.println("Item added");
                break;
                //kod relativne pretrage ".//"


            }
        }
    }



    public void clickOnCartIcon(){

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

    }

    public List<WebElement> getCartNumber(){
        return driver.findElements(By.xpath("//span[@class='shopping_cart_badge']"));
    }

    public String getCartNumberText(){

        List<WebElement> spanList = getCartNumber();
        if (spanList.size() == 0){
            return "0";
        }
        else {
            return spanList.get(0).getText();
        }

        //return getCartNumber().getText();
        //return "";
    }

    public void selectSortBy(String sortValue){
        WebElement select = driver.findElement(By.xpath("//select[@data-test='product_sort_container']"));
        select.click();

        List<WebElement> options = select.findElements(By.xpath(".//option"));

        for (int i = 0; i < options.size(); i++){
            if (options.get(i).getText().equals(sortValue)){
                options.get(i).click();
                break;


            }

        }

    }

    public List<Double> returnPrice(){
        List<Double> returnPriceItems = new ArrayList<>();
        WebElement inventoryList = driver.findElement(By.xpath(ProductPagePath.inventoryList));

        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath("//div[@class='inventory_item']"));
        for (int i = 0; i < inventoryItems.size(); i++){
            WebElement price = inventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_price']"));
            String priceValue = price.getText();
            Double priceValueDouble = Double.parseDouble(priceValue.substring(1));
            returnPriceItems.add(priceValueDouble);

        }
        return returnPriceItems;

    }

    public List<String> returnNames(){
        List<String> returnPriceItems = new ArrayList<>();
        WebElement inventoryList = driver.findElement(By.xpath("//div[@class='inventory_list']"));

        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath("//div[@class='inventory_item']"));
        for (int i = 0; i < inventoryItems.size(); i++){
            WebElement name = inventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name ']"));
            String nameValue = name.getText();
            returnPriceItems.add(nameValue);

        }
        return returnPriceItems;

    }

    public List<Product> returnProducts(){

        List<Product> returnProducts = new ArrayList<>();

        WebElement inventoryList = driver.findElement(By.xpath(ProductPagePath.inventoryList));

        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath(ProductPagePath.inventoryItem));
        for (int i = 0; i < inventoryItems.size(); i++){


            WebElement name = inventoryItems.get(i).findElement(By.xpath(ProductPagePath.inventoryItemName));
            String nameValue = name.getText();

            WebElement price = inventoryItems.get(i).findElement(By.xpath(ProductPagePath.inventoryItemPrice));
        String priceValue = price.getText();
        Double priceValueDouble = Double.parseDouble(priceValue.substring(1));

        WebElement desc = inventoryItems.get(i).findElement(By.xpath(ProductPagePath.inventoryItemDesc));
        String descValue = desc.getText();

        Product product = new Product(nameValue, descValue, priceValueDouble);
        returnProducts.add(product);



        }


        return returnProducts;
    }

    public List<Double> getPrices(List<Product> products) {
        List<Double> prices = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            prices.add(products.get(i).getPrice());

        }
        return prices;


    }


    public void closePage(){
        driver.quit();
    }

}
