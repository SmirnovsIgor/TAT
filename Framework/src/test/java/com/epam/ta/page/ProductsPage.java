package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;


public class ProductsPage extends AbstractPage {

    private final String BASE_URL = "https://www.walgreens.com/store/c/moisturizers/ID=360495-tier3";
    String brandText;

    @FindBy(id = "onSortOptionChangeHandler")
    private WebElement filterMenu;

    @FindBy(xpath = "//*[@id=\"onSortOptionChangeHandler\"]/option[3]")
    private WebElement priceHighToLowOption;

    @FindBy(xpath = "//*[@id=\"onSortOptionChangeHandler\"]/option[2]")
    private WebElement priceLowToHighOption;

    @FindBy(xpath = "//button[contains(@class, 'btn__blue')][1]")
    private WebElement shipItButton;

    private final By addToCartButtonCheckoutLocator  =  By.id("addToCart-cart-checkout");
    private final By viewCartButtonLocator  =  By.id("addToCart-view-cart");
    private final By choosePickProductUpLocator = By.id("atc-pickit-option");
    private final By firstCartLocator = By.xpath("//div[contains(@class,'item card')][1]");
    private final By priceLocator = By.cssSelector("span.product__price.font__sixteen");
    private final By brandCheckboxLocator = By.xpath("//*[@id=\"filter-container\"]/div/nav/ul/li[3]/fieldset/div/div/ul/li[1]");
    private final By productsBrand = By.xpath("//*[contains(@class, 'brand')]");
    private final By brand = By.xpath("//*[@id=\"filter-container\"]/div/nav/ul/li[3]/fieldset/div/div/ul/li[1]/label/span[2]");

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    @Override
    public ProductsPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public ProductsPage openFilterMenu() {
        filterMenu.click();
        return this;
    }

    public ProductsPage chooseHighToLowFilter() {
        priceHighToLowOption.click();
        return this;
    }

    public ProductsPage chooseLowToHighFilter() {
        priceLowToHighOption.click();
        return this;
    }

    public List<Double> getAllProductPrices() {
        List<Double> productPrices = new LinkedList<>();

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(firstCartLocator));
        List<WebElement> pricesList = driver.findElements(priceLocator);
        pricesList.forEach(p -> productPrices.add(Double.parseDouble(p.getText().transform(price -> {
            price = price.substring(price.indexOf("$") + 1);
            price = price.substring(0, price.indexOf(".") + 3);
            return price;
        }))));
        return productPrices;
    }

    public ProductsPage submitShipItButton()
    {
        shipItButton.click();
        return this;
    }

    public ProductsPage choosePickItOption(){
        driver.findElement(choosePickProductUpLocator).click();
        return this;
    }

    public ProductsPage submitAddToCartButton(){
        driver.findElement(addToCartButtonCheckoutLocator).click();
        return this;
    }

    public CartPage ViewCartButton(){
        driver.findElement(viewCartButtonLocator).click();
        return new CartPage(driver);
    }

    public ProductsPage pickProductsBrand(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(brandCheckboxLocator));
        driver.findElement(brandCheckboxLocator).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(brand));
        brandText = driver.findElement(brand).getText();
        return this;
    }

    public Boolean checkPickedBrand(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(productsBrand));
        List<WebElement> productsBrands = driver.findElements(productsBrand);
        Long brandsQty = productsBrands.stream()
                                       .filter(b -> b.getText().startsWith(brandText))
                                       .count();
        if (brandsQty == (long) productsBrands.size()){
            return true;
        }
        return false;
    }
}
