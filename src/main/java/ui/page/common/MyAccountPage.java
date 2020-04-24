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

    @FindBy(css = "a[title='Women']")
    public WebElement btnWomen;

    @FindBy(css = "[alt='Faded Short Sleeve T-shirts']")
    public WebElement productElement;

    @FindBy(css = "[class] .product-image-container [rel='http\\:\\/\\/automationpractice\\.com\\/index\\.php\\?id_product\\=1\\&controller\\=product']:nth-child(3)")
    public WebElement productQuickView;

    @FindBy(className = "fancybox-iframe")
    public WebElement fancyBoxIFrame;

    @FindBy(css = "#add_to_cart > button")
    public WebElement btnAddToCart;

    @FindBy(css="a[title='Proceed to checkout'] > span")
    public WebElement btnProceedToCheckout;

    @FindBy(css = ".btn.btn-default.button-plus.product_quantity_up")
    public WebElement btnAddQuantity;

    @FindBy(css = "#total_price")
    public WebElement textTotalPrice;

    @FindBy(css = "div#layer_cart")
    public WebElement layerCartElement;

    @FindBy(css = "[title='Proceed to checkout'] span")
    public WebElement layerCartProceed;

    @FindBy(css = "h1#cart_title")
    public WebElement cartTitle;

    @FindBy(css = "div#center_column  a[title='Proceed to checkout'] > span")
    public WebElement cartPageProceed;

    @FindBy(css = "ul#address_delivery")
    public WebElement addressElement;

    @FindBy(css = "div#center_column > form[method='post']  button > span")
    public WebElement addressPageProceed;

    @FindBy(css = ".order_carrier_content")
    public WebElement carrierChargesElement;

    @FindBy(css = "input#cgv")
    public WebElement chargesCheckbox;

    @FindBy(css = ".standard-checkout span")
    public WebElement ccProceed;

    @FindBy(css = "a[title='Pay by bank wire']")
    public WebElement payByWireOption;

    @FindBy(css = "#cart_navigation span")
    public WebElement orderConfirmation;

    @FindBy(css = "[title='Back to orders']")
    public WebElement btnbacktoOrder;

    @FindBy(css = ".history_price > .price")
    public WebElement textOrderPrice;

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
