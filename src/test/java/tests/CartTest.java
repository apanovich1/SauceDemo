package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void removeFromCart() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");

        productsPage.addToCart("Sauce Labs Bike Light");

        cartPage.openCart();
        cartPage.removeFromCart();

    }
    @Test
    public void redirectToProductCard() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");

        productsPage.addToCart("Sauce Labs Backpack");

        cartPage.openCart();
        cartPage.openProductCard();
        Assert.assertEquals(productCard.getTitle(),
                "Sauce Labs Backpack",
                "Incorrect link to product card");

    }

    @Test
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

    @Test
    public void checkPrice() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");

        productsPage.addToCart("Sauce Labs Backpack");

        cartPage.openCart();
        Assert.assertEquals(cartPage.getPrice(),
                "$29.99",
                "Incorrect product price");
    }
}
