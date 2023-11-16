package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.lang.String;

public class LoginTest extends BaseTest {

    @Test
    public void loginHappyPath() {
        loginPage.open();
        loginPage.login("standard_user",
                "secret_sauce");
        Assert.assertEquals(productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page is opened");
    }

    @Test
    public void emptyEnter() {
        loginPage.open();
        loginPage.login(" "," ");
        Assert.assertTrue(loginPage.getError().contains("Epic sadface: " +
                "Username is required"));
    }

    @Test
    public void emptyPassword() {
        loginPage.open();
        loginPage.login("standard_user"," ");
        Assert.assertTrue(loginPage.getError().contains("Epic sadface: " +
                "Password is required"));
    }


    @Test
    public void incorrectUsername() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username" +
                " and password do not match any user in this service");
    }
}
