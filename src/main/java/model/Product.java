package model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.List;

/**
 * Created by gleb on 12.07.15.
 */
@Entity("products")
public class Product {

    @Id
    private ObjectId id;

    private String title;

    private double price;

    private String description;

    private List<String> listOfSize;

    private List<String> listOfImageURLs;

    public Product(String title, double price, String description, List<String> listOfSize, List<String> listOfImageURLs) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.listOfSize = listOfSize;
        this.listOfImageURLs = listOfImageURLs;
    }

}
