package main.model;

import main.model.laptop.*;

public class Laptop {
    // TODO: revise field types...enums, ints, etc.
    // TODO: potentially add WLAN, vid port, type, battery, style, backlit, webcam etc.
    // TODO: account for nulls in constructors

    private String sellerID;
    private Product product;
    private CPU cpu;
    private Display display;
    private String os; // TODO: parse type and version separately
    private GPU gpu;
    private Storage storage;
    private RAM ram;
    private String opticalDrive;
    private Ports ports;

    public Laptop(String sellerID, Product product, CPU cpu, Display display, String os, GPU gpu, Storage storage, RAM ram, String opticalDrive, Ports ports) {
        this.sellerID = sellerID;
        this.product = product;
        this.cpu = cpu;
        this.display = display;
        this.os = os;
        this.gpu = gpu;
        this.storage = storage;
        this.ram = ram;
        this.opticalDrive = opticalDrive;
        this.ports = ports;
    }

    public void print(){
        System.out.println("----------");
        System.out.println("Seller ID: " + sellerID);
        System.out.println("Product: " + product.getName());
        System.out.println("CPU: " + cpu.getName());
        System.out.println("Display: " + display.getName());
        System.out.println("OS: " + os);
        System.out.println("GPU: " + gpu.getName());
        System.out.println("Storage: " + storage.getName());
        System.out.println("RAM: " + ram.getName());
        System.out.println("Optical Drive: " + opticalDrive);
        // TODO: add printout for ports
    }

    public Product getProduct() {
        return product;
    }

    public CPU getCpu() {
        return cpu;
    }

    public Display getDisplay() {
        return display;
    }

    public String getOs() {
        return os;
    }

    public GPU getGpu() {
        return gpu;
    }

    public Storage getStorage() {
        return storage;
    }

    public RAM getRam() {
        return ram;
    }

    public String getOpticalDrive() {
        return opticalDrive;
    }

    public Ports getPorts() {
        return ports;
    }
}
