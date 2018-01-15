package main.model.laptop;

public class RAM {
    private String name;

    private double amount; // in GB
    private String speed; // TODO: parse type and speed separately

    public RAM(double amount, String speed) {
        this.amount = amount;
        this.speed = speed;

        this.name = amount + " GB " + speed;
    }

    public String getName() {
        if (amount == 0.0
                && speed.equals(""))
            return "Not available.";
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getSpeed() {
        return speed;
    }
}
