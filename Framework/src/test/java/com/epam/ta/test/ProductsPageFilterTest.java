package com.epam.ta.test;

import com.epam.ta.page.ProductsPage;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class ProductsPageFilterTest extends CommonConditions {
    @Test
    public void SortByPriceHighToLowTest()
    {
        List<Double> productsPrices = new ProductsPage(driver)
                .openPage()
                .openFilterMenu()
                .chooseHighToLowFilter()
                .getAllProductPrices();
        assertEquals(productsPrices.get(0), Collections.max(productsPrices));
    }
    @Test
    public void SortByPriceLowToHighTest()
    {
        List<Double> productsPrices = new ProductsPage(driver)
                .openPage()
                .openFilterMenu()
                .chooseLowToHighFilter()
                .getAllProductPrices();
        assertEquals(productsPrices.get(0), Collections.min(productsPrices));
    }

}
