import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class LocatorTest extends BaseTest{

    @Test
    public void locatorTest() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button"));
        driver.findElement(By.name("login-button"));
        driver.findElement(By.cssSelector("submit.submit-button btn_action"));
        ////th[text()='Position Open']/ancestor::table[@class='report'](//tr)[2]/td/span
        // *[text()="Sauce Labs Fleece Jacket"/ancestor::*[contains(@class,'inventory_item)']]//button
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']" +
                "//ancestor::div[@class=inventory_item]"));
        driver.findElement(By.xpath("//id[starts-with(@id,'login')]"));
    }
}

