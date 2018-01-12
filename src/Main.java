
import main.model.Laptop;
import main.model.LaptopManager;
import main.parsers.LaptopParser;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

       LaptopParser parser = new LaptopParser("C:\\Users\\Adrian\\OneDrive\\TexpertV2\\data\\LaptopURLs");
        parser.parseLaptops();

        for (Laptop next : LaptopManager.getInstance().getLaptops()) {
           next.print();
        }
    }
}
