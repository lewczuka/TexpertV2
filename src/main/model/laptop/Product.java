package main.model.laptop;

import main.model.laptop.Dimensions;

public class Product {
    private String name;

    private String makerID;
    private String brand;
    private String series;
    private String model;
    private Dimensions dimensions;
    private String weight;

    public Product(String makerID, String brand, String series, String model, Dimensions dimensions, String weight) {
        this.makerID = makerID;
        this.brand = brand;
        this.series = series;
        this.model = model;
        this.dimensions = dimensions;
        this.weight = weight;

        this.name = brand + " " + series + " " + model;
    }

    public String getName() {
        return name;
    }

    public String getMakerID() {
        return makerID;
    }

    public String getBrand() {
        return brand;
    }

    public String getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public String getWeight() {
        return weight;
    }
}
