package main.model.laptop;

public class Storage {
    private String name;

    private String ssd; // TODO: add more details...PCIe, etc.
    private int ssdAmount; // in GB
    private String hdd; // TODO: add more details...rpm, etc.
    private int hddAmount; // in GB

    public Storage(String ssd, int ssdAmount, String hdd, int hddAmount) {
        this.ssd = ssd;
        this.ssdAmount = ssdAmount;
        this.hdd = hdd;
        this.hddAmount = hddAmount;

        this.name = ssd + " SSD +" + hdd + " HDD";
    }

    public String getName() {
        return name;
    }

    public String getSsd() {
        return ssd;
    }

    public int getSsdAmount() {
        return ssdAmount;
    }

    public String getHdd() {
        return hdd;
    }

    public int getHddAmount() {
        return hddAmount;
    }
}
