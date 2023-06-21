package com.rest.app;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import resource.OrderResource;

import java.io.IOException;
import java.net.URI;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    //??
    private static final URI BASE_URI = URI.create("http://localhost:8080/rest/");
    public static final String ROOT_PATH = "orders";

    public static void main(String[] args) {
        try {
            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, create(), false);
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    server.shutdownNow();
                }
            }));
            server.start();

            System.out.println(
                    String.format("Application started.%n"
                                    + "Try out %s%s%n"
                                    + "Stop the application using CTRL+C",
                            BASE_URI, ROOT_PATH));

            Thread.currentThread().join();
        } catch (IOException | InterruptedException ex) {
            LOGGER.debug("Exception ",ex);
        }

    }

    /**
     * Create example application resource configuration.
     *
     * @return initialized resource configuration of the example application.
     */
    public static ResourceConfig create() {
        final ResourceConfig resourceConfig = new ResourceConfig(OrderResource.class);

        return resourceConfig;
    }
}
