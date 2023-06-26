package search;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    @Test
  public void searchForValidItem(){
        homePage.searchForProduct("shirt");

        int size = homePage.productSize();

        for (int i= 0 ; i<size ; i++ ){
            String actualTitle = homePage.productTitleText(i).toLowerCase().trim();
            Assert.assertTrue(actualTitle.contains("shirt"));
        }
    }


}
