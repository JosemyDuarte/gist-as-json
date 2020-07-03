package io.josemyduarte.gistasjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.net.URI;

@Path("/asJson")
public class GistConverterResource {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonNode convert(@QueryParam("url") String url) throws JsonProcessingException {

        String myResume = RestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(GistClient.class)
                .getMyResume();

        return new ObjectMapper().readValue(myResume, JsonNode.class);
    }
}