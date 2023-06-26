package currency;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchCustomerCurrencyTest extends TestBase {

    @Test
    public void selectDollarFromCurrencies(){
        homePage.selectCurrency("US Dollar");



        int size =homePage.elementPricesSize();
        for(int i=0; i<size; i++){
            String actualPrice = homePage.productPricesText(i);
            Assert.assertTrue(actualPrice.contains("$"));
        }
    }

    @Test
    public void selectEuroFromCurrencies(){
        homePage.selectCurrency("Euro");



        int size =homePage.elementPricesSize();
        for(int i=0; i<size; i++){
            String actualPrice = homePage.productPricesText(i);
            Assert.assertTrue(actualPrice.contains("€"));
        }
    }




}
