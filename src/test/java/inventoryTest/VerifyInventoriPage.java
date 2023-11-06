package inventoryTest;

import models.User;
import org.example.Url;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import pages.ProductsPage;

public class VerifyInventoriPage {


@Test
    public void verifyRemoveProductFromCart(){

        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = new InventoryPage(driver);

        ProductsPage productsPage = new ProductsPage(driver);

        inventoryPage.openPage();

        User standardUser = new User("standard_user", "secret_sauce");
        loginPage.login(standardUser);


        productsPage.addProductTocart("Sauce Labs Backpack");

        productsPage.addProductTocart("Sauce Labs Bike Light");

        productsPage.clickOnCartIcon();

        inventoryPage.removeProductsFromCart("Sauce Labs Backpack");


        String actualNumber = productsPage.getCartNumberText();

        Assert.assertEquals(Integer.parseInt(actualNumber),  1, "Cart number is not as expected");

        inventoryPage.closePage();

    }
@Test
    public void verifyContinueShoppping(){

        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = new InventoryPage(driver);

        ProductsPage productsPage = new ProductsPage(driver);


        inventoryPage.openPage();

        User standardUser = new User("standard_user", "secret_sauce");
        loginPage.login(standardUser);

        productsPage.clickOnCartIcon();

        inventoryPage.clickOnContinueShoppingBtn();

        Assert.assertEquals( inventoryPage.currentUrl() ,Url.urlInventoryPage, "url is not as expected ");

        inventoryPage.closePage();


    }

@Test
    public void verifyCheckout() {

        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = new InventoryPage(driver);

        ProductsPage productsPage = new ProductsPage(driver);


        inventoryPage.openPage();

        User standardUser = new User("standard_user", "secret_sauce");
        loginPage.login(standardUser);

        productsPage.clickOnCartIcon();

        inventoryPage.clickOnCheckoutBtn();

        Assert.assertEquals(inventoryPage.currentUrl(), Url.urlCheckoutPage, "url is not as expected");

        inventoryPage.closePage();

    }
    @Test
    public void verifyProductInfo() throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = new InventoryPage(driver);

        ProductsPage productsPage = new ProductsPage(driver);

        inventoryPage.openPage();

        User standardUser = new User("standard_user", "secret_sauce");
        loginPage.login(standardUser);


        productsPage.addProductTocart("Sauce Labs Backpack");

        productsPage.addProductTocart("Sauce Labs Bike Light");

        productsPage.clickOnCartIcon();



        inventoryPage.productInfo("Sauce Labs Backpack");

        Assert.assertEquals(inventoryPage.currentUrl(), "https://www.saucedemo.com/inventory-item.html?id=4", "url is not as expected");

        inventoryPage.closePage();

    }

}
