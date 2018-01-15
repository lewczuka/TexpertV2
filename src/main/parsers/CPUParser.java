package main.parsers;

import main.exception.ParsingException;
import main.model.laptop.CPU;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPUParser {

    protected static CPU parseCPU(List<String> leftList, List<String> rightList) {
        String tempType = "";
        double tempSpeed = 0.0;
        int tempCores = 0;

        for (int i = 0; i < leftList.size(); i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "CPU Type":
                    tempType = rightList.get(i);
                    break;
                case "CPU Speed":
                    try {
                        tempSpeed = parseSpeed(rightList.get(i));
                    } catch (ParsingException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Number of Cores":
                    try {
                        tempCores = parseCores(rightList.get(i));
                    } catch (ParsingException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
        return new CPU(tempType, tempSpeed, tempCores);
    }

    private static double parseSpeed(String input) throws ParsingException {
        Pattern speedPattern = Pattern.compile("(\\d+\\.?\\d*)\\s");
        Matcher speedMatcher = speedPattern.matcher(input);
        if(speedMatcher.find()){
            String match = speedMatcher.group(1);
            double speed = Double.parseDouble(match);
            return speed;
        }
        throw new ParsingException("CPU speed not found, input: " + input);
    }

    private static int parseCores(String input) throws ParsingException {
        switch(input){
            case "Single-core Processor": return 1;
            case "Dual-core Processor": return 2;
            case "Quad-core Processor": return 3;
            case "8-core Processor": return 4;
            default: throw new ParsingException("CPU cores not found, input: " + input);
        }
    }

}

