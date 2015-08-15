package de.blogspot.mszalbach.chat.selenium;

import de.blogspot.mszalbach.chat.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.inject.Inject;

/**
 * Created by foobar on 14.08.15.
 */
public class SeleniumDriver {
    private WebDriver webDriver;
    private Config config;

    @Inject
    SeleniumDriver(Config config) {

        this.config = config;
    }


    public WebDriver getCurrentDriver() {
        if (webDriver==null) {
            try {
                webDriver = config.getWebDriver();
            } finally{
                Runtime.getRuntime().addShutdownHook(
                        new Thread(new BrowserCleanup()));
            }
        }
        return webDriver;
    }


    public  WebDriver getDriver() {
        return getCurrentDriver();
    }

    private class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }
    }

    public void close() {
        try {
            getCurrentDriver().quit();
            //without this the browser will not be closed
            webDriver = null;
        } catch (UnreachableBrowserException e) {
        }
    }


    public void loadPage(String url) {
        getCurrentDriver().get("http://" + config.getApplicationURL() + "/" + config.getApplicationContext() + "/" + url);
    }

    public void waitUntilPageContainsId(final String id) throws InterruptedException {
        new WebDriverWait(getCurrentDriver(), 10)
                .until((WebDriver d) -> d.findElement(By.id(id)));
    }

    public void typeIntoField(String id, String value) {
        WebElement element = getCurrentDriver().findElement(By.id(id));
        element.clear();
        element.sendKeys(value);
    }
}
