package edu.ap.ProductRegistration;

import edu.ap.Product;
import org.json.simple.JSONArray;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import edu.ap.ProductJSONParser;

public class ProductRegistrationResource extends ServerResource {

    @Get
    public JSONArray getProducts() {
        ProductJSONParser parser = new ProductJSONParser();

        return parser.getProducts();
    }

    @Post("text")
    public JSONArray addProduct(Product product) {
        ProductJSONParser parser = new ProductJSONParser();

        return parser.addProduct(product);

    }


}
