package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.CustomMethods.*;

public class LoginPage {
    private WebDriver driver;
  public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    private final By emailField =By.xpath("//input[@class='email']");
    private final By passwordField =By.xpath("//input[@class='password']");
    private final By loginConfButton =By.xpath("//button[@class='button-1 login-button']");

    private final By alertMsgForLogin =By.xpath("//a[@class='ico-account']");


    @Step
    public LoginPage enterLoginEmail(String email){
        findElementPresence(driver,emailField).sendKeys(email);
        return this;
    }
    @Step
    public LoginPage enterLoginPassword(String password){
        findElementPresence(driver,passwordField).sendKeys(password);
        return this;
    }
    @Step
    public HomePage confirmLogin(){
        findElementClickable(driver,loginConfButton).click();
        return new HomePage(driver);
    }



}
