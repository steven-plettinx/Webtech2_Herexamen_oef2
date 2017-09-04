package edu.ap.ProductRegistration;

import edu.ap.Product;
import org.json.simple.JSONArray;
import org.restlet.resource.ClientResource;

public class ProductRegistrationClient {

    public static void main(String[] args) {

        try {
            ClientResource resource = new ClientResource("http://localhost:8181/products/producten");

            //add two  new orders
            Product product1 = new Product();
            product1.setName("something");
            product1.setProducer("somethingelse");
            product1.setPrice(5);

            Product product2 = new Product();
            product2.setName("this");
            product2.setProducer("that");
            product2.setPrice(10);


            resource.post(product1);
            resource.post(product2);

            // get the response
            System.out.println(resource.getResponseEntity().getText());
        }
        catch (Exception e) {
            System.out.println("In main : " + e.getMessage());
        }
    }

    public static JSONArray getProducts() {

        JSONArray arr = new JSONArray();
        try {
            ClientResource resource = new ClientResource("http://localhost:8181/products/producten");
            resource.get();
            Object object = resource.getResponseEntity();
            arr = (JSONArray) object;
        }
        catch (Exception e) {
            System.out.println("In main : " + e.getMessage());
        }

        return arr;
    }

}
