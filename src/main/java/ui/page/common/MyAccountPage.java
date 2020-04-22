package main.java.ui.page.common;

import main.java.ui.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Page {
    @FindBy(css = "a[title='Orders'] > .icon-list-ol")
    public WebElement btnOrders;

    @FindBy(css = "a[title='Log me out']")
    public WebElement btnLogout;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return btnOrders.isDisplayed();
    }

    public AuthenticationPage doLogout() {
        btnLogout.click();
        return new AuthenticationPage(driver);
    }
}
