public class EvenOdd {
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
    public static void evenOdd(IntList lst) {
        if (lst == null || lst.rest == null) {
            return;
        }
        IntList evenPointer = lst; // Create a pointer to even node.
        IntList oddPointer = lst.rest; // Create a pointer to odd node.
        IntList firstOddPointer = lst.rest; // Create a pointer to the first odd node for the final linking of the two Nodes.
        while (evenPointer.rest != null && oddPointer.rest != null) { // Stop the loop when one of the pointers reaches the end.
            evenPointer.rest = evenPointer.rest.rest; // Reset the even node.rest to point to the next evenNode.
            oddPointer.rest = oddPointer.rest.rest; // Reset the odd node.rest to point to the next oddNode.
            evenPointer = evenPointer.rest; // Move the even pointer to the next even node.
            oddPointer = oddPointer.rest; // Move the odd pointer to the next odd node.
        }
        evenPointer.rest = firstOddPointer; // Set the last even node.rest to point to the first odd node(link them together).
    }
    public static void main(String[] args) {
        IntList l = new IntList(0, new IntList(1, new IntList(2, new IntList(3, new IntList(4, new IntList(5))))));
        evenOdd(l);
        System.out.println(l);
    }
}

