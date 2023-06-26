package categories;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverCategory extends TestBase {

@Test
public void chooseSoftwareFromCategories(){

    Assert.assertTrue(
            homePage.hoverCategory(0)
                    .clickSoftware()
                    .categorySoftwarePageTitle()
                    .contains("Software")
    );


}


}
