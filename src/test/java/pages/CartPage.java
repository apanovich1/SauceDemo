package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final String REMOVE_FROM_CART = "//*[text()='%s']/ancestor::*[@class='cart_item_label']//button";

    private final By PRODUCT_CARD_LINK = By.cssSelector(".inventory_item_name");

    private final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");

    private final By PRICE = By.cssSelector(".inventory_item_price");

    private final By DESC = By.cssSelector(".inventory_item_desc");

    public void openCart() {

        driver.get(BASE_URL + "cart.html");
    }

    public void removeFromCart(String productName) {
        By removeButton = By.xpath(String.format(REMOVE_FROM_CART, productName));
        driver.findElement(removeButton).click();;
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

    public String getProductName(){
        return driver.findElement(PRODUCT_CARD_LINK).getText();
    }
}