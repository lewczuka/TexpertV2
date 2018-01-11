package main.model.laptop;

public class CPU {
    private String name;

    private String type; // TODO: parse brand and gen separately, adjust for AMD
    private double speed; // in GHz
    private int cores;

    public CPU(String type, double speed, int cores) {
        this.type = type;
        this.speed = speed;
        this.cores = cores;

        this.name = type + " " + speed + " GHz " + cores + "-core";
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getSpeed() {
        return speed;
    }

    public int getCores() {
        return cores;
    }
}
