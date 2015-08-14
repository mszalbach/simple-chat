package de.blogspot.mszalbach.chat;

import com.google.common.base.Strings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Created by foobar on 17.05.15.
 */
public class Config {

    private Config() {
    }

    /**
     * Returns the ip of the docker container or localhost if not set. To run tests against other host use the property chat-server.ip.
     *
     * @return ip where the webservice to test is located
     */
    public static String getHost() {
        String chatServerIP = System.getProperty("chat-server.ip");
        if (Strings.isNullOrEmpty(chatServerIP)) {
            return System.getProperty("chat-server.docker.ip", "localhost");
        } else {
            return chatServerIP;
        }

    }

    public static String getApplicationURL() {
        return getHost()+":8080";
    }

    public static String getApplicationContext() {
        return "chat-server";
    }

    public static WebDriver getWebDriver() {
        return new FirefoxDriver(new FirefoxProfile());
    }
}
