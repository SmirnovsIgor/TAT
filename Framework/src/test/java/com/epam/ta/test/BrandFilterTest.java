package com.epam.ta.test;

import com.epam.ta.page.ProductsPage;
import org.testng.annotations.Test;

public class BrandFilterTest extends CommonConditions{
    @Test
    public void removeBrandFilterTest(){
        Boolean productsBrandFilterRemoved = new ProductsPage(driver)
                .openPage()
                .pickProductsBrand().removeProductBrandFilter();
        assertEquals(true, productsBrandFilterRemoved);
    }
}
