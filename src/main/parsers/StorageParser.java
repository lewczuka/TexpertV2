package main.parsers;

import main.exception.ParsingException;
import main.model.laptop.Storage;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StorageParser {

    protected static Storage parseStorage(List<String> leftList, List<String> rightList) {
        String tempSSD = "";
        int tempSSDAmount = 0;
        String tempHDD = "";
        int tempHDDAmount = 0;

        for (int i = 0; i < leftList.size(); i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "SSD":
                    tempSSD = rightList.get(i);
                    try {
                        tempSSDAmount = parseAmount(tempSSD);
                    } catch (ParsingException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HDD":
                    tempHDD = rightList.get(i);
                    try {
                        tempHDDAmount = parseAmount(tempHDD);
                    } catch (ParsingException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
        return new Storage(tempSSD, tempSSDAmount, tempHDD, tempHDDAmount);
    }

    private static int parseAmount(String input) throws ParsingException {
        Pattern amountPattern = Pattern.compile("(\\d+)\\s?([A-Z])B");
        Matcher amountMatcher = amountPattern.matcher(input);

        if (amountMatcher.find()) {
            String match = amountMatcher.group(1);
            String unit = amountMatcher.group(2);

            int multiplier;
            if (unit.equals("T"))
                // Can only be TB or GB
                multiplier = 1000;
            else multiplier = 1;

            int amount = Integer.parseInt(match) * multiplier;
            return amount;
        }

        if(input.contains("No"))
            return 0;

        throw new ParsingException("Storage amount not found, input: " + input);
    }
}
