package purchaseItemWithLogin;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.DataDrivenClass.JsonClass.readJson;

public class PurchaseItemWithLoginTest extends TestBase {


    String jsonFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\PurchaseScenarioData.json";
    @Test
    public void testValidAddToCart() throws InterruptedException {
        Assert.assertTrue(
                homePage
                        .registerScenario(
                                readJson(jsonFilePath, "firstName"),
                                readJson(jsonFilePath,"lastName"),
                                readJson(jsonFilePath,"day"),
                                readJson(jsonFilePath,"month"),
                                readJson(jsonFilePath,"year"),
                                readJson(jsonFilePath,"email"),
                                readJson(jsonFilePath,"password"))
                        .loginScenario(
                                readJson(jsonFilePath, "email"),
                                readJson(jsonFilePath, "password"))
                        .hoverCategory(0)
                        .clickSoftware()
                        .clickOnWindowsProProduct()
                        .clickWindowsAddToCart()
                        .clickCloseMsg()
                        .clickShoppingCartIcon()
                        .clickTermOfServiceBox()
                        .clickCheckOutBtn()
                        .buildingAddress(readJson(jsonFilePath,"country"),
                                readJson(jsonFilePath,"city"),
                                readJson(jsonFilePath, "address1"),
                                readJson(jsonFilePath,"postalCode"),
                                readJson(jsonFilePath,"phoneNumber"))
                        .clickShippingMethod()
                        .clickPaymentMethod()
                        .clickPaymentInfo()
                        .clickConfirmOrder()
                        .getSuccessOrderText().contains("Your order has been successfully processed!")
        );
    }


}
