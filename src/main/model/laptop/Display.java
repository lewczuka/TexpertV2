package main.model.laptop;

public class Display {
    // TODO: add further display details: type, refresh, color, brightness, etc.

    private String name;

    private double size; // in inches
    private String touch;
    private String res; // width by height
    private int resWidth; // in pixels
    private int resHeight; // in pixels

    public Display(double size, String touch, String res, int resWidth, int resHeight) {
        this.size = size;
        this.touch = touch;
        this.res = res;
        this.resWidth = resWidth;
        this.resHeight = resHeight;

        this.name = size + "\" " + res + printTouch(touch);
    }

    public String getName() {
        if (size == 0.0
                && touch.equals("")
                && res.equals("")
                && resWidth == 0
                && resHeight == 0)
            return "Not available.";
        return name;
    }

    public double getSize() {
        return size;
    }

    public String isTouch() {
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

    private String printTouch(String touch){
        if (touch.equals("Yes"))
            return "Touchscreen";
        return "";
    }
}
