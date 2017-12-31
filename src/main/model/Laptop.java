package main.model;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

public class Laptop {
    private String itemNumber;
    private String name = "";
    private static String brand = "";
    private static String series = "";
    private static String model = "";
    private static String partNumber = "";

    private static String processorType = "";
    private String processorSpeed = "";
    private String processorName = "";
    private String processorCores = "";

    private String screenSize = "";
    private String touchscreen = "";
    private String wideScreenSupport = "";
    private String displayType = "";
    private String resolution = "";
    private String lcdFeatures = "";

    private String operatingSystem = "";

    private String GPU = "";
    private String VRAM = "";

    public Laptop(){
    }

    public static void parseLaptop() throws IOException {
        String offline = "\"C:\\Users\\Adrian\\OneDrive\\Texpert\\Dell XPS 15 Touch 15.6_ Ultra Thin 4K Notebook Intel Core i7-7700HQ 2.8GHz 16 GB RAM 512 GB SSD NVIDIA GeForce GTX 1050 4GB Windows 10 Home - Newegg.ca.html\"";
        String online = "https://www.newegg.ca/Product/Product.aspx?Item=9SIA66K6KY5646&cm_re=xps15-_-9SIA66K6KY5646-_-Product";
        Connection connection = Jsoup.connect(online);
        Document doc = connection.get();
        Element specs = doc.getElementById("Specs");

        org.jsoup.select.Elements left = specs.select("dt");
        List<String> leftList = left.eachText();

        org.jsoup.select.Elements right = specs.select("dd");
        List<String> rightList = right.eachText();

        for (int i = 0; i < leftList.size() ; i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "Brand" : brand = rightList.get(i);
                case "Series" : series = rightList.get(i);
                case "Model" : model = rightList.get(i);
                case "Part Number" : partNumber = rightList.get(i);
                case "CPU Type" : processorType = rightList.get(i);
            }
        }
    }

    public static String getBrand(){
        return brand;
    }

    public static String printLaptop(){
        StringBuilder dundie = new StringBuilder();
        dundie.append(brand);
        dundie.append("\n");
        dundie.append(series);
        dundie.append("\n");
        dundie.append(model);
        dundie.append("\n");
        dundie.append(partNumber);
        dundie.append("\n");
        dundie.append(processorType);
        return dundie.toString();
    }

}
