import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

import java.net.URI;

public class Main {
    public static void main(String[] args) {
        URI baseUri = URI.create("http://localhost:8080/");
        ResourceConfig config = new ResourceConfig(RandomNumberResource.class);
        config.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        JettyHttpContainerFactory.createServer(baseUri, config);
    }
}
