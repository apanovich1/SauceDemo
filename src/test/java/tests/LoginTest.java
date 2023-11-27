package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {

    @Test(description = "User should be logged in")
    public void loginHappyPath() {
        loginPage.open();
        loginPage.login("standard_user",
                "secret_sauce");
        Assert.assertEquals(productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page is opened");
    }
    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {"", "", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"standard_user1", "secret_sauce",
                        "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "loginData")
    public void negativeLogin(String user, String password, String expectedError) {
        loginPage.open();
        loginPage.login(user,password);
        Assert.assertEquals(loginPage.getError(),expectedError,"Incorrect error message");

    }

    @Test(description = "User should not be logged in")
    public void emptyEnter() {
        loginPage.open();
        loginPage.login(" "," ");
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and" +
                        " password do not match any user in this service",
                "A user is able to login with empty enters/incorrect text of error");

    }

    @Test(description = "User should not be logged in")
    public void emptyPassword() {
        loginPage.open();
        loginPage.login("standard_user","");
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Password is required",
                "A user is able to login with empty password/incorrect text of error");
    }


    @Test(description = "User should not be logged in")
    public void incorrectUsername() {
        loginPage.open();
        loginPage.login("standard_user1","secret_sauce");
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and password " +
                "do not match any user in this service",
                "User with incorrect username is able to login/incorrect text of error");
    }
}
