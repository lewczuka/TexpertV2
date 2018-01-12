package main.parsers;

import main.model.laptop.Dimensions;
import main.model.laptop.Product;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProductParser {

    protected static Product parseProduct(List<String> leftList, List<String> rightList){
        // TODO: add an error output option
        String tempMakerID = null;
        String tempBrand = null;
        String tempSeries = null;
        String tempModel = null;
        Dimensions tempDimensions = null;
        String tempWeight = null;

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
                case "Dimensions (W x D x H)" : tempDimensions = parseDimensions(rightList.get(i));
                break;
                case "Weight" : tempWeight = rightList.get(i);
            }
        }

        Product tempProduct = null;
        if (tempMakerID != null
                && tempBrand != null
                && tempSeries != null
                && tempModel != null
                && tempDimensions != null
                && tempWeight != null)
            tempProduct = new Product(tempMakerID, tempBrand, tempSeries, tempModel, tempDimensions, tempWeight);

        return tempProduct;
    }

    protected static Dimensions parseDimensions(String input) {

        Pattern dimPattern = Pattern.compile("([^\"\\s-]+)(\")");
        Matcher dimMatcher = dimPattern.matcher(input);
        dimMatcher.find();
        String match1 = dimMatcher.group(1);
        double width = Double.parseDouble(match1);

        dimMatcher.find();
        String match2 = dimMatcher.group(1);
        double depth = Double.parseDouble(match2);

        dimMatcher.find();
        String match3 = dimMatcher.group(1);
        double height = Double.parseDouble(match3);

        return new Dimensions(width, depth, height);
    }

}
