package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogIn {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jovan\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        try {
            Thread.sleep(1500);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        try {
            Thread.sleep(1500);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
        driver.findElement(By.name("login-button")).click();

        try {
            Thread.sleep(1500);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

        try {
            Thread.sleep(1500);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

        driver.findElement(By.className("shopping_cart_link")).click();

        try {
            Thread.sleep(1500);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

        driver.findElement(By.name("continue-shopping")).click();

        try {
            Thread.sleep(1500);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

        driver.findElement(By.name("remove-sauce-labs-backpack")).click();

        try {
            Thread.sleep(1500);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

        driver.quit();



    }
}
