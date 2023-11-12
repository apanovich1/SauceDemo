import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class LocatorTest extends BaseTest{

    @Test
    public void locatorTest() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button"));
        driver.findElement(By.name("login-button"));
        driver.findElement(By.cssSelector("submit.submit-button.btn_action"));
        ////th[text()='Position Open']/ancestor::table[@class='report'](//tr)[2]/td/span
        // *[text()="Sauce Labs Fleece Jacket"/ancestor::*[contains(@class,'inventory_item)']]//button

        //xpathes
        //login page
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']" +
                "//ancestor::div[@class=inventory_item]")); //ancestor
        driver.findElement(By.xpath("//id[starts-with(@id,'login')]"));////Поиск по частичному совпадению атрибута, например By.xpath("//tag[contains(@attribute,'text')]");
        driver.findElement(By.xpath("//div[3]/div[2]/div[2]/button"));//Поиск по тексту, например By.xpath("//tag[text()='text']");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]"));//Поиск по атрибуту, например By.xpath("//tag[@attribute='value']");
        //inventory page
        driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));//Поиск по частичному совпадению текста, например By.xpath("//tag[contains(text(),'text')]");
        driver.findElement(By.xpath("//div[@class='inventory_item']" +
                "/descendant::button[@name='add-to-cart-sauce-labs-backpack']"));//descendant
        driver.findElement(By.xpath("//div[@class='inventory_item']" +
                "//following::button[@name='add-to-cart-sauce-labs-backpack']"));// following
        driver.findElement(By.xpath("//div[@class='inventory_item_name ']/parent::*"));//parent
        driver.findElement(By.xpath("//div[@class='inventory_item']" +
                "/preceding::button[@name='add-to-cart-sauce-labs-backpack']"));//preceding
        /// checkout page
        driver.findElement(By.xpath("//button[@name='checkout' and @id='checkout']")); // and

        //cssSelectors
        driver.findElement(By.cssSelector(".inventory_item_name"));// .class
        driver.findElement(By.cssSelector(".btn.btn_primary.btn_small"));// .class1.class2
        driver.findElement(By.tagName("button[id = 'add-to-cart-sauce-labs-backpack']"));// tagname
        driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-bike-light")); //#id
        driver.findElement(By.cssSelector("btn_inventory"));
        driver.findElement(By.cssSelector("button.btn_inventory"));//tagname.class
        driver.findElement(By.cssSelector("button[name='add-to-cart-sauce-labs-backpack']"));//[attribute=value]
        driver.findElement(By.cssSelector("button[name~='inventory_item']"));//[attribute~=value]
        driver.findElement(By.cssSelector("button[name|='inventory_item']"));//[attribute|=value]
        driver.findElement(By.cssSelector("input[name^='inventory_item']"));//[attribute^=value]
        //login page
        driver.findElement(By.cssSelector(".login-box.submit-button"));// .class1.class2
        driver.findElement(By.cssSelector("input[id$='button']"));//[attribute$=value]
        driver.findElement(By.cssSelector("input[name*='user']"));//[attribute*=value]
    }
}

