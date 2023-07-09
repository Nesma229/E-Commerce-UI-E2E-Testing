package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.CustomMethods.*;

public class WindowsProProductPage {

    private WebDriver driver;
    public WindowsProProductPage(WebDriver driver){
        this.driver = driver;
    }

    private final By addToCartWindowsProduct = By.xpath("//button[@id='add-to-cart-button-11']");

    private final By closeAlertMsg = By.xpath("//span[@title='Close']");
    private final By shoppingCartIcon = By.className("ico-cart");
 //   private final By goToCartButton = By.xpath("//button[@class='button-1 cart-button']");


    @Step
    public WindowsProProductPage clickWindowsAddToCart(){
        findElementClickable(driver,addToCartWindowsProduct).click();
        return this;
    }
    @Step
    public WindowsProProductPage clickCloseMsg(){

        findElementClickable(driver,closeAlertMsg).click();
        return this;
    }
    @Step
    public ShoppingCartPage clickShoppingCartIcon(){
        findElementClickable(driver,shoppingCartIcon).click();
        return new ShoppingCartPage(driver);
    }

//    public WindowsProProductPage hoverShoppingCartIcon()  {
//
//        Actions action = new Actions(driver);
//        action.moveToElement(findElementWithFluentWait(driver,shoppingCartIcon)).perform();
//        return this;
//    }

//    public ShoppingCartPage clickGoToCart(){
//        findElementWithFluentWait(driver,goToCartButton).click();
//        return new ShoppingCartPage(driver);
//    }





}
