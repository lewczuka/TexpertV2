package main.model.laptop;

public class RAM {
    private String name;

    private String amount; // in GB
    private String speed; // TODO: parse type and speed separately
    private int max; // in GB

    public RAM(String amount, String speed, int max) {
        this.amount = amount;
        this.speed = speed;
        this.max = max;

        this.name = amount + " GB " + speed;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public String getSpeed() {
        return speed;
    }

    public int getMax() {
        return max;
    }
}
