package Tests;

import Pages.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Add_Product_To_Cart extends BaseTest{

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    LoginPage loginPage;


    @Test
    @Order(1)
    public void search_a_product(){
        homePage = new HomePage(driver);  //olusturdugu page leri initialize ediyorum.yoksa calısmaz
        productsPage = new ProductsPage(driver);
        homePage.acceptCookies();
        homePage.searchBox().search("kaşık maması");
        Assertions.assertTrue(productsPage.isOnProductsPage() , "We are not on products page ! ");
    }

    @Test
    @Order(2)
    public void select_a_product() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        Thread.sleep(2000);
        productsPage.pageScrolldown();
        productsPage.selectProduct();
        Assert.assertEquals(productsPage.expectedName(),productDetailPage.actualName());
    }

    @Test
    @Order(3)
    public void add_product_to_cart() throws InterruptedException {
        Thread.sleep(2000);
        productDetailPage.addToCart();
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage() , "We are not on product detail page ! ");
    }

    @Test
    @Order(4)
    public void go_to_cart() {
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded() , "Product was not added to the cart ! ");
    }

    @Test
    @Order(5)
    public void complete_shopping() {
        loginPage = new LoginPage(driver);
        cartPage.finishShopping();
        Assertions.assertTrue(loginPage.isOnLoginPage() , "We are not on Login Page ! ");
    }
}
