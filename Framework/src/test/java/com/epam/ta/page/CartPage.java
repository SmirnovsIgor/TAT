package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class CartPage extends AbstractPage{
    private final String BASE_URL = "https://www.walgreens.com/cart/view-ui";
    private final Logger logger = LogManager.getRootLogger();

    private final By removeButtonLocator = By.className("wag-cart-prd-remove-link");
    private final By productQuantityLocator = By.className("quantity");
    private final By cartIsEmptyHeader = By.tagName("h1");

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public CartPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public CartPage removeProductFromCart()
    {
        driver.findElement(removeButtonLocator).click();
        return this;
    }

    public String countProductsInCart(){
        String qty = driver.findElement(productQuantityLocator).getAttribute("value");
        return qty;
    }

    public Boolean checkIfCartIsEmpty(){
        String emptyHeader = driver.findElement(cartIsEmptyHeader).getText();
        logger.info(emptyHeader);
        return emptyHeader.equals("Your Cart is empty");
    }
}
