package src;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] arr, int start) {
        if (start < arr.length) {
            int iSmall = start;
            for (int i = start + 1; i < arr.length; i++) {
                if (arr[i] < arr[iSmall]) {
                    iSmall = i;
                }
            }
            int temp = arr[start];
            arr[start] = arr[iSmall];
            arr[iSmall] = temp;
            sort(arr, start + 1);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        sort(arr, 0);
        System.out.println(Arrays.toString(arr));
    }
}
