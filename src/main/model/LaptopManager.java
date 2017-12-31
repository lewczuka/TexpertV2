package main.model;

import java.util.ArrayList;
import java.util.List;

public class LaptopManager {
    private static LaptopManager instance;
    private List<Laptop> laptops;

    public static LaptopManager getInstance() {
        if (instance == null)
            instance = new LaptopManager();

        return instance;
    }

    private LaptopManager() {
        laptops = new ArrayList<>();
    }

    public List<Laptop> getLaptops(){
        return laptops;
    }

    public void addLaptop(Laptop laptop){
        laptops.add(laptop);
    }
}

