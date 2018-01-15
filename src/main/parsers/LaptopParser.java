
package main.parsers;

import main.model.Laptop;
import main.model.LaptopManager;
import main.model.laptop.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static main.parsers.CPUParser.parseCPU;
import static main.parsers.DisplayParser.parseDisplay;
import static main.parsers.GPUParser.parseGPU;
import static main.parsers.PortsParser.parsePorts;
import static main.parsers.ProductParser.parseProduct;
import static main.parsers.RAMParser.parseRAM;
import static main.parsers.StorageParser.parseStorage;

public class LaptopParser {
    private List<String> urlList;

    public LaptopParser(String filepath) {
        BufferedReader URLs = null;
        try {
            URLs = new BufferedReader(new FileReader(filepath));
        } catch (FileNotFoundException e) {
            System.out.println("File cannot be read.");
        }
        String URL;

        urlList = new ArrayList<>();
        int count = 0;
        try {
            while((URL = URLs.readLine()) != null){
                urlList.add(URL.replaceAll("\"",""));
            }
        } catch (IOException e) {
            count++;
        }
        System.out.println(count + " URLs not accessible.");
    }

    public void parseLaptops(){
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

        String tempSellerID = headerIDList.get(0);

        String tempOS = "Not available.";
        String tempOpticalDrive = "Not available.";

        for (int i = 0; i < leftList.size() ; i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "Operating System" : tempOS = rightList.get(i);
                break;
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
}
