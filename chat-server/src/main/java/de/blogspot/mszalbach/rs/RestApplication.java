package de.blogspot.mszalbach.rs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Created by foobar on 18.08.15.
 */
@ApplicationPath("rs")
public class RestApplication extends Application {
    //needed to activate rest classes which can be accessed with appContext/rs/*
}
