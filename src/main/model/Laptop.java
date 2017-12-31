package main.model;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
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
        String online = "https://www.newegg.ca/Product/Product.aspx?item=9SIA66K6KY5646";
        //Connection connection = Jsoup.connect(online);
        //Document doc = connection.get();

        File offline = new File("C:\\Users\\Adrian\\OneDrive\\TexpertV2\\XPS15.html");
        Document doc = Jsoup.parse(offline, "UTF-8");
        Element specs = doc.getElementById("Specs");
        System.out.println(specs);

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
