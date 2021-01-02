package com.epam.ta.test;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.util.TestListener;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.openqa.selenium.WebDriver;

@Listeners({TestListener.class})
public class CommonConditions extends Assertions {

    protected WebDriver driver;


    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
