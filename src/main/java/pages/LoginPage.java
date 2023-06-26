package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
  public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    private final By emailField =By.xpath("//input[@class='email']");
    private final By passwordField =By.xpath("//input[@class='password']");
    private final By loginConfButton =By.xpath("//button[@class='button-1 login-button']");

    private final By alertMsgForLogin =By.xpath("//a[@class='ico-account']");



    public LoginPage enterLoginEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage enterLoginPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public HomePage confirmLogin(){
        driver.findElement(loginConfButton).click();
        return new HomePage(driver);
    }



}
