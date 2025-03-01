package src;

public class BuildList {
    public static void main(String[] args) {
        SLList list = new SLList(10);
        list.addFirst(9);
        list.addFirst(8);
        list.addLast(11);
        System.out.println(list.size());
//        System.out.println(list.sizeRecursive());
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.getItem(1));
    }
}
