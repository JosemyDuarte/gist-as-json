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

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonNode convert(@QueryParam("url") String url) {

        String myResume = RestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(GistClient.class)
                .getMyResume();

        try {
            return OBJECT_MAPPER.readValue(myResume, JsonNode.class);
        } catch (JsonProcessingException e) {
            return OBJECT_MAPPER.createObjectNode()
                    .put("message", "We had a problem converting your gist to JSON. Are you sure is a valid JSON?");
        }
    }
}