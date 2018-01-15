package main.parsers;

import main.exception.ParsingException;
import main.model.laptop.GPU;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GPUParser {

    protected static GPU parseGPU(List<String> leftList, List<String> rightList){
        String tempType = "";
        String tempChip = "";
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
                case "Video Memory":
                    try {
                        tempVRAM = parseVRAM(rightList.get(i));
                    } catch (ParsingException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
       return new GPU(tempType, tempChip, tempVRAM);
    }

    private static int parseVRAM(String input) throws ParsingException {
        Pattern vramPattern = Pattern.compile("\\d+");
        Matcher vramMatcher = vramPattern.matcher(input);
        if(vramMatcher.find()){
            String match = vramMatcher.group(0);
            int vram = Integer.parseInt(match);
            return vram;
        }
        if (input.contains("Shared")){
            int vram = 0;
            return vram;
        }
        throw new ParsingException("GPU VRAM not found, input: " + input);
    }
}
