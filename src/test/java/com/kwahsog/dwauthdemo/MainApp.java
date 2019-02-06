package com.kwahsog.dwauthdemo;

import com.kwahsog.dwauthdemo.config.MainConfiguration;
import com.kwahsog.dwauthdemo.resources.MainResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<MainConfiguration> {
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
        environment.jersey().register(resource);
    }
}
