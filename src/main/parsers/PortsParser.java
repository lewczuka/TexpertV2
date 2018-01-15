package main.parsers;

import main.model.laptop.Ports;

import java.util.List;

public class PortsParser {

    protected static Ports parsePorts(List<String> leftList, List<String> rightList){
        String tempPortUSB = "";
        String tempPortHDMI = "";
        String tempPortAudio = "";

        for (int i = 0; i < leftList.size(); i++) {
            String feature = leftList.get(i);
            switch (feature) {
                case "USB":
                    tempPortUSB = rightList.get(i);
                    break;
                case "HDMI":
                    tempPortHDMI = rightList.get(i);
                    break;
                case "Audio Ports": tempPortAudio = rightList.get(i);
            }
        }

        return new Ports (tempPortUSB, tempPortHDMI, tempPortAudio);
    }
}
