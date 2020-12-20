package com.epam.ta.page;

import com.epam.ta.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String PAGE_URL = "https://www.walgreens.com/login.jsp";

	@FindBy(id = "user_name")
	private WebElement inputUserName;

	@FindBy(id = "user_password")
	private WebElement inputUserPassword;

	@FindBy(id = "submit_btn")
	private WebElement buttonSubmit;



	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public LoginPage openPage()
	{
		driver.navigate().to(PAGE_URL);
		logger.info("Login page opened");
		return this;
	}

	public MainPage login(User user)
	{
		inputUserName.sendKeys(user.getEmail());
		inputUserPassword.sendKeys(user.getPassword());
		buttonSubmit.click();
		logger.info("Login performed");
		return new MainPage(driver);
	}



}
