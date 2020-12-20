package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://www.walgreens.com/";

	private final By linkLoggedInUserLocator = By.partialLinkText("Hi, ");

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}


	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		return this;
	}

	public String getLoggedInUserName()
	{
		WebElement linkLoggedInUser = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
				.until(ExpectedConditions.visibilityOfElementLocated(linkLoggedInUserLocator));
		return linkLoggedInUser.getText().substring(4);
	}
}
