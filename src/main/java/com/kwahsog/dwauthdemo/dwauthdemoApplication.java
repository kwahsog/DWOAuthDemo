package com.kwahsog.dwauthdemo;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class dwauthdemoApplication extends Application<dwauthdemoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new dwauthdemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "dwauthdemo";
    }

    @Override
    public void initialize(final Bootstrap<dwauthdemoConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final dwauthdemoConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
