import java.util.Iterator;
import java.util.*;

public class FilteredList<T> implements Iterable<T>{
    List<T> L;
    Predicate<T> filter;

    public FilteredList (List<T> L, Predicate<T> filter) {
        this.L = L;
        this.filter = filter;
    }

    @Override
    public Iterator<T> iterator() {
        return new FilterIterator();
    }

    private class FilterIterator implements Iterator<T>{
        int index;

        public FilterIterator() {
            index = 0;
            locateValidIndex();
        }

        private void locateValidIndex() {
            while (hasNext()) {
                if (!filter.test(L.get(index))) {
                    index += 1;
                } else {
                    break;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return index < L.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = L.get(index);
            index += 1;
            locateValidIndex();
            return item;
        }
    }
}