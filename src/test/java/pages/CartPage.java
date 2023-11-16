package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By REMOVE_FROM_CART_PATTERN = By.id("remove-sauce-labs-bike-light");

    private final By PRODUCT_CARD_LINK = By.cssSelector(".inventory_item_name");

    private final By CONTINUE_SHOPPING_BUTTON = By.id(".continue-shopping");

    private final By PRICE = By.id(".inventory_item_price");

    public void openCart() {

        driver.get(BASE_URL + "cart.html");
    }

    public void removeFromCart() {
        driver.findElement(REMOVE_FROM_CART_PATTERN).click();
    }

    public void openProductCard() {
        driver.findElement(PRODUCT_CARD_LINK).click();
    }

    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public String getPrice() {
        return driver.findElement(PRICE).getText();
    }
}