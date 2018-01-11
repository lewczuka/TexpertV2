package main.model.laptop;

public class Display {
    // TODO: add further display details: type, refresh, color, brightness, etc.

    private String name;

    private double size; // in inches
    private boolean touch;
    private String res; // width by height
    private int resWidth; // in pixels
    private int resHeight; // in pixels

    public Display(double size, boolean touch, String res, int resWidth, int resHeight) {
        this.size = size;
        this.touch = touch;
        this.res = res;
        this.resWidth = resWidth;
        this.resHeight = resHeight;

        this.name = size + "\" " + res + printTouch(touch);
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public boolean isTouch() {
        return touch;
    }

    public String getRes(){
        return res;
    }

    public int getResWidth() {
        return resWidth;
    }

    public int getResHeight() {
        return resHeight;
    }

    private String printTouch(boolean touch){
        if (touch)
            return " Touch";
        else return "";
    }
}
