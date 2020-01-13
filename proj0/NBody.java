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

    /* Clears the drawing window. */

    /* Stamps three copies of advice.png in a triangular pattern. */
    StdDraw.picture(0, 0, "images/starfield.jpg");

    for (int i = 0; i < Planets.length; i++) {

      Planets[i].imgFileName = "images/" + Planets[i].imgFileName;
      Planets[i].draw();
    }

    /* Shows the drawing to the screen, and waits 2000 milliseconds. */
    StdDraw.show();
  }

}
