package de.blogspot.mszalbach.chat.ws;

import com.google.common.base.Strings;

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
    public static String getWebserviceHost() {
        String chatServerIP = System.getProperty("chat-server.ip");
        if (Strings.isNullOrEmpty(chatServerIP)) {
            return System.getProperty("chat-server.docker.ip", "localhost");
        } else {
            return chatServerIP;
        }

    }
}
