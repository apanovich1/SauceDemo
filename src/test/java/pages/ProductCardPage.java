package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductCardPage extends BasePage {

    private final By PRODUCT_CARD_HEADER = By.cssSelector(".inventory_details_name");

    public ProductCardPage (WebDriver driver) {

        super(driver);
    }

    @Step("get title of product card page")
    public String getTitle() {
        log.info("getting title of product");
        return driver.findElement(PRODUCT_CARD_HEADER).getText();
    }
}