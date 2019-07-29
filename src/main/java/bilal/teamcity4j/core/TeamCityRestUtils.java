package bilal.teamcity4j.core;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TeamCityRestUtils {

    private static Client client = ClientBuilder.newClient();
    private static HttpAuthenticationFeature httpAuthenticationFeature = HttpAuthenticationFeature.basic("bmirza","Primatics1");
    static{
        client.register(httpAuthenticationFeature);
    }
    public static Response post(String url, Object o) {
        return client.target(url).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(o,MediaType.APPLICATION_JSON));
    }

    public static Object get(String url, Class clazz) {
        return client.target(url).request(MediaType.APPLICATION_XML)
                .get(clazz);
    }
}
