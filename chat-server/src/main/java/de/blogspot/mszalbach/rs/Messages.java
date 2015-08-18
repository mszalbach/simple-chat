package de.blogspot.mszalbach.rs;

import de.blogspot.mszalbach.chat.Controller.MessageController;
import de.blogspot.mszalbach.chat.entity.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * Created by foobar on 18.08.15.
 */
@Path("/messages")
@Produces({"application/json"})
public class Messages {

    private static final Logger LOGGER = LogManager.getLogger(Messages.class);

    @Inject
    MessageController controller;


    @GET
    //RestEasy can not override pased on QueryParam so the filtering must be done in one message
    public List<Message> listMessages(@QueryParam("user") String user, @QueryParam("content") String content) {
        return controller.searchMessageBasedOnUserAndContent(user, content);
    }

}
