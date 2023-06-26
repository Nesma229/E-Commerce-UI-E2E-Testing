package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterConfirmPage {
    private WebDriver driver;
    public RegisterConfirmPage(WebDriver driver){
        this.driver = driver;
    }


    private final By registerSuccessfulMessage = By.xpath("//div[@class='result']");
    private final By continueBtn = By.xpath("//a[@class='button-1 register-continue-button']");



    public final String getAlertText(){
        return driver.findElement(registerSuccessfulMessage).getText();
    }

    public HomePage clickContinue(){
        driver.findElement(continueBtn).click();
        return new HomePage(driver);
    }




}
