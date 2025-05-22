package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;
    private By firstAddToCartButton = By.cssSelector(".inventory_item button");
    private By cartIcon = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addFirstProductToCart() {
        driver.findElement(firstAddToCartButton).click();
    }

    public String getCartItemCount() {
        return driver.findElement(cartIcon).getText();
    }
}
