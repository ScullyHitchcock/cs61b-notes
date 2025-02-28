import org.junit.Test;
import static org.junit.Assert.*;

public class TestIntList {

    /** 测试 size() 方法 */
    @Test
    public void testSize() {
        // 输入对象：包含多个元素的 IntList
        IntList input = new IntList(1, new IntList(2, new IntList(3, null)));

        // 预期输出
        int expect = 3;

        // 实际调用 size() 方法
        int actual = input.size();

        // 断言
        assertEquals(expect, actual);
    }

    @Test
    public void testSizeSingle() {
        // 输入对象：仅包含一个元素的 IntList
        IntList input = new IntList(42);

        // 预期输出
        int expect = 1;

        // 实际调用 size() 方法
        int actual = input.size();

        // 断言
        assertEquals(expect, actual);
    }

    /** 测试 get(int index) 方法 */
    @Test
    public void testGet() {
        // 输入对象
        IntList input = new IntList(1, new IntList(2, new IntList(3, null)));

        // 预期输出
        int expect = 2;

        // 实际调用 get(1) 方法
        int actual = input.get(1);

        // 断言
        assertEquals(expect, actual);
    }

    @Test
    public void testGetFirstElement() {
        // 输入对象
        IntList input = new IntList(5, new IntList(10, new IntList(15, null)));

        // 预期输出
        int expect = 5;

        // 实际调用 get(0) 方法
        int actual = input.get(0);

        // 断言
        assertEquals(expect, actual);
    }

    @Test
    public void testGetLastElement() {
        // 输入对象
        IntList input = new IntList(3, new IntList(6, new IntList(9, null)));

        // 预期输出
        int expect = 9;

        // 实际调用 get(2) 方法
        int actual = input.get(2);

        // 断言
        assertEquals(expect, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        // 输入对象
        IntList input = new IntList(1, new IntList(2, null));

        // 尝试访问超出范围的索引，应抛出异常
        input.get(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNegativeIndex() {
        // 输入对象
        IntList input = new IntList(10, new IntList(20, null));

        // 尝试访问负索引，应抛出异常
        input.get(-1);
    }
}