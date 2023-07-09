package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static utils.CustomMethods.*;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    private By genderFemale = By.xpath("//input[@value='F']");
    private By firstNameField = By.xpath("//input[@id='FirstName']");
    private By lastNameField = By.xpath("//input[@id='LastName']");
    private By birthDayField =(By.xpath("//select[@name='DateOfBirthDay']"));
    private By birthMonthField = By.xpath("//select[@name='DateOfBirthMonth']");
    private By birthYearField = By.xpath("//select[@name='DateOfBirthYear']");
    private By emailField = By.xpath("//input[@id='Email']");
    private By passwordField = By.xpath("//input[@id='Password']");
    private By passwordConfField = By.xpath("//input[@id='ConfirmPassword']");
    private By registerConfBtn = By.xpath("//button[@id='register-button']");

    @Step
    public  RegistrationPage clickGenderRadioBtn(){
       findElementClickable(driver,genderFemale).click();
       return this;
    }
    @Step
    public  RegistrationPage enterFirstAndLastName(String firstName , String lastName){
      findElementPresence(driver,firstNameField).sendKeys(firstName);
      findElementPresence(driver,lastNameField).sendKeys(lastName);
      return  this;
    }
    @Step
    public  RegistrationPage selectDateOfBirth(String day , String month , String year){
      Select selectDay = new Select(findElementPresence(driver,birthDayField));
      selectDay.selectByVisibleText(day);
      Select selectMonth = new Select(findElementPresence(driver,birthMonthField));
      selectMonth.selectByVisibleText(month);
      Select selectYear = new Select(findElementPresence(driver,birthYearField));
      selectYear.selectByVisibleText(year);

    return  this;
    }
    @Step
    public  RegistrationPage enterEmail(String email){
       findElementPresence(driver,emailField).sendKeys(email);
       return this;
    }
    @Step
    public  RegistrationPage enterPassAndConfirmPass(String password , String confirmPassword){
      findElementPresence(driver,passwordField).sendKeys(password);
      findElementPresence(driver,passwordConfField).sendKeys(confirmPassword);
      return  this;
    }
    @Step
    public  RegisterConfirmPage saveRegistrationData(){
        findElementClickable(driver,registerConfBtn).click();
        return new RegisterConfirmPage(driver);

    }









}
