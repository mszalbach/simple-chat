package de.blogspot.mszalbach.chat.ws;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.util.LinkedList;

/**
 * Created by foobar on 16.05.15.
 */
@ClientEndpoint
public class WebsocketClient {

    private LinkedList<String> messages = new LinkedList<>();

    private Session clientSession;

    @OnMessage
    public void onMessage(String message, Session client)
            throws IOException,
            EncodeException {
        messages.add(message);
    }

    public String getLastMessage() {
        if (messages.isEmpty()) {
            return null;
        }
        return messages.getLast();
    }

    public void connect(WebSocketContainer container, URI uri) throws IOException, DeploymentException {
        this.clientSession = container.connectToServer(this, uri);
    }

    public void close() throws IOException {
        clientSession.close();
    }

    public boolean isOpen() {
        return clientSession.isOpen();
    }

    public void sendText(String message) throws IOException {
        clientSession.getBasicRemote().sendText(message);
        try {
            //ensure message is send via websocket
            Thread.sleep(100);
        } catch (InterruptedException e) {
            //ignore
        }
    }
}
