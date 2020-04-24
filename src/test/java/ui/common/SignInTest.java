package test.java.ui.common;

import main.java.CommonUtil;
import main.java.ui.page.common.AuthenticationPage;
import main.java.ui.page.common.HomePage;
import main.java.ui.page.common.MyAccountPage;
import main.java.ui.util.UiUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.java.BaseUiTest;

import java.io.IOException;

public class SignInTest extends BaseUiTest {
    @BeforeTest(description = "Load WebPage")
    public void preSignInTest() {
        driver.get(prop.getProperty("BASE_URL"));
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isInitialized(), "SignUp Page Not Loaded");
    }

    @Test(description = "SignUp", groups = {"public_ui.p1", "positive"})
    public void SignUpTest() throws IOException {
        HomePage homePage = new HomePage(driver);
        AuthenticationPage authenticationPage = homePage.clickSignInButton();
        authenticationPage.textEmailId.sendKeys(CommonUtil.generateRandomEmailId());
        authenticationPage.btnCreateAccount.click();
        UiUtil.waitTillElementVisible(driver, authenticationPage.formAccountCreate);
        MyAccountPage myAccountPage = authenticationPage.doRegister(CommonUtil.generateRandomEmailId(), prop.getProperty("PASSWORD"));
        Assert.assertTrue(myAccountPage.isInitialized(), "Register not successful");
        UiUtil.takeScreenshot(driver);
        myAccountPage.btnLogout.click();
    }

    @Test(description = "SignUp", groups = {"public_ui.p1", "positive"})
    public void LoginTest() throws IOException {
        HomePage homePage = new HomePage(driver);
        AuthenticationPage authenticationPage = homePage.clickSignInButton();
        String emailId = CommonUtil.generateRandomEmailId();
        authenticationPage.textEmailId.sendKeys(emailId);
        authenticationPage.btnCreateAccount.click();
        UiUtil.waitTillElementVisible(driver, authenticationPage.formAccountCreate);
        MyAccountPage myAccountPage = authenticationPage.doRegister(emailId, prop.getProperty("PASSWORD"));
        Assert.assertTrue(myAccountPage.isInitialized(), "Register not successful");
        AuthenticationPage authenticationPage1 = myAccountPage.doLogout();
        authenticationPage1.textLoginEmail.sendKeys(emailId);
        authenticationPage1.textLoginPassword.sendKeys(prop.getProperty("PASSWORD"));
        authenticationPage1.btnSignIn.click();
        myAccountPage.isInitialized();
        myAccountPage.btnLogout.click();
        UiUtil.takeScreenshot(driver);
    }
}
