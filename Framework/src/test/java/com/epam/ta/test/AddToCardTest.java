package com.epam.ta.test;

import com.epam.ta.page.ProductsPage;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;


public class AddToCardTest extends CommonConditions{
    @Test
    public void AddProductToCardTest(){
        String productQty = new ProductsPage(driver)
                .openPage()
                .submitShipItButton()
                .choosePickItOption()
                .submitAddToCardButton()
                .ViewCardButton()
                .countProductsInCard();
        assertEquals("1", productQty);
    }
}

