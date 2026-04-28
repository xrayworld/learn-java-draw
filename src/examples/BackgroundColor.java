// Example 1 — Single background color block
// https://www.x-ray.world/
public class BackgroundColor {
    public static void main(String[] args) {
        int r = 255, g = 255, b = 0;

        String colorOn  = "\033[48;2;" + r + ";" + g + ";" + b + "m";
        String colorOff = "\033[0m";

        System.out.println(colorOn + " 0123456789876543210 " + colorOff);
    }
}
