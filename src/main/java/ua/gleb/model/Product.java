package ua.gleb.model;

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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getListOfSize() {
        return listOfSize;
    }

    public void setListOfSize(List<String> listOfSize) {
        this.listOfSize = listOfSize;
    }

    public List<String> getListOfImageURLs() {
        return listOfImageURLs;
    }

    public void setListOfImageURLs(List<String> listOfImageURLs) {
        this.listOfImageURLs = listOfImageURLs;
    }
}
