package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    By addToCartButtonLocator = By.id("addToCartBtn");
    By selectedProductNameLocator = By.xpath("//div[2]/h1/b");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
    }

    public String actualName (){
        waitForClickablility(selectedProductNameLocator,3);
        return find(selectedProductNameLocator).getText();
    }
}
