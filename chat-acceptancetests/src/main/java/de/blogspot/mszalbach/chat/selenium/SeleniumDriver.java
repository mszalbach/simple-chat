package de.blogspot.mszalbach.chat.selenium;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.java.guice.ScenarioScoped;
import de.blogspot.mszalbach.chat.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.inject.Inject;

/**
 * Created by foobar on 14.08.15.
 */
@ScenarioScoped
public class SeleniumDriver {
    private WebDriver webDriver;
    private Config config;

    @Inject
    SeleniumDriver(Config config) {
        this.config = config;
    }


    public WebDriver getDriver() {
        return webDriver;
    }

    @Before("@web")
    public void openBrowser() {
        webDriver = config.getWebDriver();
    }


    @After("@web")
    public void close() {
        webDriver.quit();
    }


    public void loadPage(String url) {
        webDriver.get("http://" + config.getApplicationURL() + "/" + config.getApplicationContext() + "/" + url);
    }

    public void waitUntilPageContainsId(final String id) throws InterruptedException {
        new WebDriverWait(webDriver, 10)
                .until((WebDriver d) -> d.findElement(By.id(id)));
    }

    public void typeIntoField(String id, String value) {
        WebElement element = webDriver.findElement(By.id(id));
        element.clear();
        element.sendKeys(value);
    }
}
