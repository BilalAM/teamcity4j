/**
 * MIT License
 * <p>
 * Copyright (c) 2019 Bilal Asif Mirza
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package bilal.teamcity4j.client;

import org.apache.log4j.Logger;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Bilal Asif Mirza (github.com/BilalAM)
 */
public class TeamCityRestUtils {

    private static Client restClient = ClientBuilder.newClient();
    private static final Logger LOGGER = Logger.getLogger(TeamCityRestUtils.class);

    public static void initiateAuthenticationFeature(String userName, String password) {
        HttpAuthenticationFeature httpAuthenticationFeature = HttpAuthenticationFeature.basic(userName, password);
        restClient.register(httpAuthenticationFeature);
    }

    public static Response postObject(String urlToHit, Object objectToSend) {
        return restClient.target(urlToHit).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(objectToSend, MediaType.APPLICATION_JSON));
    }

    public static Object getResponseAsObject(String urlToHit, Class responseTypeAsClass) {
        LOGGER.info("Firing [ GET ] request to [ " + urlToHit + " ] with response type to return as [ "
                + responseTypeAsClass + " ]");
        return restClient.target(urlToHit).request(MediaType.APPLICATION_XML).get(responseTypeAsClass);
    }
}
