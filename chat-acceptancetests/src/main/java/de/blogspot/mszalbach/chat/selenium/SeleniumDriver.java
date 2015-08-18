package de.blogspot.mszalbach.chat.selenium;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.java.guice.ScenarioScoped;
import de.blogspot.mszalbach.chat.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.inject.Inject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by foobar on 14.08.15.
 */
@ScenarioScoped
public class SeleniumDriver {
    private WebDriver webDriver;
    private Config config;

    private static final Logger LOGGER = LogManager.getLogger(SeleniumDriver.class);

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
    public void close(Scenario s) {

        if (s.isFailed()) {
            takeScreenshot("screenshot-" + s.getName() + "_" + new Date());
        }


        webDriver.quit();
    }

    private void takeScreenshot(String fileName) {
        new File("target/surefire-reports/").mkdirs(); // Insure directory is there
        try (FileOutputStream out = new FileOutputStream("target/failsafe-reports/" + fileName + ".png")) {
            out.write(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            LOGGER.error("Could not take screenshot.", e);
        }
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
