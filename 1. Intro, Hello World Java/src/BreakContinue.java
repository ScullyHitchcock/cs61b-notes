/** Write a function windowPosSum(int[] a, int n) that replaces each element a[i] with the sum of a[i] through a[i + n],
 * but only if a[i] is positive valued.
 * If there are not enough values because we reach the end of the array,
 * we sum only as many values as we have. */

public class BreakContinue {
    public static void windowPosSum(int[] a, int n) {
        /** your code here */
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                continue;
            }
            for (int j = i+1; j < a.length; j++) {
                a[i] += a[j];
                if (j == n+i) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}
