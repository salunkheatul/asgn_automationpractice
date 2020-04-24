package test.java.ui.common;

import main.java.ui.page.common.AuthenticationPage;
import main.java.ui.page.common.HomePage;
import main.java.ui.page.common.MyAccountPage;
import main.java.ui.util.UiUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.java.BaseUiTest;

public class CartTest extends BaseUiTest {
    @BeforeTest(description = "Load WebPage")
    public void preSignInTest() {
        driver.get(prop.getProperty("BASE_URL"));
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isInitialized(), "SignUp Page Not Loaded");
        AuthenticationPage authenticationPage = homePage.clickSignInButton();
        authenticationPage.textLoginEmail.sendKeys("epictestbuster@gmail.com");
        authenticationPage.textLoginPassword.sendKeys(prop.getProperty("PASSWORD"));
        authenticationPage.btnSignIn.click();
    }

    @Test(description = "SignUp", groups = {"public_ui.p1", "positive"})
    public void cartTest() throws InterruptedException {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.btnWomen.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccountPage.productElement);
        actions.build().perform();
        myAccountPage.productQuickView.click();
        Thread.sleep(2000);
        driver.switchTo().frame(myAccountPage.fancyBoxIFrame);
        myAccountPage.btnAddQuantity.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", myAccountPage.btnAddToCart);
        UiUtil.waitTillElementVisible(driver, myAccountPage.btnProceedToCheckout);
        UiUtil.waitTillElementVisible(driver, myAccountPage.layerCartElement);
        myAccountPage.layerCartProceed.click();
        UiUtil.waitTillElementVisible(driver, myAccountPage.cartTitle);
        Assert.assertTrue(myAccountPage.textTotalPrice.getText().equalsIgnoreCase("$35.02"));
        myAccountPage.cartPageProceed.click();
        UiUtil.waitTillElementVisible(driver, myAccountPage.addressElement);
        myAccountPage.addressPageProceed.click();
        UiUtil.waitTillElementVisible(driver, myAccountPage.carrierChargesElement);
        myAccountPage.chargesCheckbox.click();
        myAccountPage.ccProceed.click();
        UiUtil.waitTillElementVisible(driver, myAccountPage.payByWireOption);
        myAccountPage.payByWireOption.click();
        myAccountPage.orderConfirmation.click();
        myAccountPage.btnbacktoOrder.click();
        UiUtil.waitTillElementVisible(driver, myAccountPage.textOrderPrice);
        System.out.println(myAccountPage.textOrderPrice.getText());
        Assert.assertTrue(myAccountPage.textOrderPrice.getText().equalsIgnoreCase("$35.02"));
    }
}
