package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.CustomMethods.*;

public class SoftwareCategoriesPage {

   private WebDriver driver;

  public   SoftwareCategoriesPage(WebDriver driver){
        this.driver = driver;
    }

    private final By pageSoftwareTitle = By.xpath("//div[@class=\"page-title\"]/h1");

    private final By windowsEightBtn =  By.xpath("//h2[@class='product-title']//a[@href='/windows-8-pro']");

    @Step
    public String categorySoftwarePageTitle(){

        return findElementPresence(driver,pageSoftwareTitle).getText();
    }
    @Step
    public WindowsProProductPage clickOnWindowsProProduct(){

       findElementClickable(driver,windowsEightBtn).click();

        return new WindowsProProductPage(driver);
    }







}
