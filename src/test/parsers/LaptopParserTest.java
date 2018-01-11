package test.parsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LaptopParserTest {

    @BeforeEach
    public void startParser(){

    }

    @Test
    public void testParseLaptop(){}


    public static void loadSampleURLs() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\Adrian\\OneDrive\\TexpertV2\\data\\SampleLaptopURLs"));
        String line;

        List<String> list = new ArrayList<>();
        while((line = file.readLine()) != null){
            list.add(line.replaceAll("\"",""));
        }

        //urlList = list;
    }

}
