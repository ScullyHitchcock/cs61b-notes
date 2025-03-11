public class SLList<Item> implements List61B<Item>{
    private class IntNode {
        public Item item;
        public IntNode next;

        public IntNode(Item i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;

    /** Creates an empty timingtest.SLList. */
    public SLList() {
        sentinel = new IntNode(null, null);
        size = 0;
    }

    public SLList(Item x) {
        sentinel = new IntNode(null, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    @Override
    /** Adds x to the front of the list. */
    public void addFirst(Item x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size = size + 1;
    }

    @Override
    /** Returns the first item in the list. */
    public Item getFirst() {
        return sentinel.next.item;
    }

    @Override
    /** Adds x to the end of the list. */
    public void addLast(Item x) {
        size = size + 1;

        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    @Override
    /** returns last item in the list */
    public Item getLast() {
        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        return p.item;
    }

    @Override
    public Item removeLast() {
        return null;
    }

    @Override
    public Item get(int i) {
        return null;
    }

    @Override
    public void insert(Item x, int position) {

    }


    /** Returns the size of the list. */
    public int size() {
        return size;
    }
}
