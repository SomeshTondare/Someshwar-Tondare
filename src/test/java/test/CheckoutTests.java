package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CheckoutPage;

public class CheckoutTests extends BaseTest {

    @Test
    public void completeCheckoutFlow() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.openCart();
        checkoutPage.clickCheckout();
        checkoutPage.fillCustomerInfo("John", "Doe", "12345");
        checkoutPage.completeCheckout();

        String message = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(message, "Thank you for your order!", "Confirmation message mismatch.");
    }
}
