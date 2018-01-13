package main.parsers;

import main.model.laptop.Storage;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StorageParser {

    protected static Storage parseStorage(List<String> leftList, List<String> rightList) {
        // TODO: add an error output option
        String tempSSD = null;
        int tempSSDAmount = 0;
        String tempHDD = null;
        int tempHDDAmount = 0;

        for (int i = 0; i < leftList.size(); i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "SSD":
                    tempSSD = rightList.get(i);
                    break;
                case "HDD":
                    tempHDD = rightList.get(i);
            }
        }

        if (tempSSD != null)
            tempSSDAmount = parseAmount(tempSSD);
        if (tempHDD != null)
            tempHDDAmount = parseAmount(tempHDD);

        Storage tempStorage = null;
        if (tempSSD != null
                && tempSSDAmount != 0
                && tempHDD != null
                && tempHDDAmount != 0)
            tempStorage = new Storage(tempSSD, tempSSDAmount, tempHDD, tempHDDAmount);

        return tempStorage;
    }

    private static int parseAmount(String input) {
        Pattern amountPattern = Pattern.compile("(\\d+)\\s([A-Z])B");
        Matcher amountMatcher = amountPattern.matcher(input);
        String match = null;
        String unit = null;

        if (amountMatcher.find()) {
            match = amountMatcher.group(1);
            unit = amountMatcher.group(2);
        }
        int multiplier = 0;

        if (match != null && unit != null) {
            if (unit.equals("T"))
                // Can only be TB or GB
                multiplier = 1000;
            else multiplier = 1;
        }

        int amount = 0;
        if (multiplier != 0)
            amount = Integer.parseInt(match) * multiplier;
        return amount;
    }
}
