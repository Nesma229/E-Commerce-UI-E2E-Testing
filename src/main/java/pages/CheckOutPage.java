package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


import static utils.CustomMethods.*;

public class CheckOutPage {

   private WebDriver driver;

    public CheckOutPage(WebDriver driver) {

        this.driver = driver;
    }

    private final By countryField = By.xpath("//select[@data-trigger=\"country-select\"]");
    private final By cityField = By.xpath("//input[@id=\"BillingNewAddress_City\"]");
    private final  By addressField = By.xpath("//input[@id=\"BillingNewAddress_Address1\"]");

    private final By postalCodeField = By.xpath("//input[@id=\"BillingNewAddress_ZipPostalCode\"]");
    private final By phoneNumberField = By.xpath("//input[@id=\"BillingNewAddress_PhoneNumber\"]");

    private final By saveBuildingAddressBtn = By.xpath("//button[@onclick=\"Billing.save()\"]");
    private final By saveShippingBtn = By.xpath("//button[@onclick='ShippingMethod.save()']");

    private final By savePaymentBtn = By.xpath("//button[@onclick='PaymentMethod.save()']");
    private final By savePaymentInfoBtn = By.xpath("//button[@onclick='PaymentInfo.save()']");
    private final By confirmOrderBtn = By.xpath("//button[@onclick='ConfirmOrder.save()']");
    private  final By successOrderMsg = By.xpath("//div[@class='section order-completed']//div[@class='title']");


    @Step
    public CheckOutPage buildingAddress(String country, String city, String address, String postalCode, String phoneNumber){

        Select selectCountry = new Select(findElementPresence(driver,countryField));
        selectCountry.selectByValue(country);

        findElementPresence(driver,cityField).sendKeys(city);

        findElementPresence(driver,addressField).sendKeys(address);

        findElementPresence(driver,postalCodeField).sendKeys(postalCode);

        findElementPresence(driver,phoneNumberField).sendKeys(phoneNumber);

        findElementClickable(driver,saveBuildingAddressBtn).click();

        return this;
    }
    @Step
    public CheckOutPage clickShippingMethod(){
        findElementClickable(driver, saveShippingBtn).click();
        return this;
    }
    @Step
    public CheckOutPage clickPaymentMethod(){
        findElementClickable(driver, savePaymentBtn).click();
        return this;
    }
    @Step
    public CheckOutPage clickPaymentInfo(){
        findElementClickable(driver, savePaymentInfoBtn).click();
        return this;
    }
    @Step
    public CheckOutPage clickConfirmOrder(){
        findElementClickable(driver, confirmOrderBtn).click();
        return this;
    }
    @Step
    public final String getSuccessOrderText(){
        return findElementPresence(driver,successOrderMsg).getText();
    }



}
