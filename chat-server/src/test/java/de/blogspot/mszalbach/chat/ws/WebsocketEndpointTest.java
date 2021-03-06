package de.blogspot.mszalbach.chat.ws;

import de.blogspot.mszalbach.chat.Controller.MessageController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.websocket.EncodeException;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: ms
 * Date: 6/24/13
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class WebsocketEndpointTest {

    @Mock
    private Session client1;

    @Mock
    private Session client2;

    @Mock
    private RemoteEndpoint.Async client1Endpoint;

    @Mock
    private RemoteEndpoint.Async client2Endpoint;

    @Mock
    private MessageController controller;

    @InjectMocks
    private WebsocketEndpoint ws;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        when(client1.getAsyncRemote()).thenReturn(client1Endpoint);
        when(client2.getAsyncRemote()).thenReturn(client2Endpoint);
    }

    @Test
    public void test_sending_message() throws IOException, EncodeException {
        ws.onOpen(client1);

        ws.onOpen(client2);

        ws.onMessage("Hello", client1);

        verify(client1Endpoint).sendText("Hello");
        verify(client2Endpoint).sendText("Hello");

        //ArgumentCaptor<Message> savedMessageCaptor = ArgumentCaptor.forClass(Message.class);
        //verify(controller).save(savedMessageCaptor.capture());

        // assertThat(savedMessageCaptor.getValue().message, is("Hello"));
    }

    @Test
    public void test_onClose() throws Exception {
        ws.onOpen(client1);
        ws.onClose(client1);
        ws.onMessage("Hello", client1);

        verify(client1Endpoint, never()).sendText("Hello");

    }
}
