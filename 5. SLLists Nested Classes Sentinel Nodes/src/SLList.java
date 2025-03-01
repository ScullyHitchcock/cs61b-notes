package src;

public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    /** sentinel 是一个 哨兵节点，它的 item 值没有实际意义，主要用于：
     *	统一链表操作，避免 null 检查。
     *	使插入、删除、遍历等操作更加简洁。
     *	让 SLList 始终有一个固定的头部，减少边界情况的处理。 */
    private IntNode sentinel;
    private int size;

    /** Create an empty list. */
    public SLList() {
        sentinel = new IntNode (0, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode (0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the list.*/
    public void addFirst(int f) {
        sentinel.next = new IntNode(f, sentinel.next);
        size ++;
    }

    /** Returns the first item of the list.*/
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int l) {
        IntNode list = sentinel;
        while (list.next != null) {
            list = list.next;
        }
        list.next = new IntNode(l, null);
        size ++;
    }

    /** Returns the last item of the list.*/
    public int getLast() {
        IntNode list = sentinel;
        while (list.next != null) {
            list = list.next;
        }
        return list.item;
    }

    /** Returns the length of the list. */
    public int size() {
        return size;
    }
    /** Returns the length of the list recursively. */
    public int sizeRecursive() {
        return sizeRecursive(sentinel);
    }
    /** Helper method of SLList that returns the length of IntNode p recursively. */
    private int sizeRecursive(IntNode p) {
        if (p == null) {
            return 0;
        }
        return 1 + sizeRecursive(p.next);
    }

    public int getItem(int index) {
        IntNode list = sentinel.next;
        for (int i = 0; i < index; i++) {
            list = list.next;
        }
        return list.item;
    }
}
