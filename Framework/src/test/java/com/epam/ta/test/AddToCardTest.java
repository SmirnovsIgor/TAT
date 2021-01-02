package com.epam.ta.test;

import com.epam.ta.page.ProductsPage;
import org.testng.annotations.Test;


public class AddToCardTest extends CommonConditions{
    @Test
    public void AddProductToCardTest(){
        String productQty = new ProductsPage(driver)
                .openPage()
                .submitShipItButton()
                .choosePickItOption()
                .submitAddToCartButton()
                .ViewCartButton()
                .countProductsInCart();
        assertEquals("1", productQty);
    }
}

