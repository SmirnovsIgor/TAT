package com.epam.ta.test;

import com.epam.ta.model.User;
import com.epam.ta.page.LoginPage;
import com.epam.ta.page.MainPage;
import com.epam.ta.service.UserCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class UserLoginTest extends CommonConditions {
	@Test
	public void oneCanLoginWalgreens()
	{
		User testUser = UserCreator.withCredentialsFromProperty();
		MainPage mainPage = new LoginPage(driver)
				.openPage()
				.login(testUser);
		String loggedInUserName = mainPage.getLoggedInUserName();
		assertThat(loggedInUserName, is(equalTo(testUser
				.getName()
				.transform(s->
						s.substring(0, s.indexOf(' '))
				)
		)));
	}
}
