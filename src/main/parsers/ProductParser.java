package main.parsers;

import main.model.laptop.Dimensions;
import main.model.laptop.Product;

import java.util.List;

import static main.parsers.LaptopParser.parseDimensions;

public class ProductParser {

    protected static Product parseProduct(List<String> leftList, List<String> rightList){
        // TODO: add an error output option
        String tempMakerID = null;
        String tempBrand = null;
        String tempSeries = null;
        String tempModel = null;
        String tempDimensionString = null;
        String tempWeight = null;

        for (int i = 0; i < leftList.size() ; i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "Part Number" : tempMakerID = rightList.get(i);
                case "Brand" : tempBrand = rightList.get(i);
                case "Series" : tempSeries = rightList.get(i);
                case "Model" : tempModel = rightList.get(i);
                case "Dimensions" : tempDimensionString = rightList.get(i);
                case "Weight" : tempWeight = rightList.get(i);
            }
        }

        Dimensions tempDimensions = parseDimensions(tempDimensionString);
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

}
