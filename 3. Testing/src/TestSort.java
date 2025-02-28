package src;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    @Test
    public void testFindSmallestString1() {
        String[] input = {"i", "have", "an", "egg"};
        int expect = 2;
        int actual = StringSort.findSmallestString(input, 0);
        assertEquals(expect, actual);
    }
    @Test
    public void testFindSmallestString2() {
        String[] input = {"there", "are", "many", "pigs"};
        int expect = 1;
        int actual = StringSort.findSmallestString(input, 0);
        assertEquals(expect, actual);
    }
    @Test
    public void testSwapElements1() {
        String[] before = {"i", "have", "an", "egg"};
        int index1 = 2;
        int index2 = 0;
        String[] expect = {"an", "have", "i", "egg"};
        StringSort.swapElements(before, index1, index2);
        assertEquals(expect, before);
    }
    @Test
    public void testSwapElements2() {
        String[] before = {"there", "are", "many", "pigs"};
        int index1 = 3;
        int index2 = 0;
        String[] expect = {"pigs", "are", "many", "there"};
        StringSort.swapElements(before, index1, index2);
        assertEquals(expect, before);
    }
    @Test
    public void testSort() {
        String[] strs = {"i", "have", "an", "egg"};
        String[] expect = {"an", "egg", "have", "i"};
        StringSort.sort(strs, 0);
        assertEquals(expect, strs);
    }
}
