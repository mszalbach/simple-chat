package de.blogspot.mszalbach.chat.ws;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by foobar on 16.05.15.
 */
public class WebsocketSteps {

    private Map<String, WebsocketClient> wsClients;

    private WebSocketContainer container;
    private String wsHost;

    @Before
    public void setup() {
        wsClients = new HashMap<>();
        container = ContainerProvider.getWebSocketContainer();
        wsHost = System.getProperty("chat-server.ip");
    }

    @Given("^a websocket connection (.+)$")
    public void createWebsocketConnection(String clientName) throws URISyntaxException, IOException, DeploymentException {

        WebsocketClient ws = new WebsocketClient();
        wsClients.put(clientName, ws);
        ws.connect(container, new URI("ws://" + wsHost + ":8080/chat-server/websocket"));
    }

    @When("^(.+) sends message \"(.+)\"$")
    public void sendMessage(String clientName, String message) throws IOException {
        WebsocketClient client = wsClients.get(clientName);
        client.sendText(message);


    }

    @Then("^(.+) received message \"(.+)\"$")
    public void assertMessageReceived(String clientName, String message) {
        WebsocketClient client = wsClients.get(clientName);
        assertThat(client.getLastMessage(), is(message));
    }

    @Then("^(.+) did not receive message \"(.+)\"$")
    public void assertMessageNotReceived(String clientName, String message) throws Throwable {
        WebsocketClient client = wsClients.get(clientName);
        assertThat(client.getLastMessage(), not(message));
    }

    @When("^(.+) goes offline$")
    public void clientGoesOffline(String clientName) throws Throwable {
        WebsocketClient client = wsClients.get(clientName);
        client.close();
        assertThat(client.isOpen(), is(false));
    }
}
