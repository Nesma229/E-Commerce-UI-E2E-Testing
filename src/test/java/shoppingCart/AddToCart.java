package shoppingCart;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.DataDrivenClass.JsonClass.readJson;

public class AddToCart extends TestBase {


    String jsonFilePathLogin = "D:\\Selenium\\Selenium test\\E-Commerce-UI-E2E-Testing\\src\\test\\java\\resources\\LoginData.json";
    String jsonFilePathCheckOut = "D:\\Selenium\\Selenium test\\E-Commerce-UI-E2E-Testing\\src\\test\\java\\resources\\CheckOutData.json";

    @Test
    public void testValidAddToCart() throws InterruptedException {
        Assert.assertTrue(
                homePage
                        .clickLoginForm()
                        .enterLoginEmail(readJson(jsonFilePathLogin,"email1"))
                        .enterLoginPassword(readJson(jsonFilePathLogin,"password1"))
                        .confirmLogin()
                        .hoverCategory(0)
                        .clickSoftware()
                        .clickOnWindowsProProduct()
                        .clickWindowsAddToCart()
                        .clickCloseMsg()
                        .clickShoppingCartIcon()
                        .clickTermOfServiceBox()
                        .clickCheckOutBtn()
                        .buildingAddress(readJson(jsonFilePathCheckOut,"country"),
                                readJson(jsonFilePathCheckOut,"city"),
                                readJson(jsonFilePathCheckOut, "address1"),
                                readJson(jsonFilePathCheckOut,"postalCode"),
                                readJson(jsonFilePathCheckOut,"phoneNumber"))
                        .clickShippingMethod()
                        .clickPaymentMethod()
                        .clickPaymentInfo()
                        .clickConfirmOrder()
                        .getSuccessOrderText().contains("Your order has been successfully processed!")
        );
    }


}
