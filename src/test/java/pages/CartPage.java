package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final String REMOVE_FROM_CART = "//*[text()='%s']/ancestor::*[@class='cart_item_label']//button";

    private final By PRODUCT_CARD_LINK = By.cssSelector(".inventory_item_name");

    private final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");

    private final By PRICE = By.cssSelector(".inventory_item_price");

    private final By DESC = By.cssSelector(".inventory_item_desc");

    @Step("Open cart")
    public void openCart() {
        log.info("Opening cart");
        driver.get(BASE_URL + "cart.html");
    }

    @Step("Remove from cart")
    public void removeFromCart(String productName) {
        log.info("Removing '{}' cart", productName);
        By removeButton = By.xpath(String.format(REMOVE_FROM_CART, productName));
        driver.findElement(removeButton).click();;
    }

    @Step("Open product card")
    public void openProductCard() {
        log.info("Opening product card");
        driver.findElement(PRODUCT_CARD_LINK).click();
    }

    @Step("Continue shopping")
    public void continueShopping() {
        log.info("Continuing shopping");
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    @Step("Get price")
    public String getPrice() {
        log.info("Getting price");
        return driver.findElement(PRICE).getText();
    }

    @Step("Get product name")
    public String getProductName(){
        log.info("Getting product name");
        return driver.findElement(PRODUCT_CARD_LINK).getText();
    }
}