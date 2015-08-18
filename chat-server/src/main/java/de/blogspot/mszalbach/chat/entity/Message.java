package de.blogspot.mszalbach.chat.entity;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by foobar on 18.08.15.
 */
@Entity("messages")
@XmlRootElement
public class Message {

    @Id
    @XmlTransient
    public ObjectId id;
    public String user;
    public String message;

    public Message() {
    }

    public Message(String user, String message) {
        this.user = user;
        this.message = message;
    }


}
