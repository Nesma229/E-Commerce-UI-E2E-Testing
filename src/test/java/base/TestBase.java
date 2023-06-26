package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class TestBase {

private WebDriver driver;
protected HomePage homePage;
@BeforeMethod
    public void setUp(){


    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://demo.nopcommerce.com");

    homePage = new HomePage(driver);

}

@AfterMethod
public void tearDown() throws InterruptedException {
    Thread.sleep(3000);
    driver.quit();
}




}
