package test;

import org.testng.Assert;
import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.LoginPage;


public class LoginTests extends BaseTest {
	 Logger logger = LoggerUtil.getLogger(LoginTests.class);

    @Test
    public void loginWithValidCredentials() {
    	logger.info("Starting loginWithValidCredentials test");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "User is not on the products page.");
    }
    

    @Test
    public void loginWithInvalidCredentials() {
    	logger.info("Starting loginWithInValidCredentials test");
    	test.log(Status.INFO, "Logging into the app");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Sorry"), "Error message not displayed as expected.");
    }
    
}
