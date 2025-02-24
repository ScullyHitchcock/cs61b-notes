/** 定义方法 */

public class LargerDemo {
    /** Return the larger number of x and y. */
    public static int larger(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }
    public static void main(String[] args) {
        int res = larger(10, 20);
        System.out.println(res);
    }
}
/*
1. 方法（method）必在 class 中声明（public static）。
2. 所有参数和返回值都必须先声明类型
 */