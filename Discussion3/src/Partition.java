public class Partition {
    public static class IntList {
        public int first;
        public IntList rest = null;

        public IntList(int f, IntList r) {
            this.first = f;
            this.rest = r;
        }
        public IntList(int f) {
            this.first = f;
        }

        @Override
        public String toString() {
            if (this.rest == null) {
                return String.valueOf(this.first); // 直接返回 first
            }
            return this.first + " " + this.rest.toString();
        }
    }
    public static IntList[] partition(IntList lst, int k) {
        IntList[] array = new IntList[k];
        int index = 0;
        IntList L = lst;
        while (L != null) {
            int f = L.first;
            array[index] = new IntList(f, array[index]);
            index = (index + 1) % array.length;
            L = L.rest;
        }
        return array;
    }
    public static void main(String[] args) {
        IntList l = new IntList(0, new IntList(1, new IntList(2, new IntList(3, new IntList(4, new IntList(5))))));
        IntList[] arr = partition(l, 2);
        System.out.println();
    }
}
