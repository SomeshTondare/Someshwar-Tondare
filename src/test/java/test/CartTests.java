package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTests extends BaseTest {

    @Test
    public void addItemToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();

        String count = productsPage.getCartItemCount();
        Assert.assertEquals(count, "1", "Cart item count should be 1.");
    }
}
