public class ForLoop {
    public static int max(int[] m) {
        int themax = m[0];
        for (int i : m) {
            if (i > themax) {
                themax = i;
            }
        }
        return themax;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(numbers));
    }
}
