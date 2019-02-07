import com.kwahsog.dwauthdemo.CrossDomainFilter;
import com.kwahsog.dwauthdemo.config.MainConfiguration;
import com.kwahsog.dwauthdemo.config.resources.AuthResource;
import com.kwahsog.dwauthdemo.config.resources.MainResource;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.SocketConfig;
import org.glassfish.jersey.client.ClientProperties;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.ws.rs.client.Client;
import java.util.EnumSet;

public class MainApp extends Application<MainConfiguration> {

    private SocketConfig socketConfig;
    private RequestConfig requestConfig;

    public static void main(String[] args) throws Exception {
        new MainApp().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<MainConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(MainConfiguration configuration,
                    Environment environment) {
        final MainResource resource = new MainResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        final Client jerseyClient = new JerseyClientBuilder(environment)
                .build("http-client");
        jerseyClient.property(ClientProperties.CONNECT_TIMEOUT, 1000);
        jerseyClient.property(ClientProperties.READ_TIMEOUT,    1000);

        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossDomainFilter.class);

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/api/*");

        final AuthResource authResource = new AuthResource(jerseyClient);

        environment.jersey().register(resource);
        environment.jersey().register(authResource);

    }
}
