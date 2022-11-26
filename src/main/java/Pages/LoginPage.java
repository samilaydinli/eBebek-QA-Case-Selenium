package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By login = By.id("btnSubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnLoginPage() {
        waitForClickablility(login,3);
        return isDisplayed(login);
    }
}
