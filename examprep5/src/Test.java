public class Test {
    public static void main(String[] args) {
        Filter<Integer> f = new Filter<>();
        boolean res = f.test(1);
        System.out.println(res);

    }
}
