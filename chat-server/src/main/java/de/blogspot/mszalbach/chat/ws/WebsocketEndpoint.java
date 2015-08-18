package de.blogspot.mszalbach.chat.ws;

import de.blogspot.mszalbach.chat.Controller.MessageController;
import de.blogspot.mszalbach.chat.entity.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ms
 * Date: 6/24/13
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
@ServerEndpoint("/websocket")
public class WebsocketEndpoint {

    // Create a Set to hold client sessions
    private static final Set<Session> CLIENT_SESSIONS = Collections.synchronizedSet(new HashSet<>());

    private static final Logger LOGGER = LogManager.getLogger(WebsocketEndpoint.class);

    @Inject
    private MessageController controller;


    @OnOpen
    public void onOpen(Session aClientSession)
            throws IOException {
        CLIENT_SESSIONS.add(aClientSession);
        aClientSession.getAsyncRemote().sendText("Login: " + new Date());
    }


    @OnClose
    public void onClose(Session aClientSession) {
        CLIENT_SESSIONS.remove(aClientSession);
    }


    @OnMessage
    public void onMessage(String message, Session client)
            throws IOException,
            EncodeException {

        controller.save(new Message(client.getId(), message));

        for (Session clientSession : CLIENT_SESSIONS) {
            clientSession.getAsyncRemote().sendText(message);
        }
    }


    @OnError
    public void onError(Session aclientSession, Throwable aThrowable) {
        LOGGER.error("Error : " + aclientSession + " " + aThrowable);

    }

}
