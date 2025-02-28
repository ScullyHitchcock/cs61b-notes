import java.util.SplittableRandom;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public IntList(int f) {
        first = f;
        rest = null;
    }

    public int size() {
        IntList list = this;
        int count = 0;
        while (list != null) {
            count++;
            list = list.rest;
        }
        return count;
    }

    public int get(int index) {
        if (index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        IntList list = this;
        for (int i = 1; i <= index; i++) {
            list = list.rest;
        }
        return list.first;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        IntList current = this; // 遍历链表
        while (current != null) {
            sb.append(current.first);
            if (current.rest != null) {
                sb.append(" ");
            }
            current = current.rest;
        }

        sb.append(">");
        return sb.toString();
    }
}
