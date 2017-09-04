package edu.ap;

import edu.ap.Product;
import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class ProductJSONParser {

    private String INPUTFILE = "/home/steven/products.json";


    public JSONArray addProduct(Product product) {

        JSONParser parser = new JSONParser();

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("Name", product.getName());
        jsonObject.put("Producer", product.getProducer());
        jsonObject.put("Price", product.getPrice());

        try {
            Object object = parser.parse(new FileReader(INPUTFILE));
            JSONArray arr = (JSONArray) object;
            arr.add(jsonObject);

            FileWriter file = new FileWriter(INPUTFILE);
            file.write(arr.toJSONString());
            file.flush();

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return this.getProducts();


    }

    public JSONArray getProducts() {

        JSONParser parser = new JSONParser();
        JSONArray result = new JSONArray();

        try {
            Object object = parser.parse(new FileReader(INPUTFILE));
            JSONArray arr = (JSONArray) object;
            result = arr;

        }
        catch (Exception e) {
            System.out.print(e.getMessage());
        }

        return result;
    }

    public JSONObject getProduct(String prodName) {
        JSONParser parser = new JSONParser();
        JSONObject result = new JSONObject();

        try {
            Object object = parser.parse(new FileReader(INPUTFILE));
            JSONArray arr = (JSONArray) object;

            for (Object o : arr) {
                JSONObject product = (JSONObject) o;

                if(product.get("name") == prodName) {
                    result = product;
                }

            }
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
        }

        return result;
    }

}
