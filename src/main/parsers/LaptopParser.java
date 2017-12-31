package main.parsers;

import main.model.Laptop;
import main.model.LaptopManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LaptopParser {
    private static List<String> urlList;

    public static void loadURLs() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\Adrian\\OneDrive\\TexpertV2\\data\\LaptopURLs"));
        String line;

        List<String> list = new ArrayList<>();
        while((line = file.readLine()) != null){
            list.add(line.replaceAll("\"",""));
        }

        urlList = list;
    }

    public static void parseLaptops() {
        for (String URL : urlList) {
            try {
                parseLaptop(URL);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void parseLaptop(String URL) throws IOException {
        Laptop laptop = new Laptop();

        String online = "https://www.newegg.ca/Product/Product.aspx?item=9SIA66K6KY5646";
        //Connection connection = Jsoup.connect(online);
        //Document doc = connection.get();

        File offline = new File(URL);
        Document doc = Jsoup.parse(offline, "UTF-8");
        Element specs = doc.getElementById("Specs");

        org.jsoup.select.Elements left = specs.select("dt");
        List<String> leftList = left.eachText();

        org.jsoup.select.Elements right = specs.select("dd");
        List<String> rightList = right.eachText();

        for (int i = 0; i < leftList.size() ; i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "Brand" : laptop.setBrand(rightList.get(i));
                case "Series" : laptop.setSeries(rightList.get(i));
                case "Model" : laptop.setModel(rightList.get(i));
                case "Part Number" : laptop.setPartNumber(rightList.get(i));
                case "CPU Type" : laptop.setProcessorType(rightList.get(i));
            }
        }

        LaptopManager.getInstance().addLaptop(laptop);
    }

}
