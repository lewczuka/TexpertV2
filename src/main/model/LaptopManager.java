package main.model;

public class LaptopManager {
    private static LaptopManager instance = new LaptopManager();

    public static LaptopManager getInstance() {
        return instance;
    }

    private LaptopManager() {
    }
}

