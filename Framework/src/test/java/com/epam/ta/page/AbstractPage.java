package com.epam.ta.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage
{
	protected WebDriver driver;

	protected abstract AbstractPage openPage();
	protected final int WAIT_TIMEOUT_SECONDS = 30;

	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}
}
