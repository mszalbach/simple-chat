package de.blogspot.mszalbach.chat.Controller;

import com.google.common.base.Strings;
import de.blogspot.mszalbach.chat.entity.Message;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by foobar on 18.08.15.
 */
@Stateless
public class MessageController {

    @Inject
    private Datastore datastore;

    public List<Message> getAllMessages() {
        return searchMessageBasedOnUserAndContent(null, null);
    }

    public List<Message> searchMessageBasedOnUserAndContent(String user, String content) {

        Query<Message> query = datastore.createQuery(Message.class);

        if (!Strings.isNullOrEmpty(user)) {
            query.field("user").equal(user);
        }

        if (!Strings.isNullOrEmpty(content)) {
            query.field("message").containsIgnoreCase(content);
        }

        return query.asList();
    }

    public void save(Message message) {
        datastore.save(message);
    }


}
