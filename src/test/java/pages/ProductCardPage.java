package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCardPage extends BasePage {

    private final By PRODUCT_CARD_HEADER = By.cssSelector(".inventory_details_name");

    public ProductCardPage (WebDriver driver) {

        super(driver);
    }

    public String getTitle() {

        return driver.findElement(PRODUCT_CARD_HEADER).getText();
    }
}