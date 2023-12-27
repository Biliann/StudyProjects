public class CarOOP {
    // parameters  = instance variables
    private static int wheelsCount; // static = common value
    private int year;
    private String color;
    private double volume;

    public CarOOP(int w, int y, String c, double v) {
        wheelsCount = w;
        year = y;
        color = c;
        volume = v;
    }

    // getters
    public int getWheelsCount() {
        return wheelsCount;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        CarOOP redFerrari = new CarOOP(4, 2023, "red", 5.0);
        CarOOP BMWx5 = new CarOOP(4, 2020, "black", 0.0);
        CarOOP lada = new CarOOP(4, 1987, "white", 3.5);
        System.out.println(lada.getColor());

    }

}
