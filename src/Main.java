import main.model.Laptop;
import main.model.LaptopManager;
import main.parsers.LaptopParser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        LaptopParser.loadURLs("C:\\Users\\Adrian\\OneDrive\\TexpertV2\\data\\LaptopURLs");
        LaptopParser.parseLaptops();

        for (Laptop next : LaptopManager.getInstance().getLaptops()) {
           next.print();
        }
    }
}
