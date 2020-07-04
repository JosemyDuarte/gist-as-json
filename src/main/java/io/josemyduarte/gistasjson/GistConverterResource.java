package io.josemyduarte.gistasjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
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
    public static final String GIST_URL = "gist.githubusercontent.com";

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonNode convert(@QueryParam("url") final String url) {
        if (Strings.isNullOrEmpty(url)) {
            return OBJECT_MAPPER.createObjectNode()
                    .put("message", "You need to provide a url");
        }
        final URI receivedURL = URI.create(url);
        if (UrlChecker.isValid(GIST_URL, receivedURL)) {
            return OBJECT_MAPPER.createObjectNode()
                    .put("message", String.format("You need to provide a valid Gist url. [%s] is not valid", url));
        }

        final String content = RestClientBuilder.newBuilder()
                .baseUri(receivedURL)
                .build(GistClient.class)
                .getContent();

        try {
            return OBJECT_MAPPER.readValue(content, JsonNode.class);
        } catch (JsonProcessingException e) {
            return OBJECT_MAPPER.createObjectNode()
                    .put("message", "We had a problem converting the content given by your URL to JSON. Are you sure is a valid JSON?");
        }
    }
}