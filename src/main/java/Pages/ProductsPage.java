package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductsPage extends BasePage {

    By categoryFilterLocator = By.id("txtCategoryFilter");
    By productNameLocator = new By.ByCssSelector("span.description");
    By stockProductLocator = By.id("addToCartBtn");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductsPage() {
        waitForClickablility(categoryFilterLocator,5);
        return isDisplayed(categoryFilterLocator);
    }

    public void pageScrolldown() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(1000);
    }


    private List<WebElement> getAvailableProducts(){
        return findAll(stockProductLocator);
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }

    public String expectedName(){
        int lastElementIndex = getAvailableProducts().size() - 1;
        return getAllProducts().get(lastElementIndex).getText();
    }

    public void selectProduct() {
        int lastElementIndex = getAvailableProducts().size() - 1;
        getAllProducts().get(lastElementIndex).click();
    }


}
