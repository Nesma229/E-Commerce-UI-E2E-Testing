package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static utils.CustomMethods.*;

public class HomePage {
private WebDriver driver;
public HomePage(WebDriver driver){
    this.driver = driver;
}

    private final By regButton = By.xpath("//a[@href='/register?returnUrl=%2F']");
    private final By logInButton = By.xpath("//a[@href='/login?returnUrl=%2F']");
    private final By alertMsgForLogin =By.xpath("//a[@class='ico-account']");

    private  final By searchField = By.xpath("//input[@id=\"small-searchterms\"]");
    private  final By searchButton = By.xpath("//button[@type=\"submit\"]");
    private  final By elementTitle = By.xpath("//h2[@class=\"product-title\"]/a");

    private  final By currency = By.id("customerCurrency");
    private  final By elementPrice = By.xpath("//span[@class='price actual-price']");


    private final By computerCategories = By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a");
    private final By softwareCategory = By.xpath("(//ul[@class=\"sublist first-level\"]/li/a)[3]");


   private final By macBookProduct = By.xpath("//img[@alt='Picture of Apple MacBook Pro 13-inch']");

    @Step
    public RegistrationPage clickRegistrationForm(){

    findElementClickable(driver,regButton).click();
    return new RegistrationPage(driver);
    }

    @Step
    public LoginPage clickLoginForm(){

        findElementClickable(driver,logInButton).click();
        return new LoginPage(driver);
    }
    @Step
    public String getAlertForLogin(){

    return findElementPresence(driver,alertMsgForLogin).getText();
    }

    //Search for product
    @Step
    public SoftwareCategoriesPage searchForProduct(String productName){
    findElementPresence(driver,searchField).sendKeys(productName);
    findElementClickable(driver,searchButton).click();
    return new SoftwareCategoriesPage(driver);
    }
    @Step
    public String productTitleText(int index){
    return   driver.findElements(elementTitle).get(index).getText();
    }

    @Step
    public int productSize(){
    return  driver.findElements(elementTitle).size();
    }

   //Change currency
   @Step
    public HomePage selectCurrency(String typeOfCurrency) {
        Select selectDay = new Select(findElementPresence(driver,currency));
        selectDay.selectByVisibleText(typeOfCurrency);
        return this;
    }
    @Step
    public String productPricesText(int index){

        return driver.findElements(elementPrice).get(index).getText();
    }
    @Step
    public int elementPricesSize(){

        return driver.findElements(elementPrice).size();
    }

  //Select Categories


    @Step
    public  HomePage hoverCategory(int index){

    Actions action =  new Actions(driver);
    action.moveToElement(driver.findElements(computerCategories).get(index)).perform();
    return this;
   }

    @Step
    public SoftwareCategoriesPage clickSoftware(){
        findElementClickable(driver,softwareCategory).click();
        return new SoftwareCategoriesPage(driver);
    }


    public HomePage registerScenario(String firstName, String lastName, String birthDay, String birthMonth, String birthYear,
                                     String email, String password){
        clickRegistrationForm()
                .clickGenderRadioBtn()
                .enterFirstAndLastName(firstName, lastName)
                .selectDateOfBirth(birthDay, birthMonth, birthYear)
                .enterEmail(email)
                .enterPassAndConfirmPass(password, password)
                .saveRegistrationData()
                .clickContinue();

        return this;
    }


    public HomePage loginScenario(String email, String password){
        clickLoginForm()
                .enterLoginEmail(email)
                .enterLoginPassword(password)
                .confirmLogin();

        return this;
    }


    //CategoriesPage
//    public CategoriesPage clickComputerCategories(){
//        driver.findElement(computerCategories).click();
//        return new CategoriesPage(driver);
//    }









}
