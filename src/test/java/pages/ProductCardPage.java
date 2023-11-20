package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public class ProductCardPage extends BasePage {
    public ProductCardPage (WebDriver driver) {

        super(driver);
    }

    private final By PRODUCT_CARD_HEADER = By.cssSelector("class=inventory_details_name");


    public String getTitle() {
        return driver.findElement(PRODUCT_CARD_HEADER).getText();
    }

}