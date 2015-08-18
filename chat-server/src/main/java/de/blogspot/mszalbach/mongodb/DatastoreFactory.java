package de.blogspot.mszalbach.mongodb;

import com.mongodb.MongoClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.net.UnknownHostException;

/**
 * Created by foobar on 18.08.15.
 */
@Stateless
public class DatastoreFactory {

    private static final Logger LOGGER = LogManager.getLogger(DatastoreFactory.class);


    @ApplicationScoped
    @Produces
    public Datastore createDatastore() throws UnknownHostException {
        Morphia morphia = new Morphia();

        morphia.mapPackage("de.blogspot.mszalbach.chat.entity");

        final Datastore datastore = morphia.createDatastore(new MongoClient("db"), "simple-chat");
        datastore.ensureIndexes();
        return datastore;
    }
}
