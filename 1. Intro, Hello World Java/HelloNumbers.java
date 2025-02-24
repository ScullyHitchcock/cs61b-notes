/** 循环Demo */

public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int total = x;
        while (x < 10) {
            System.out.print(total + " ");
            x += 1;
            total += x;
        }
        System.out.println();
        String h = 5 + "10";
        // 在 Java 中，如果你将一个数字与一个字符串相加（例如 5 + "h"），Java 会 自动将数字转换为字符串，
        // 然后进行字符串连接。这种操作称为字符串连接。
        System.out.println(h);
        int g = 5;
        System.out.println(g);
    }
}
/*
1. int x = 0; 变量在使用前必须先声明。
2. 变量必须要有特定的类型（int是整型）。
3. Java变量类型一旦确定就不能修改（如不可String x = "abc"）。
 */