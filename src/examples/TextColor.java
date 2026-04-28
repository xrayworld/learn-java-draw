// Example 3 — Colored text (foreground) using code 38 instead of 48
// https://www.x-ray.world/
public class TextColor {
    public static void main(String[] args) {
        String textColor = "\033[38;2;0;255;255m";
        String reset     = "\033[0m";

        System.out.println(textColor + " X-Ray World " + reset);
    }
}
