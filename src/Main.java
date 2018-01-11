
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
       LaptopParser parser = new LaptopParser("C:\\Users\\Adrian\\OneDrive\\TexpertV2\\data\\LaptopURLs");
        parser.parseLaptops();

        for (Laptop next : LaptopManager.getInstance().getLaptops()) {
           next.print();
        }
        System.out.println();
    }
}
