package main.java.ui.page.common;

import main.java.ui.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AuthenticationPage extends Page {
    @FindBy(css = "button#SubmitCreate > span")
    public WebElement btnCreateAccount;

    @FindBy(css = "button#SubmitLogin > span")
    public WebElement btnLoginSubmit;

    @FindBy(css = "input#email_create")
    public WebElement textEmailId;

    @FindBy(css = "form#account-creation_form")
    public WebElement formAccountCreate;

    @FindBy(css = "div:nth-of-type(1) > .top > .radio  input[name='id_gender']")
    public WebElement btnMr;

    @FindBy(css = "div:nth-of-type(2) > .top > .radio  input[name='id_gender']")
    public WebElement btnMrs;

    @FindBy(css = "input#customer_firstname")
    public WebElement textFirstName;

    @FindBy(css = "input#customer_lastname")
    public WebElement textLastName;

    @FindBy(css = "input#email")
    public WebElement textEmail;

    @FindBy(css = "input#passwd")
    public WebElement textPassword;

    @FindBy(css = "select#days")
    public WebElement selectDays;

    @FindBy(css = "select#months")
    public WebElement selectMonths;

    @FindBy(css = "select#years")
    public WebElement selectYears;

    @FindBy(css = "input#newsletter")
    public WebElement checkboxNewsletter;

    @FindBy(css = "input#optin")
    public WebElement checkboxOptions;

    @FindBy(css = "input#company")
    public WebElement textCompany;

    @FindBy(css = "input[name='address1']")
    public WebElement textAddress1;

    @FindBy(css = "input[name='address2']")
    public WebElement textAddress2;

    @FindBy(css = "input#city")
    public WebElement textCity;

    @FindBy(css = "select#id_state")
    public WebElement textState;

    @FindBy(css = "input#postcode")
    public WebElement textZipcode;

    @FindBy(css = "select#id_country")
    public WebElement textCountry;

    @FindBy(css = "textarea#other")
    public WebElement textOther;

    @FindBy(css = "input#phone")
    public WebElement textPhone;

    @FindBy(css = "input#phone_mobile")
    public WebElement textMobile;

    @FindBy(css = "input#alias")
    public WebElement textAddressAlias;

    @FindBy(css = "button#submitAccount > span")
    public WebElement btnRegister;

    @FindBy(css = "input#email")
    public WebElement textLoginEmail;

    @FindBy(css = "input#passwd")
    public WebElement textLoginPassword;

    @FindBy(css = "button#SubmitLogin > span")
    public WebElement btnSignIn;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return btnCreateAccount.isDisplayed();
    }

    public MyAccountPage doRegister(String email, String password) {
        btnMr.click();
        textFirstName.sendKeys("test");
        textLastName.sendKeys("test");
        textEmail.clear();
        textEmail.sendKeys(email);
        textPassword.sendKeys(password);
        Select drpDays = new Select(selectDays);
        drpDays.selectByValue("2");
        Select drpMonth = new Select(selectMonths);
        drpMonth.selectByValue("10");
        Select drpYear = new Select(selectYears);
        drpYear.selectByValue("2012");
        checkboxNewsletter.click();
        checkboxOptions.click();
        textCompany.sendKeys("Google");
        textAddress1.sendKeys("address 1");
        textAddress2.sendKeys("address 2");
        textCity.sendKeys("NY");
        Select drpState = new Select(textState);
        drpState.selectByValue("5");
        textZipcode.sendKeys("40000");
        Select drpCountry = new Select(textCountry);
        drpCountry.selectByValue("21");
        textOther.sendKeys("additional optional");
        textPhone.sendKeys("9999999999");
        textMobile.sendKeys("9999999999");
        textAddressAlias.clear();
        textAddressAlias.sendKeys("MyAdd");
        btnRegister.click();
        return new MyAccountPage(driver);
    }
}
