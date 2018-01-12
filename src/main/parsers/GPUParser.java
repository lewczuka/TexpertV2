package main.parsers;

import main.model.laptop.GPU;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GPUParser {

    protected static GPU parseGPU(List<String> leftList, List<String> rightList){
        String tempType = null;
        String tempChip = null;
        int tempVRAM = 0;

        for (int i = 0; i < leftList.size(); i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "Graphic Type":
                    tempType = rightList.get(i);
                    break;
                case "GPU/VPU":
                    tempChip = rightList.get(i);
                    break;
                case "Video Memory": tempVRAM = parseVRAM(rightList.get(i));
            }
        }

        GPU tempGPU = null;
        if (tempType != null
                && tempChip != null
                && tempVRAM != 0)
            tempGPU = new GPU(tempType, tempChip, tempVRAM);

        return tempGPU;
    }

    private static int parseVRAM(String input) {
        // TODO: modify for shared VRAM
        Pattern vramPattern = Pattern.compile("\\d+");
        Matcher vramMatcher = vramPattern.matcher(input);
        vramMatcher.find();
        try {
            String match = vramMatcher.group(0);
            int vram = Integer.parseInt(match);
        } catch (IllegalStateException e) {
            System.out.println("VRAM cannot be parsed");
        }
        int vram = 0;
        // TODO: this is a temporary fix for shared memory
        return vram;
    }
}
