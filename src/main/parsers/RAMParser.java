package main.parsers;

import main.exception.ParsingException;
import main.model.laptop.RAM;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RAMParser {

    protected static RAM parseRAM(List<String> leftList, List<String> rightList){
        double tempAmount = 0.0;
        String tempSpeed = "";

        for (int i = 0; i < leftList.size(); i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "Memory":
                    try {
                        tempAmount = parseAmount(rightList.get(i));
                    } catch (ParsingException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Memory Speed":
                    tempSpeed = rightList.get(i);
                    break;
           }
        }
        return new RAM(tempAmount, tempSpeed);
    }

    private static double parseAmount(String input) throws ParsingException {
        Pattern amountPattern = Pattern.compile("(\\d+)\\s?([A-Z])B");
        Matcher amountMatcher = amountPattern.matcher(input);
        if (amountMatcher.find()) {
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
        throw new ParsingException("RAM amount not parsed, input: " + input);
    }



}
