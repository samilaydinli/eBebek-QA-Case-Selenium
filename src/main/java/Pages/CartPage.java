package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    By productNameLocator = By.className("cx-link");
    By completeShoppingLocator =By.id("btnGoToShippingAddress");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> getProducts(){
        waitForClickablility(productNameLocator,3);
        return findAll(productNameLocator);
    }

    public boolean checkIfProductAdded() {
        return getProducts().size() > 0;
    }

    public void finishShopping() {
        waitForClickablility(completeShoppingLocator,3);
        click(completeShoppingLocator);
    }
}
