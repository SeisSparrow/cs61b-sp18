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

      allPlanets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(),in.readDouble(),in.readString());
    }

    return allPlanets;
  }

  //public static void main(String[] args) {

//    double T = Double.parseDouble(args[0]);
//    double dt = Double.parseDouble(args[1]);
//    String filename = args[2];

//  }

}
