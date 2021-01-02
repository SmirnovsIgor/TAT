package com.epam.ta.test;

import com.epam.ta.page.ProductsPage;
import org.testng.annotations.Test;


public class RemoveFromCardTest extends CommonConditions{
    @Test
    public void RemoveProductFromCartTest()
    {
        Boolean isEmpty = new ProductsPage(driver)
                .openPage()
                .submitShipItButton()
                .choosePickItOption()
                .submitAddToCartButton()
                .ViewCartButton().removeProductFromCart().checkIfCartIsEmpty();
        assertEquals(true, isEmpty);
    }
}
