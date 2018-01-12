package main.parsers;

import main.model.laptop.RAM;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RAMParser {
    // TODO: add an error output option

    protected static RAM parseRAM(List<String> leftList, List<String> rightList){
        double tempAmount = 0;
        String tempSpeed = null;

        for (int i = 0; i < leftList.size(); i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "Memory":
                    tempAmount = parseAmount(rightList.get(i));
                    break;
                case "Memory Speed":
                    tempSpeed = rightList.get(i);
                    break;
           }
        }

        RAM tempRAM = null;
        if (tempAmount != 0
                && tempSpeed != null)
            tempRAM = new RAM(tempAmount, tempSpeed);

        return tempRAM;
    }

    private static double parseAmount(String input){
        Pattern amountPattern = Pattern.compile("(\\d+)\\s([A-Z])B");
        Matcher amountMatcher = amountPattern.matcher(input);
        amountMatcher.find();
        String match = amountMatcher.group(1);
        String unit = amountMatcher.group(2);

        double multiplier;

        if (unit.equals("M"))
            // Can only be MB or GB
            multiplier = 0.001;
        else multiplier = 1;

        double amount = Integer.parseInt(match) * multiplier;
        return amount;
    }



}
