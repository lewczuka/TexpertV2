package main.model.laptop;

public class Ports {
    // TODO: add more details
    // TODO: add name alternative - print function

    private String portUSB;
    private String portHDMI;
    private String portAudio;

    public Ports(String portUSB, String portHDMI, String portAudio) {
        this.portUSB = portUSB;
        this.portHDMI = portHDMI;
        this.portAudio = portAudio;
    }

    public String getPortUSB() {
        return portUSB;
    }

    public String getPortHDMI() {
        return portHDMI;
    }

    public String getPortAudio() {
        return portAudio;
    }
}
