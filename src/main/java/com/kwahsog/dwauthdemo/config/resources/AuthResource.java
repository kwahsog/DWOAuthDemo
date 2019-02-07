package com.kwahsog.dwauthdemo.config.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kwahsog.dwauthdemo.api.AccessTokenData;
import com.kwahsog.model.OAuthRequest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("api")
public class AuthResource {

    private final static String GOOGLE_OAUTH_URI =
            "https://www.googleapis.com/oauth2/v2/tokeninfo";


    //OTHER URL
//    private final static String GOOGLE_OAUTH_URI2 =
//            "https://oauth2.googleapis.com/tokeninfo";


    private Client jerseyClient;

    public AuthResource(Client jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    @POST
    @Path("/v1/auth/google")
    @Consumes({MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON})
    public String auth(String jsonString, @Context HttpServletRequest httpServletRequest) throws IOException {

        String temp = jsonString;
        ObjectMapper objectMapper = new ObjectMapper();
        OAuthRequest request = objectMapper.readValue(jsonString, OAuthRequest.class);

        //Ping google server to authenticate token
        final Response googleResp = jerseyClient.target(GOOGLE_OAUTH_URI)
                .queryParam("access_token",request.getAccess_token())
                .request(MediaType.APPLICATION_JSON)
                .get();
        AccessTokenData accessTokenData = googleResp.readEntity(AccessTokenData.class);

        //Write our own token back to webpage (remove this)
        String stringTest = objectMapper.writeValueAsString(accessTokenData);

        //TODO: Implement auth service.
        //Check valid email - ie @domain.com
        //Also allow this in google dev portal.
        //Email, Our UUID (UUID), Google UUID (GUUID).
        //In Service store <Email, UUID>, <Email, GUUID>, <UUID, token> + add token expiry?

        return stringTest;
    }

}