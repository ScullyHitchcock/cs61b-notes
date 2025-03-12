public class Filter<T> implements Predicate<T>{
    @Override
    public boolean test(T x) {
        return x.equals(1);
    }
}
