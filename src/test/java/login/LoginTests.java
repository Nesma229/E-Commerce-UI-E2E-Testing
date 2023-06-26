package login;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.DataDrivenClass.JsonClass.readJson;


public class LoginTests extends TestBase {

//String jsonFilePath = System.getProperty("user.dir") + "src\\test\\resources\\LoginData.json";


String jsonFilePath = "D:\\Selenium\\Selenium test\\E-Commerce-UI-E2E-Testing\\src\\test\\java\\resources\\LoginData.json";

    @Test
    public void testValidLogin(){
        Assert.assertTrue(
           homePage.clickLoginForm()
                   .enterLoginEmail(readJson(jsonFilePath,"email1"))
                   .enterLoginPassword(readJson(jsonFilePath,"password1"))
                   .confirmLogin()
                   .getAlertForLogin().contains("My account"), "login unsuccessful"
                );
    }


}
