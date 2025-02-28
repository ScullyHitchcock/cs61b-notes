package src;
public class TestSort {
    public static void testFindSmallestString1() {
        String[] input = {"i", "have", "an", "egg"};
        int expect = 2;
        int actual = StringSort.findSmallestString(input, 0);
        org.junit.Assert.assertEquals(expect, actual);
    }

    public static void testFindSmallestString2() {
        String[] input = {"there", "are", "many", "pigs"};
        int expect = 1;
        int actual = StringSort.findSmallestString(input, 0);
        org.junit.Assert.assertEquals(expect, actual);
    }

    public static void testSwapElements1() {
        String[] before = {"i", "have", "an", "egg"};
        int index1 = 2;
        int index2 = 0;
        String[] expect = {"an", "have", "i", "egg"};
        StringSort.swapElements(before, index1, index2);
        org.junit.Assert.assertEquals(expect, before);
    }

    public static void testSwapElements2() {
        String[] before = {"there", "are", "many", "pigs"};
        int index1 = 3;
        int index2 = 0;
        String[] expect = {"pigs", "are", "many", "there"};
        StringSort.swapElements(before, index1, index2);
        org.junit.Assert.assertEquals(expect, before);
    }

    public static void testSort() {
        String[] strs = {"i", "have", "an", "egg"};
        String[] expect = {"an", "egg", "have", "i"};
        StringSort.sort(strs, 0);
        org.junit.Assert.assertEquals(expect, strs);
    }

    public static void main(String[] args) {
        testFindSmallestString1();
        testFindSmallestString2();
        testSwapElements1();
        testSwapElements2();
        testSort();
    }
}
