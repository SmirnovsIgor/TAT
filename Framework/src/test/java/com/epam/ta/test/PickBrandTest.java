package com.epam.ta.test;

import com.epam.ta.page.ProductsPage;
import org.testng.annotations.Test;


public class PickBrandTest extends CommonConditions{
    @Test
    public void pickBrandTest(){
        Boolean productsBrandFilterSelected = new ProductsPage(driver)
                .openPage().pickProductsBrand().checkPickedBrand();
        assertEquals(productsBrandFilterSelected, true);
    }
}
