package main.model;

public class Laptop {
    private String itemNumber;
    private String name = "";
    private static String brand = "";
    private static String series = "";
    private static String model = "";
    private static String partNumber = "";

    private static String processorType = "";
    private String processorSpeed = "";
    private String processorName = "";
    private String processorCores = "";

    private String screenSize = "";
    private String touchscreen = "";
    private String wideScreenSupport = "";
    private String displayType = "";
    private String resolution = "";
    private String lcdFeatures = "";

    private String operatingSystem = "";

    private String GPU = "";
    private String VRAM = "";

    public Laptop(){
    }

    public static String getBrand() {
        return brand;
    }

    public static void setBrand(String brand) {
        Laptop.brand = brand;
    }

    public static String getSeries() {
        return series;
    }

    public static void setSeries(String series) {
        Laptop.series = series;
    }

    public static String getModel() {
        return model;
    }

    public static void setModel(String model) {
        Laptop.model = model;
    }

    public static String getPartNumber() {
        return partNumber;
    }

    public static void setPartNumber(String partNumber) {
        Laptop.partNumber = partNumber;
    }

    public static String getProcessorType() {
        return processorType;
    }

    public static void setProcessorType(String processorType) {
        Laptop.processorType = processorType;
    }

    public void print(){
        System.out.println("----------");
        System.out.println(brand);
        System.out.println(series);
        System.out.println(model);
        System.out.println(partNumber);
        System.out.println(processorType);
    }
}
