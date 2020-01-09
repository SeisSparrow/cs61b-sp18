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

}
