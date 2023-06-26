package pages;

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

    public WindowsProProductPage clickWindowsAddToCart(){
        findElementPresence(driver,addToCartWindowsProduct).click();
        return this;
    }

    public WindowsProProductPage clickCloseMsg(){

        findElementPresence(driver,closeAlertMsg).click();
        return this;
    }

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
