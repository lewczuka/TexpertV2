package main.parsers;

import main.model.laptop.CPU;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPUParser {

    protected static CPU parseCPU(List<String> leftList, List<String> rightList) {
        System.out.println("Comp: " + rightList.get(0));
        // TODO: add an error output option
        String tempType = null;
        double tempSpeed = 0;
        int tempCores = 0;

        for (int i = 0; i < leftList.size(); i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "CPU Type":
                    tempType = rightList.get(i);
                    break;
                case "CPU Speed":
                    tempSpeed = parseSpeed(rightList.get(i));
                    break;
                case "Number of Cores": tempCores = parseCores(rightList.get(i));
            }
        }

        CPU tempCPU = null;
        if (tempType != null
                && tempSpeed != 0
                && tempCores != 0)
            tempCPU = new CPU(tempType, tempSpeed, tempCores);

        return tempCPU;
    }

    private static double parseSpeed(String input){
        Pattern speedPattern = Pattern.compile("(\\d+\\.?\\d*)\\s"); // change to (\d*\.?\d*)\s for no decimal???
        Matcher speedMatcher = speedPattern.matcher(input);
        speedMatcher.find();
        String match = speedMatcher.group(1);
        double speed = Double.parseDouble(match);
        return speed;
    }

    private static int parseCores(String input){
        int cores = 0;
        switch(input){
            case "Single-core Processor": cores = 1;
            break;
            case "Dual-core Processor": cores = 2;
            break;
            case "Quad-core Processor": cores = 3;
            break;
            case "8-core Processor": cores = 4;
            break;
        }
        return cores;
    }

}

