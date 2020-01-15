public class NBody {

  public static double readRadius(String filename1) {
    In in = new In(filename1);

                    /* Every time you call a read method from the In class,
                     * it reads the next thing from the file, assuming it is
                     * of the specified type. */

                    /* Compare the calls below to the contents of BasicInDemo_input_file.txt */

   int N = in.readInt();
   double radiusofU = in.readDouble();
   return radiusofU;
  }

  public static Planet[] readPlanets(String filename1) {
    In in = new In(filename1);
    int N = in.readInt();
    double radiusofU = in.readDouble();
    Planet[] allPlanets = new Planet[N];

    for (int i = 0; i < N; i++) {

      allPlanets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(),
                                 in.readDouble(), in.readDouble(), in.readString());
    }

    return allPlanets;
  }

  public static void main(String[] args) {

    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];
    double radius = readRadius(filename);
    Planet[] Planets = readPlanets(filename);

    StdDraw.setScale(-1 * radius, radius);
    StdDraw.picture(0, 0, "images/starfield.jpg");

    for (int i = 0; i < Planets.length; i++) {

      Planets[i].imgFileName = "images/" + Planets[i].imgFileName;
      Planets[i].draw();
    }

    /* Shows the drawing to the screen, and waits 2000 milliseconds. */
    StdDraw.show();
    StdDraw.enableDoubleBuffering();

    for (double t = 0; t < T; t = t + dt) {

      double[] xForces = new double[Planets.length];
      double[] yForces = new double[Planets.length];

      for (int i = 0; i < Planets.length; i++) {

        xForces[i] = Planets[i].calcNetForceExertedByX(Planets);
        yForces[i] = Planets[i].calcNetForceExertedByX(Planets);
      }

      for (int i = 0; i < Planets.length; i++) {

        Planets[i].update(dt, xForces[i], yForces[i]);
      }

      StdDraw.setScale(-1 * radius, radius);
      StdDraw.picture(0, 0, "images/starfield.jpg");

      for (int i = 0; i < Planets.length; i++) {

        Planets[i].draw();
      }

      StdDraw.show();
      StdDraw.pause(10);
    }

    StdOut.printf("%d\n", Planets.length);
    StdOut.printf("%.2e\n", radius);
    for (int i = 0; i < Planets.length; i++) {

        Planets[i].imgFileName = Planets[i].imgFileName.replace("images/","");
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                  Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
    }
  }

}
