package edu.ap.ProductRegistration;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class ProductRegistrationApplication extends Application {

    @Override
    public synchronized Restlet createInboundRoot() {

        Router router = new Router(getContext());

        router.attach("/producten", ProductRegistrationResource.class);
        //router.attach("/bestelling/{order_id}", BolComResource.class)

        return router;
    }

}
