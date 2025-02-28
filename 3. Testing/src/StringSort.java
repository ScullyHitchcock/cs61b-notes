package src;

import java.util.Arrays;

public class StringSort {
    public static void main(String[] args) {
        // 1. Find the smallest string's index.
        // 2. Swap it with the first place.
        // 3. sort the rest.
        String[] strs = {"there", "are", "many", "pigs"};
        sort(strs, 0);
        System.out.println(Arrays.toString(strs));
    }

    public static int findSmallestString(String[] strs, int start) {
        int smallIndex = start;
        for (int i = start; i < strs.length; i++) {
            if (strs[i].compareTo(strs[smallIndex]) < 0) {
                smallIndex = i;
            }
        }
        return smallIndex;
    }

    public static void swapElements(String[] strs, int i, int j) {
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }

    public static void sort(String[] strs, int start) {
        if (start < strs.length) {
            int smIndex = findSmallestString(strs, start);
            swapElements(strs, start, smIndex);
            sort(strs, start + 1);
        }
    }
}
