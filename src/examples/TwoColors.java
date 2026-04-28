// Example 2 — Two background color blocks side by side
// https://www.x-ray.world/
public class TwoColors {
    public static void main(String[] args) {
        String yellow = "\033[48;2;255;255;0m";
        String cyan   = "\033[48;2;0;255;255m";
        String reset  = "\033[0m";

        System.out.println(yellow + "                    " + cyan + "       " + reset);
    }
}
