import main.model.Laptop;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	        /*String offline = "\"C:\\Users\\Adrian\\OneDrive\\Texpert\\Dell XPS 15 Touch 15.6_ Ultra Thin 4K Notebook Intel Core i7-7700HQ 2.8GHz 16 GB RAM 512 GB SSD NVIDIA GeForce GTX 1050 4GB Windows 10 Home - Newegg.ca.html\"";
        String online = "https://www.newegg.ca/Product/Product.aspx?Item=9SIA66K6KY5646&cm_re=xps15-_-9SIA66K6KY5646-_-Product";
        Connection connection = Jsoup.connect(online);
        Document doc = connection.get();
        Element specs = doc.getElementById("Specs");


        org.jsoup.select.Elements left = specs.select("dt");
        List<String> leftList = left.eachText();
        System.out.println(leftList);

        org.jsoup.select.Elements right = specs.select("dd");
        List<String> rightList = right.eachText();
        System.out.println(rightList);*/
        Laptop.parseLaptop();
        System.out.println(Laptop.printLaptop());

        //just to push
    }
}
