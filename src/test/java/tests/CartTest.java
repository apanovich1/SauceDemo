package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Product should be removed from cart")
    public void removeFromCart() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");

        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.removeFromCart("Sauce Labs Backpack"); //remove first product from cart list = backpack
        Assert.assertEquals(cartPage.getProductName(),"Sauce Labs Bike Light",
                "Backpack is still present in the cart after deletion");

    }
    @Test(description = "User should be redirected to Product Card")
    public void redirectToProductCard() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");

        productsPage.addToCart("Sauce Labs Backpack");

        cartPage.openCart();
        cartPage.openProductCard();
        Assert.assertEquals(productCardPage.getTitle(),
                "Sauce Labs Backpack",
                "Incorrect link to product card");

    }

    @Test(description = "User should be redirected to Products page")
    public void continueShopping() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");

        productsPage.addToCart("Sauce Labs Backpack");

        cartPage.openCart();
        cartPage.continueShopping();
        Assert.assertEquals(productsPage.getTitle(),
                "Products",
                "Incorrect link to Products page");
    }

    @Test(description = "Price of product should be correct")
    public void checkPrice() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.open();
        productsPage.addToCart("Sauce Labs Backpack");

        cartPage.openCart();
        Assert.assertEquals(cartPage.getPrice(),
                "$29.99",
                "Incorrect product price");
    }
}
