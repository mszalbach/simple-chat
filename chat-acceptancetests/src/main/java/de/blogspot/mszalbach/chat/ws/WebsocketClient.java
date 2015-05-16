package de.blogspot.mszalbach.chat.ws;

import javax.websocket.ClientEndpoint;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by foobar on 16.05.15.
 */
@ClientEndpoint
public class WebsocketClient {

    private LinkedList<String> messages = new LinkedList<>();

    @OnMessage
    public void onMessage( String message, Session client )
            throws IOException,
            EncodeException {
        messages.add(message);
    }

    public String getLastMessage() {
        if(messages.isEmpty()) {
            return null;
        }
        return messages.getLast();
    }

}
