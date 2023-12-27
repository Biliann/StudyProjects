public class nBody {
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double deltaT = Double.parseDouble(args[1]);

        int n = StdIn.readInt();
        double radius = StdIn.readDouble();
        double[] px = new double[n];
        double[] py = new double[n];
        double[] vx = new double[n];
        double[] vy = new double[n];
        double[] mass = new double[n];
        String[] image = new String[n];
        double G = 6.67e-11;
        double[] Fx = new double[n];
        double[] Fy = new double[n];

        //double rx = 0.0, ry = 0.0;

        new Thread(() -> StdAudio.play("2001.wav")).start();
        for (int i = 0; i < n; i++) {
            px[i] = StdIn.readDouble();
            py[i] = StdIn.readDouble();
            vx[i] = StdIn.readDouble();
            vy[i] = StdIn.readDouble();
            mass[i] = StdIn.readDouble();
            image[i] = StdIn.readString();
        }
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);
        StdDraw.enableDoubleBuffering();

        double t = 0;
        while (t < T) {
            for (int i = 0; i < n; i++) {
                Fx[i] = 0.0;
                Fy[i] = 0.0;

                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        double dx = px[j] - px[i];
                        double dy = py[j] - py[i];
                        double r = Math.sqrt(dx * dx + dy * dy);
                        double F = (G * mass[i] * mass[j]) / (r * r);
                        Fx[i] += F * dx / r;
                        Fy[i] += F * dy / r;
                    }
                }
            }

                // draw planet for px, py -> draw
                for (int k = 0; k < n; k++) {
                    double ax = Fx[k] / mass[k];
                    double ay = Fy[k] / mass[k];
                    // calculate vx, vy -> velocities
                    vx[k] += ax * deltaT;
                    vy[k] += ay * deltaT;
                    // calcuate px, py -> positions
                    px[k] += vx[k] * deltaT;
                    py[k] += vy[k] * deltaT;
                }




            StdDraw.picture(0.0, 0.0, "starfield.jpg");

            for (int i = 0; i < n; i++) {
                StdDraw.picture(px[i], py[i], image[i]);
            }
            StdDraw.show();
            StdDraw.pause(20);
            t += deltaT;



        }

    }
}



