package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector(".title");
    private final String ADD_TO_CART_PATTERN = "//*[text()='%s']/ancestor::*[@class='inventory_item']" +
            "//button";
    private final By CART_LINK = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("open inventory page")
    public void open() {
        log.info("opening inventory page");
        driver.get(BASE_URL + "inventory.html");
    }

    @Step("get title of page Products")
    public String getTitle() {
        log.info("getting Product title");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return driver.findElement(TITLE).getText();
    }

    @Step("add product to cart")
    public void addToCart(String product) {
        log.info("adding '{}' into cart", product);
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCartButton).click();
    }

    public void addToCart(int index) {
        log.info("adding '{}' into cart", index);
        driver.findElements(By.xpath("//*[@class='inventory_item']//button"))
                .get(index).click();
    }

    @Step("open cart")
    public void openCart() {
        log.info("opening cart page");
        driver.findElement(CART_LINK).click();
    }
}

    /*public void titleShouldBe(String expectedTitle){
        Assert.assertEquals(driver.findElement(TITLE),
                "Products",
                "User is not logged in or wrong page is opened");

       public void addToCart(int index) {
            driver.findElement(By.xpath(""//*[text()='%s']"
            + "/ancestor::*[@class='inventory_item']//button"").get(index).click();
       }
    }*/
