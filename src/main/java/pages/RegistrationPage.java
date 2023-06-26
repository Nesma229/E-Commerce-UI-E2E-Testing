package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    private By genderFemale = By.xpath("//input[@value='F']");
    private By fName = By.xpath("//input[@id='FirstName']");
    private By lName = By.xpath("//input[@id='LastName']");
    private By birthDay =(By.xpath("//select[@name='DateOfBirthDay']"));
    private By birthMonth = By.xpath("//select[@name='DateOfBirthMonth']");
    private By birthYear = By.xpath("//select[@name='DateOfBirthYear']");
    private By emailField = By.xpath("//input[@id='Email']");
    private By passwordField = By.xpath("//input[@id='Password']");
    private By passwordConfField = By.xpath("//input[@id='ConfirmPassword']");
    private By registerConfBtn = By.xpath("//button[@id='register-button']");


    public  RegistrationPage clickGenderRadioBtn(){
       driver.findElement(genderFemale).click();
       return this;
    }

    public  RegistrationPage enterFirstAndLastName(String firstName , String lastName){
      driver.findElement(fName).sendKeys(firstName);
      driver.findElement(lName).sendKeys(lastName);
      return  this;
    }

    public  RegistrationPage selectDateOfBirth(String day , String month , String year){
      Select selectDay = new Select(driver.findElement(birthDay));
      selectDay.selectByVisibleText(day);
      Select selectMonth = new Select(driver.findElement(birthMonth));
      selectMonth.selectByVisibleText(month);
      Select selectYear = new Select(driver.findElement(birthYear));
      selectYear.selectByVisibleText(year);

    return  this;
    }

    public  RegistrationPage enterEmail(String email){
       driver.findElement(emailField).sendKeys(email);
       return this;
    }

    public  RegistrationPage enterPassAndConfirmPass(String password , String confirmPassword){
      driver.findElement(passwordField).sendKeys(password);
      driver.findElement(passwordConfField).sendKeys(confirmPassword);
      return  this;
    }

    public  RegisterConfirmPage saveRegistrationData(){
        driver.findElement(registerConfBtn).click();
        return new RegisterConfirmPage(driver);

    }









}
