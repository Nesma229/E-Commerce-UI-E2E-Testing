package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.CustomMethods.*;

public class ShoppingCartPage {

    private WebDriver driver;
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }



    private final By checkOutButton = By.id("checkout");
    private final By termOfSeviceBox = By.id("termsofservice");

    @Step
    public ShoppingCartPage clickTermOfServiceBox(){
        findElementPresence(driver,termOfSeviceBox).click();
        return this ;
    }
    @Step
    public CheckOutPage clickCheckOutBtn(){
        findElementPresence(driver, checkOutButton).click();
        return new CheckOutPage(driver) ;
    }




}
