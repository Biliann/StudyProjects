import java.awt.Color;

public class Art {

    // Gives the instructions to go onto the next layer of drawings
    public static void nextStep(int n, double x, double y, double radius) {
        art(n - 1, x, y + radius, radius / 2);
        art(n - 1, x, y - radius, radius / 2);
        art(n - 1, x + radius, y, radius / 2);
        art(n - 1, x - radius, y, radius / 2);
    }

    // Loops through itself to make a pattern of circles
    public static void art(int n, double x, double y, double radius) {
        if (n == 0) return;
        if (n % 2 == 0) {
            StdDraw.setPenColor(Color.PINK);
        }
        else {
            StdDraw.setPenColor(Color.ORANGE);
        }
        StdDraw.filledCircle(x, y, radius);

        nextStep(n, x, y, radius);
    }

    // Main code that calls the first function
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        art(n, 0.5, 0.5, 0.25);
    }
}
