package io.josemyduarte.gistasjson;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface GistClient {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String getContent();
}
