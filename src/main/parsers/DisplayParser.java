package main.parsers;

import main.exception.ParsingException;
import main.model.laptop.Display;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisplayParser {

    protected static Display parseDisplay(List<String> leftList, List<String> rightList) {
        double tempSize = 0.0;
        String tempTouch = "";
        String tempRes = "";
        int tempResWidth = 0;
        int tempResHeight = 0;

        for (int i = 0; i < leftList.size(); i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "Screen Size":
                    try {
                        tempSize = parseSize(rightList.get(i));
                    } catch (ParsingException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Touchscreen":
                    tempTouch = rightList.get(i);
                    break;
                case "Resolution": tempRes = rightList.get(i);
                    try {
                        tempResWidth = parseWidth(tempRes);
                    } catch (ParsingException e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        tempResHeight = parseHeight(tempRes);
                    } catch (ParsingException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
        return new Display(tempSize, tempTouch, tempRes, tempResWidth, tempResHeight);
    }

    private static double parseSize(String input) throws ParsingException{
        Pattern sizePattern = Pattern.compile("(\\d*\\.?\\d*)\\\"");
        Matcher sizeMatcher = sizePattern.matcher(input);
        if (sizeMatcher.find()) {
            String match = sizeMatcher.group(1);
            double size = Double.parseDouble(match);
            return size;
        }
        throw new ParsingException("Display size not found, input: " + input);
    }

    private static int parseWidth(String input) throws ParsingException {
        Pattern widthPattern = Pattern.compile("(\\d*)\\sx");
        Matcher widthMatcher = widthPattern.matcher(input);
        if (widthMatcher.find()) {
            String match = widthMatcher.group(1);
            int width = Integer.parseInt(match);
            return width;
        }
        throw new ParsingException("Display width not found, input: " + input);
    }

    private static int parseHeight(String input) throws ParsingException {
        Pattern heightPattern = Pattern.compile("x\\s(\\d*)");
        Matcher heightMatcher = heightPattern.matcher(input);
        if (heightMatcher.find()) {
            String match = heightMatcher.group(1);
            int height = Integer.parseInt(match);
            return height;
        }
        throw new ParsingException("Display height not found, input: " + input);
    }
}
