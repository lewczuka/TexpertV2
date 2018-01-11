
package main.parsers;

import main.model.Laptop;
import main.model.LaptopManager;
import main.model.laptop.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static main.parsers.CPUParser.parseCPU;
import static main.parsers.ProductParser.parseProduct;

public class LaptopParser {
    private List<String> urlList;

    public LaptopParser(String filepath) throws IOException{
        // TODO: handle IOException
        BufferedReader URLs = new BufferedReader(new FileReader(filepath));
        String URL;

        urlList = new ArrayList<>();
        while((URL = URLs.readLine()) != null){
            urlList.add(URL.replaceAll("\"",""));
        }
    }

    public void parseLaptops(){
        // TODO: Delete quick info bcuz info repeats and parser takes first instance
        int count = 0;
        for (String URL : urlList) {
            try {
                parseLaptop(URL);
            } catch (IOException e) {
                count++;
            }
        }
        System.out.println(count + " laptops not parsed.");
    }

    private void parseLaptop(String URL) throws IOException {

        //String online = <<insert or build online URL>>;
        //Connection connection = Jsoup.connect(online);
        //Document doc = connection.get();

        File offline = new File(URL);
        Document doc = Jsoup.parse(offline, "UTF-8");

        // Parsing spec table
        Element specs = doc.getElementById("Specs");

        org.jsoup.select.Elements left = specs.select("dt");
        List<String> leftList = left.eachText();
        org.jsoup.select.Elements right = specs.select("dd");
        List<String> rightList = right.eachText();

        // Parsing header line
        Element header = doc.getElementById("baBreadcrumbTop");

        org.jsoup.select.Elements headerID = header.select("em");
        List<String> headerIDList = headerID.eachText();

        String tempSellerID = headerIDList.get(0);// TODO: check this

        String tempOS = null;
        String tempOpticalDrive = null;

        for (int i = 0; i < leftList.size() ; i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "Operating System" : tempOS = rightList.get(i);
                case "Optical Drive Type" : tempOpticalDrive = rightList.get(i);
            }
        }

        Product tempProduct = parseProduct(leftList, rightList);
        CPU tempCPU = parseCPU(leftList, rightList);
        Display tempDisplay = parseDisplay(leftList, rightList);
        GPU tempGPU = parseGPU(leftList, rightList);
        Storage tempStorage = parseStorage(leftList, rightList);
        RAM tempRAM = parseRAM(leftList, rightList);
        Ports tempPorts = parsePorts(leftList, rightList);

        Laptop tempLaptop = new Laptop(tempSellerID, tempProduct, tempCPU, tempDisplay, tempOS, tempGPU, tempStorage, tempRAM, tempOpticalDrive, tempPorts);
        LaptopManager.getInstance().addLaptop(tempLaptop);
    }

    protected static Dimensions parseDimensions(String dimensionString) {
        // TODO: parse dimensions with regex
    }



}
