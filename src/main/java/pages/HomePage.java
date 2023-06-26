package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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


    public RegistrationPage clickRegistrationForm(){

    driver.findElement(regButton).click();
    return new RegistrationPage(driver);
    }


    public LoginPage clickLoginForm(){

        driver.findElement(logInButton).click();
        return new LoginPage(driver);
    }

    public String getAlertForLogin(){

    return driver.findElement(alertMsgForLogin).getText();
    }

    //Search for product

    public SoftwareCategoriesPage searchForProduct(String productName){
    driver.findElement(searchField).sendKeys(productName);
    driver.findElement(searchButton).click();
    return new SoftwareCategoriesPage(driver);
    }

    public String productTitleText(int index){
    return   driver.findElements(elementTitle).get(index).getText();
    }

    public int productSize(){
    return  driver.findElements(elementTitle).size();
    }

   //Change currency

    public HomePage selectCurrency(String typeOfCurrency) {
        Select selectDay = new Select(driver.findElement(currency));
        selectDay.selectByVisibleText(typeOfCurrency);
        return this;
    }

    public String productPricesText(int index){

        return driver.findElements(elementPrice).get(index).getText();
    }

    public int elementPricesSize(){

        return driver.findElements(elementPrice).size();
    }

  //Select Categories



    public  HomePage hoverCategory(int index){

    Actions action =  new Actions(driver);
    action.moveToElement(driver.findElements(computerCategories).get(index)).perform();
    return this;
   }


    public SoftwareCategoriesPage clickSoftware(){
        driver.findElement(softwareCategory).click();
        return new SoftwareCategoriesPage(driver);
    }


    //CategoriesPage
//    public CategoriesPage clickComputerCategories(){
//        driver.findElement(computerCategories).click();
//        return new CategoriesPage(driver);
//    }








}
