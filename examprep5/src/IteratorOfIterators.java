import java.util.*;

public class IteratorOfIterators implements Iterator {
    public LinkedList<Iterator<Integer>> list;
    public List<Iterator<Integer>> a;
    public IteratorOfIterators(List<Iterator<Integer>> a) {
        list = new LinkedList<>();
        for (Iterator<Integer> i: a) {
            if (i.hasNext()) {
                list.addLast(i);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Iterator<Integer> iterator = list.removeFirst();
        int res = iterator.next();
        if (iterator.hasNext()) {
            list.addLast(iterator);
        }
        return res;
    }
}
