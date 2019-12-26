public class Ex2 {
   public static int max(int[] m) {
        int maximum = m[0];
	int i = 0;
	while (i < m.length) {
	    if (m[i] > maximum) {
		maximum = m[i];
	    }
	    i = i + 1;
	}
      	return maximum;
   }
   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};      
      System.out.println(max(numbers));
   }
}
