package productTest;

import helper.ListManager;
import models.Product;
import models.User;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.ArrayList;
import java.util.List;

public class ProductTest {


    @DataProvider(name = "data-provider")
    public Object[][] dataProviderProductsName(){

        return new Object[][]{{"Sauce Labs Bike Light"}, {"Sauce Labs Fleece Jacket"}, {"Sauce Labs Onesie"}};
    }
@Test(dataProvider ="data-provider" )
    public void verifyAddItemToCart(String productName){
    ChromeDriver driver = new ChromeDriver();

    LoginPage loginPage = new LoginPage(driver);
    loginPage.openPage();
    User standardUser = new User("standard_user", "secret_sauce");
    loginPage.login(standardUser);


    ProductsPage productsPage = new ProductsPage(driver);

    String cartNumberBeforeAdd = productsPage.getCartNumberText();
    int cartNumberBeforeAddInt = Integer.parseInt(cartNumberBeforeAdd);

    productsPage.addProductTocart(productName);


    System.out.println(productsPage.getCartNumberText());
    String actualNumber = productsPage.getCartNumberText();

    Assert.assertEquals(Integer.parseInt(actualNumber), cartNumberBeforeAddInt + 1, "Cart number is not as expected");

    productsPage.closePage();

    }
@Test
    public void verifyAddItemToCartFor(){
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        User standardUser = new User("standard_user", "secret_sauce");
        loginPage.login(standardUser);

        List<String> productName = new ArrayList<>();
        productName.add("Sauce Labs Bike Light");
        productName.add("Sauce Labs Fleece Jacket");
        productName.add("Sauce Labs Onesie");


        ProductsPage productsPage = new ProductsPage(driver);

        for (int i = 0; i < productName.size(); i++){
            String cartNumberBeforeAdd = productsPage.getCartNumberText();
            int cartNumberBeforeAddInt = Integer.parseInt(cartNumberBeforeAdd);

            productsPage.addProductTocart(productName.get(i));

            System.out.println(productsPage.getCartNumberText());
            String actualNumber = productsPage.getCartNumberText();

            Assert.assertEquals(Integer.parseInt(actualNumber), cartNumberBeforeAddInt + 1, "Cart number is not as expected");


        }



        productsPage.closePage();

    }
    @Test
    public void verifyAddItemSauceLabsBoltTShirtToCart(){
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\jovan\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();


        ProductsPage productsPage = new ProductsPage(driver);

        String cartNumberBeforeAdd = productsPage.getCartNumberText();
        int cartNumberBeforeAddInt = Integer.parseInt(cartNumberBeforeAdd);

        productsPage.addProductTocart("Sauce Labs Bolt T-Shirt");
        productsPage.addProductTocart("Sauce Labs Onesie");


        //TODO assertions

        System.out.println(productsPage.getCartNumberText());
        String actualNumber = productsPage.getCartNumberText();


        Assert.assertEquals(Integer.parseInt(actualNumber), cartNumberBeforeAddInt + 2, "Cart number is not as expected");



        //Assert.assertEquals(actualNumber, "2", "Cart number is not as expected");
        productsPage.closePage();


    }
    @Test
    public void verifySortByPrice(){

        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        User standardUser = new User("standard_user", "secret_sauce");
       loginPage.login(standardUser);



        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectSortBy("Price (low to high)");
        //Assertation
        //List<Double> prices = productsPage.returnPrice();
        List<Product> products = productsPage.returnProducts();
        List<Double> prices = productsPage.getPrices(products);




        //TODO assertation

        Assert.assertTrue(ListManager.isListSortedAsc(prices), "Prices are not sort as expected"); ListManager.isListSortedAsc(prices);




        //Assert.assertEquals();


        productsPage.closePage();

    }




}
