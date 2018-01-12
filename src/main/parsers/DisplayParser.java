package main.parsers;

import main.model.laptop.Display;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisplayParser {

    protected static Display parseDisplay(List<String> leftList, List<String> rightList) {
        // TODO: add an error output option

        double tempSize = 0;
        boolean tempTouch = false; // TODO: cannot be initialized to a real value
        String tempRes = null;
        int tempResWidth = 0;
        int tempResHeight = 0;

        for (int i = 0; i < leftList.size(); i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "Screen Size":
                    tempSize = parseSize(rightList.get(i));
                    break;
                case "Touchscreen":
                    tempTouch = parseTouch(rightList.get(i));
                    break;
                case "Resolution": tempRes = rightList.get(i);
            }
        }

        tempResWidth = parseWidth(tempRes);
        tempResHeight = parseHeight(tempRes);

        return new Display(tempSize, tempTouch, tempRes, tempResWidth, tempResHeight);
    }

    private static double parseSize(String input){
        Pattern sizePattern = Pattern.compile("(\\d*.?\\d*)\"");
        // TODO: double check regex
        Matcher sizeMatcher = sizePattern.matcher(input);
        sizeMatcher.find();
        String match = sizeMatcher.group(1);
        double size = Double.parseDouble(match);
        return size;
    }

    private static boolean parseTouch(String input){
        return (input.equals("Yes"));
    }

    private static int parseWidth(String input){
        Pattern widthPattern = Pattern.compile("(\\d*)\\sx");
        Matcher widthMatcher = widthPattern.matcher(input);
        widthMatcher.find();
        String match = widthMatcher.group(1);
        int width = Integer.parseInt(match);
        return width;
    }

    private static int parseHeight(String input){
        Pattern heightPattern = Pattern.compile("x\\s(\\d*)");
        Matcher heightMatcher = heightPattern.matcher(input);
        heightMatcher.find();
        String match = heightMatcher.group(1);
        int height = Integer.parseInt(match);
        return height;
    }
}
