package Tests;

import TestResultLogger.TestResultLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // normalde Junit testleri rasgele run eder bu yüzden order kullanıyorum ki sırasıyla calıssın.
@ExtendWith(TestResultLogger.class)
public class BaseTest {

    WebDriver driver;

    @BeforeAll
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.e-bebek.com/");
        driver.manage().window().maximize();
    }

    @AfterAll
    public void tearDown(){
        driver.quit();
    }
}
