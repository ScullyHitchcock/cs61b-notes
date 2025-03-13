public class Test {
    public static void main(String[] args) {
        WeightedQuickUnionWithPathCompressionDs testArr = new WeightedQuickUnionWithPathCompressionDs(9);
        testArr.connect(2, 3);
        testArr.connect(1, 2);
        testArr.connect(5, 7);
        testArr.connect(4, 8);
        testArr.connect(7, 2);
        int res1 = testArr.root(3);
        testArr.connect(0, 6);
        testArr.connect(6, 4);
        testArr.connect(6, 3);
        int res2 = testArr.root(4);
        int res3 = testArr.root(8);
        System.out.println(res1 + res2 + res3);
    }
}
