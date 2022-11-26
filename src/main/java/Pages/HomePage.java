package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
    
    SearchBox searchBox;

    By showCart = By.id("btnShowCart");
    By closeCookiesLocator = new By.ByCssSelector(".cookies__wrapper-btn > div > i");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);  //searchBox set ettim.deger atamıs oldum artık null degil
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public void goToCart() {
        waitForClickablility(showCart,3);
        click(showCart);
    }

    public void acceptCookies(){
        if(isDisplayed(closeCookiesLocator)){
            click(closeCookiesLocator);
        }
    }
}
