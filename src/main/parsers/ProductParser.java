package main.parsers;

import main.exception.ParsingException;
import main.model.laptop.Dimensions;
import main.model.laptop.Product;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProductParser {

    protected static Product parseProduct(List<String> leftList, List<String> rightList){
        String tempMakerID = "";
        String tempBrand = "";
        String tempSeries = "";
        String tempModel = "";
        Dimensions tempDimensions = new Dimensions(0.0, 0.0, 0.0);
        String tempWeight = "";

        for (int i = 0; i < leftList.size() ; i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "Part Number" : tempMakerID = rightList.get(i);
                break;
                case "Brand" : tempBrand = rightList.get(i);
                break;
                case "Series" : tempSeries = rightList.get(i);
                break;
                case "Model" : tempModel = rightList.get(i);
                break;
                case "Dimensions (W x D x H)" :
                    try {
                        tempDimensions = parseDimensions(rightList.get(i));
                    } catch (ParsingException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Weight" : tempWeight = rightList.get(i);
            }
        }
        return new Product(tempMakerID, tempBrand, tempSeries, tempModel, tempDimensions, tempWeight);
    }

    protected static Dimensions parseDimensions(String input) throws ParsingException {
        Pattern dimPattern = Pattern.compile("([^\"\\s-]+)(\")");
        Matcher dimMatcher = dimPattern.matcher(input);

        if (dimMatcher.find()) {
            String match1 = dimMatcher.group(1);
            double width = Double.parseDouble(match1);

            if(dimMatcher.find()) {
                String match2 = dimMatcher.group(1);
                double depth = Double.parseDouble(match2);

                if(dimMatcher.find()) {
                    String match3 = dimMatcher.group(1);
                    double height = Double.parseDouble(match3);

                    return new Dimensions(width, depth, height);
                }
            }
        }
        throw new ParsingException("Product dimensions not found, input: " + input);
    }
}
