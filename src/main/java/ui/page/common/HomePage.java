package main.java.ui.page.common;

import main.java.ui.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {
    @FindBy(css = ".header_user_info [rel]")
    public WebElement btnLogin;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public AuthenticationPage clickSignInButton() {
        btnLogin.click();
        return new AuthenticationPage(driver);
    }

    public boolean isInitialized() {
        return btnLogin.isDisplayed();
    }
}
