package main.model.laptop;

public class GPU {
    // TODO: modify for integrated cards
    private String name;
    private String type;
    private String chip; // TODO: add more info...brand, etc.
    private int vram; // if 0 then shared, TODO: add more info...type, speed, etc.

    public GPU(String type, String chip, int vram) {
        this.type = type;
        this.chip = chip;
        this.vram = vram;

        this.name = chip + vram + "GB";
    }

    public String getName() {
        if (type.equals("")
                && chip.equals("")
                && vram == 0)
            return "Not available.";
        return name;
    }

    public String getType() {
        return type;
    }

    public String getChip() {
        return chip;
    }

    public int getVram() {
        return vram;
    }
}
